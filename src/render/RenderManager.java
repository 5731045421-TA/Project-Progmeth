package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;

import Interface.IRenderable;




public class RenderManager {
	static ClassLoader loader = GameScreen.class.getClassLoader();
	public static BufferedImage grass = null;
	public static BufferedImage road = null;
	public static BufferedImage heart = null;
	public static BufferedImage coin = null;
	public static BufferedImage devil = null;
	public static BufferedImage turret = null;
	public static BufferedImage turret2 = null;
	public static BufferedImage turret3 = null;
	public static BufferedImage turret4 = null;
	public static BufferedImage turret5 = null;
	public static BufferedImage turret6 = null;
	public static BufferedImage turret7 = null;
	public static BufferedImage stat = null;
	
	public static BufferedImage creep1=null;
	public static BufferedImage creep2=null;
	public static BufferedImage creep3=null
	static{
		try {
			grass = ImageIO.read(new File("grass.png"));
			stat = ImageIO.read(new File("stat.png"));
			road = ImageIO.read(new File("road.png"));
			heart = ImageIO.read(new File("heart.png"));
			coin = ImageIO.read(new File("coin.png"));
			devil = ImageIO.read(new File("devil.png"));
			turret = ImageIO.read(new File("tower/turret-1-1.png"));
			turret2 = ImageIO.read(new File("tower/turret-2-1.png"));
			turret3 = ImageIO.read(new File("tower/turret-3-1.png"));
			turret4 = ImageIO.read(new File("tower/turret-4-1.png"));
			turret5 = ImageIO.read(new File("tower/turret-5-1.png"));
			turret6 = ImageIO.read(new File("tower/turret-6-1.png"));
			turret7 = ImageIO.read(new File("tower/turret-7-1.png"));
			
			creep1=ImageIO.read(new File("creep1.png"));
			creep2=ImageIO.read(new File("creep2.png"));
			creep3=ImageIO.read(new File("creep3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private List<IRenderable> entities;
	
	

	public RenderManager() {
		entities = new ArrayList<IRenderable>();
	}

	public void add(IRenderable entity){
		entities.add(entity);
		//Sort our list by Z
		Collections.sort(entities, new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if(o1.getZ() > o2.getZ()) return 1;
				return -1;
			}
		});
	}
	
	public void update(){
		for(int i=entities.size()-1; i>=0; i--){
			if(entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}
	
	//Will be called by JComponent object
	public void drawScreen(Graphics2D g2d){
		for(IRenderable entity : entities){
			if(entity.isVisible() && !entity.isDestroyed()){
				entity.draw(g2d);
			}
		}
	}
	
}
