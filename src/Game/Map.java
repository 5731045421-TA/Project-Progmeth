package Game;

public class Map {
	private int[][] map=new int[14][24];
	private int stage;
	public final static int GRASS=-1,WALKWAY=0,ROCK=1;
	
	public Map(int stage) {
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

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
	
	
}
