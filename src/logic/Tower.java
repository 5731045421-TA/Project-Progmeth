package logic;

import java.awt.*;
import java.util.ArrayList;

import javafx.scene.shape.Circle;
import render.GameScreen;
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
	
	public static void drawTower(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		for(Tower i : towers){
			if(Field.getTerrainAt(i.x, i.y) == 0){
				g2.drawImage(RenderManager.turret[i.id], null, i.x*50, i.y*50);
			}
		}
	}
	
	public static void drawArea(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		for(Tower i : towers){
			if(Field.getTerrainAt(i.x, i.y) == 0){
				g2.setComposite(GameScreen.transcluentWhite);
				g2.setColor(Color.LIGHT_GRAY);
				g2.fillOval(i.x*50 - i.range+25, i.y*50 - i.range+25, i.range*2, i.range*2);
				
				g2.setComposite(GameScreen.opaque);
			}
		}
		
	}
	
	public static int attackTime = 40, attackCount = 40;
	public static void attackMob(){
		for(Tower i : towers){
			Circle c = new Circle(i.x*50 +25, i.y*50 +25, i.range);
			for(int j = 0;j<GameScreen.mobs.length;j++){
				if(c.contains(GameScreen.mobs[j].getCenterX(), GameScreen.mobs[j].getCenterY())){
					if(attackCount >= attackTime){
						System.out.println("attack mob"+j+" hp -= "+i.damage);
						GameScreen.mobs[j].mobHealth-=i.damage;
						System.out.println(GameScreen.mobs[j].mobHealth);
						attackCount = 0;
					}else{
						attackCount++;
					}
					
			}	
			}
		}
	}
	
	

	


}
