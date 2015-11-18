package logic;

public class Field {
	private static int[][] map =  {
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
		{0,0,0,0,0,0,1,0,0,0,0,0},
	};
	
	private int stage;
	public final static int GRASS= 0,WALKWAY=1,ROCK=2,OUTSIDE=3;
	
	

	public int[][] getMap() {
		return map;
	}
	
	public static boolean outOfField(int x,int y){
		if(x>0&&x<24&&y>0&&y<12)return true;
		return false;
	}
	
	public static int getTerrainAt(int x,int y){
		return map[x][y];
	}
	
	
	
	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
	public boolean canBePlaceOnTop(int x,int y){
		if(map[x][y]<=GRASS)return true;
		return false;
	}
	
}
