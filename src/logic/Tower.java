package logic;

import java.awt.*;
import java.util.ArrayList;

import render.RenderManager;

public class Tower {
	
	public int id;
	public int x,y;
	public int range;
	public int damage;
	
	public static ArrayList<Tower> towers = new ArrayList<Tower>();

	public Tower(int id,int x,int y, int range, int damage) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.range = range;
		this.damage = damage;
	}
	
	public static void addTower(Tower i){
		towers.add(i);
	}
	
	public static void draw(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		for(Tower i : towers){
//			g2.setComposite(GameScreen.transcluentWhite);
//			g2.setColor(Color.LIGHT_GRAY);
			
			g2.drawOval(i.x*50 - i.range+25, i.y*50 - i.range+25, i.range*2, i.range*2);
//			g2.setComposite(GameScreen.opaque);
			g2.drawImage(RenderManager.turret[i.id], null, i.x*50, i.y*50);
		}
	}
	
	

	


}
