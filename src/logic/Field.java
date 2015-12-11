package logic;

import java.awt.Graphics;
import java.awt.Graphics2D;

import render.GameScreen;
import render.RenderManager;

public class Field {
	public static int[][] map =  {
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,1,0,0,0,0,0},
		{0,0,0,0,0,0,2,0,0,0,0,0},
	};
	 
	private int stage;
	public final static int GRASS= 0,WALKWAY=1,BASE=2,OUTSIDE=3;
	
	

	public int[][] getMap() {
		return map;
	}
	
	public static boolean outOfField(int x,int y){
		if(x>=0 && x<=24 && y>=0 && y<=11)return false;
		return true;
	}
	
	public static int getTerrainAt(int x,int y){
		return map[x][y];
	}
	
	
	
	public void setMap(int[][] map) {
		Field.map = map;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
	
	public static void drawMap(Graphics g,int[][] map){
		Graphics2D g2d = (Graphics2D)g;
		for(int y  = 0;y < 12; y++){
			for(int x =0;x < 24;x++){
				//System.out.println("before");
				try {
					if(Field.getTerrainAt(x,y) == 0)g2d.drawImage(RenderManager.grass, null, x*50, y*50);
					if(Field.getTerrainAt(x,y) == 1)g2d.drawImage(RenderManager.road, null, x*50, y*50);
					if(Field.getTerrainAt(x,y) == 2)g2d.drawImage(RenderManager.heart, null, x*50, y*50);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
	}
	}
	
	
}
