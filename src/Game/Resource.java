package Game;

import java.applet.Applet;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Resource {
	public static BufferedImage background;

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static{
		try{
			ClassLoader load = Resource.class.getClassLoader();
			background = ImageIO.read(load.getResource("grass.png"));
		}
		catch(IOException e){
			background = null;
			
		}
	}
	
}
