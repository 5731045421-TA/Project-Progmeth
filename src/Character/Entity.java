package Character;

import Game.Field;


public class Entity {
	public static final int WEST=0,NORTH=1,EAST=2,SOUTH=3;
	protected int x,y,direction,nextX,nextY,nextDirection;
	private int movingDelay,movingDelayCounter;
	protected boolean isDestroyed,isDestroyedInNextState;
	protected Field field;
	
	public Entity(Field field, int x, int y, int direction, int movingDelay) {
		
		this.field = field;
		
		//field.addEntity(this);
		if(x<0||x>5||y<0||y>5){
			this.x=0;
			this.y=0;
		}else{
			this.x = x;
			this.y = y;
		}
		if(direction>=0&&direction<=3)
			this.direction = direction;
		else this.direction=2;	
		this.movingDelay = movingDelay;
		this.movingDelayCounter=movingDelay;
		this.isDestroyed=false;
		this.isDestroyedInNextState=false;
		field.addEntity(this);
		calculateNextState();
	}
}
