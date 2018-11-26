package tiles;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import blood.Blood;
import entities.Entity;
import entities.Tree;
import entities.Vector2D;
import entities.creatures.Player;
import entities.creatures.Zombie;
import graphics.Assets;
import main.Handler;
import main.Window;
import particles.Particle;

public class World {
	
	public static int WIDTH;
	public static int HEIGHT;
	private int[][] tiles = new int[][]{
		{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
		{0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
		{0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
	};
	
	private Handler handler;
	private ArrayList<Entity> zombiesAndBullets;
	private ArrayList<Particle> particles;
	private ArrayList<Entity> obstacles;
	private ArrayList<Blood> bloodSplats;
	private Player player;
	
	private Timer timer = new Timer(2000, event->{
		int x = (int)(Math.random()*500 + 700); 
		int y = (int)(Math.random()*500 + 500);
		System.out.printf("%d %d\n", x, y);
		zombiesAndBullets.add(new Zombie(new Vector2D(x, y), 2, player));
	});
	
	public World(Handler handler){
		this.handler = handler;
		WIDTH = tiles[0].length;
		HEIGHT = tiles.length;
		zombiesAndBullets = new ArrayList<Entity>();
		particles = new ArrayList<Particle>();
		obstacles = new ArrayList<Entity>();
		bloodSplats = new ArrayList<Blood>();
		player = new Player(new Vector2D(500, 500), 4, this);
		timer.start();

		obstacles.add(new Tree(handler, new Vector2D(400, 400), Assets.tree));
		obstacles.add(new Tree(handler, new Vector2D(500, 700), Assets.tree));
		obstacles.add(new Tree(handler, new Vector2D(700, 800), Assets.tree));
		obstacles.add(new Tree(handler, new Vector2D(250, 550), Assets.tree));
		obstacles.add(new Tree(handler, new Vector2D(300, 450), Assets.tree));
		obstacles.add(new Tree(handler, new Vector2D(700, 200), Assets.tree));
	}
	
	public void update(){
		player.update();
		for(int i = 0; i < zombiesAndBullets.size(); i++)
			zombiesAndBullets.get(i).update();
		for(int i = 0; i < particles.size(); i++)
			if(particles.get(i).update())
				particles.remove(i);
		for(int i = 0; i < obstacles.size(); i++)
			obstacles.get(i).update();
	}
	
	public void render(Graphics g){
		int x = (int) handler.getWindow().getCamera().getOffset().getX();
		int y = (int) handler.getWindow().getCamera().getOffset().getY();
		int xStart = (int)Math.max(0, x/Tile.TILESIZE);
		int yStart = (int)Math.max(0, y/Tile.TILESIZE);
		int xEnd = (int)Math.min(WIDTH, (x + Window.WIDTH)/Tile.TILESIZE + 1);
		int yEnd = (int)Math.min(HEIGHT, (y + Window.WIDTH)/Tile.TILESIZE + 1);
		for(int i = yStart; i < yEnd; i++){
			for(int j = xStart; j < xEnd; j++){
				getTile(i, j).render(g, new Vector2D(j*Tile.TILESIZE - x,
						i*Tile.TILESIZE - y));
			}
		}
		for(int i = 0; i < bloodSplats.size(); i++)
			bloodSplats.get(i).render(g);
		player.render(g);
		for(int i = 0; i < particles.size(); i++)
			particles.get(i).render(g);
		for(int i = 0; i < obstacles.size(); i++)
			obstacles.get(i).render(g);
		for(int i = 0; i < zombiesAndBullets.size(); i++)
			zombiesAndBullets.get(i).render(g);
		player.getCurrentGun().render(g);
	}

	public Tile getTile(int x, int y){
		Tile tile = Tile.tiles[tiles[x][y]];
		return tile;
	}

	public int getHealth(){
		return player.getHealth();
	}
	
	public Handler getHandler(){
		return handler;
	}
	public ArrayList<Entity> getZombiesAndBullets(){
		return zombiesAndBullets;
	}
	public ArrayList<Particle> getParticles(){
		return particles;
	}
	public ArrayList<Entity> getObstacles(){
		return obstacles;
	}
	public ArrayList<Blood> getBloodSplats(){
		return bloodSplats;
	}
}