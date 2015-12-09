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
	public static BufferedImage[] turret = new BufferedImage[7];
	public static BufferedImage stat = null;

	
	public static BufferedImage[][] animationCreep1=null;
	public static BufferedImage[][] animationCreep2=null;
	public static BufferedImage[][] animationCreep3=null;
	static{

		try {
			grass = ImageIO.read(new File("res/grass.png"));
			stat = ImageIO.read(new File("res/stat.png"));
			road = ImageIO.read(new File("res/road.png"));
			heart = ImageIO.read(new File("res/heart.png"));
			coin = ImageIO.read(new File("res/coin.png"));
			devil = ImageIO.read(new File("res/devil.png"));

			turret[0] = ImageIO.read(new File("res/tower/turret-1-1.png"));
			turret[1] = ImageIO.read(new File("res/tower/turret-2-1.png"));
			turret[2] = ImageIO.read(new File("res/tower/turret-3-1.png"));
			turret[3] = ImageIO.read(new File("res/tower/turret-4-1.png"));
			turret[4] = ImageIO.read(new File("res/tower/turret-5-1.png"));
			turret[5] = ImageIO.read(new File("res/tower/turret-6-1.png"));
			turret[6] = ImageIO.read(new File("res/tower/turret-7-1.png"));
			
			BufferedImage creep1=ImageIO.read(new File("res/creep1.png"));
			BufferedImage creep2=ImageIO.read(new File("res/creep2.png"));
			BufferedImage creep3=ImageIO.read(new File("res/creep3.png"));
			
			animationCreep1=new BufferedImage[4][6];
			animationCreep2=new BufferedImage[4][6];
			animationCreep3=new BufferedImage[4][6];
			
			for(int i=0;i<4;i++){
				for (int j = 0; j < 6; j++) {
					animationCreep1[i][j]=creep1.getSubimage(j*50, i*50, 50, 50);
					animationCreep2[i][j]=creep2.getSubimage(j*50, i*50, 50, 50);
					animationCreep3[i][j]=creep3.getSubimage(j*50, i*50, 50, 50);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("can't load image");
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
