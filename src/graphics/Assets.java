package graphics;

import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;
import utilities.Utilities;

public class Assets {
	public static BufferedImage[] pistolIdle = new BufferedImage[20];
	public static BufferedImage[] rifleIdle = new BufferedImage[20];
	public static BufferedImage[] pistolReload = new BufferedImage[15];
	public static BufferedImage[] rifleReload = new BufferedImage[20];
	public static BufferedImage[] pistolShootAnim = new BufferedImage[3];
	public static BufferedImage[] rifleShootAnim = new BufferedImage[3];
	
	public static BufferedImage[] zombie = new BufferedImage[8];
	public static BufferedImage[] zombieAttack = new BufferedImage[16];

	public static BufferedImage blood1;
	
	public static BufferedImage pistolSkin, ak47, rifleLoader;
	
	public static Clip pistolShoot, rifleShoot, background, zombieHit, pistolReloadSound, rifleReloadSound,emptyGun, zombieBite;
	
	public static BufferedImage grass, dirt;
	
	public static BufferedImage tree;
	
	public static BufferedImage[] trees = new BufferedImage[4];
	
	
	public static void init(){
		for(int i = 0; i<pistolIdle.length; i++)
			pistolIdle[i] = Utilities.loadImage("/textures/player/idle/pistolIdle/"+i+".png");
		for(int i = 0; i<rifleIdle.length; i++)
			rifleIdle[i] = Utilities.loadImage("/textures/player/idle/rifleIdle/"+i+".png");
		for(int i = 0; i<pistolReload.length; i++)
			pistolReload[i] = Utilities.loadImage("/textures/player/reload/pistol/"+i+".png");
		for(int i = 0; i<rifleReload.length; i++)
			rifleReload[i] = Utilities.loadImage("/textures/player/reload/rifle/"+i+".png");
		for(int i = 0; i<pistolShootAnim.length; i++)
			pistolShootAnim[i] = Utilities.loadImage("/textures/player/shoot/pistol/"+i+".png");
		for(int i = 0; i<rifleShootAnim.length; i++)
			rifleShootAnim[i] = Utilities.loadImage("/textures/player/shoot/rifle/"+i+".png");
		
		for(int i = 0; i<zombie.length; i++)
			zombie[i] = Utilities.loadImage("/textures/zombie/walk/"+i+".png");
		for(int i = 0; i<zombieAttack.length; i++)
			zombieAttack[i] = Utilities.loadImage("/textures/zombie/attack/"+i+".png");
		
		for(int i = 0; i < trees.length; i++)
			trees[i] = Utilities.loadImage("/textures/tress/tree"+i+".png");

		tree = Utilities.loadImage("/textures/obstacles/tree.png");
		grass = Utilities.loadImage("/textures/tiles/grass.png");
		dirt = Utilities.loadImage("/textures/tiles/dirt.png");
		
		pistolSkin = Utilities.loadImage("/textures/guns/pistol.png");
		ak47 = Utilities.loadImage("/textures/guns/ak-47.png");
		rifleLoader = Utilities.loadImage("/textures/guns/rifleLoader.png");
		
		blood1 = Utilities.loadImage("/textures/zombie/blood/bloodsplat.png");
		
		pistolShoot = Utilities.LoadSound("/sounds/pistol.wav");
		rifleShoot = Utilities.LoadSound("/sounds/machineGun.wav");
		background = Utilities.LoadSound("/sounds/background.wav");
		zombieHit = Utilities.LoadSound("/sounds/zombieHit.wav");
		pistolReloadSound = Utilities.LoadSound("/sounds/pistolReload.wav");
		rifleReloadSound = Utilities.LoadSound("/sounds/rifleReload.wav");
		emptyGun = Utilities.LoadSound("/sounds/emptyGun.wav");
		zombieBite = Utilities.LoadSound("/sounds/zombieBite.wav");
	}	
}