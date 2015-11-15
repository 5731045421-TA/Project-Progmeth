package Game;

public class Field {
	private int[][] map=new int[14][24];
	private int stage;
	public final static int GRASS=-1,WALKWAY=0,ROCK=1,OUTSIDE=2;
	
	public Field(int stage) {
		// TODO Auto-generated constructor stub
		this.stage=stage;
		switch (stage) {
		case 1:
			//map design
			break;

		default:
			break;
		}
	}

	public int[][] getMap() {
		return map;
	}
	
	public boolean outOfField(int x,int y){
		if(x>0&&x<24&&y>0&&y<14)return true;
		return false;
	}
	
	public int getTerrainAt(int x,int y){
		return map[x][y];
	}
	
	addEntity(Entity)
	
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
