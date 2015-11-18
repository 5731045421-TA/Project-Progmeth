package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;




public class RenderManager {
	public static BufferedImage grass;
	public static BufferedImage road;
	static{
		try {
			ClassLoader loader = RenderManager.class.getClassLoader();
			grass = ImageIO.read(loader.getResource("grass.png"));
			road = ImageIO.read(loader.getResource("road.png"));
		} catch (Exception e) {
			grass = null;
			road = null;
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
