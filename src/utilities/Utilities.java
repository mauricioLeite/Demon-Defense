package utilities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.imageio.ImageIO;

public class Utilities {
	public static BufferedImage loadImage(String path){
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println(path);
		try {
			return ImageIO.read(Utilities.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Clip LoadSound(String direction){
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println(direction);
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Utilities.class.getResource(direction)));
			return clip;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}