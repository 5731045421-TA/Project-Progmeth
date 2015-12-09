package logic;

public class EnemyMove {
	public Enemy enemy;
	public SpawnPoint spawnPoint;
	
	public int xPos;
	public int yPos;
	
	public boolean attack;
	
	public int routePosX;
	public int routePosY;
	
	public int health;
	
	public EnemyMove(Enemy enemy,SpawnPoint spawnPoint){
		this.enemy=enemy;
		
		this.routePosX=spawnPoint.getX();
		this.routePosY=spawnPoint.getY();
		
		this.xPos=spawnPoint.getX()*50;//50 mean block size
		this.yPos=spawnPoint.getY()*50;
		
		this.attack=false;
		this.health=enemy.getHp();
	}
	
	public EnemyMove update(){
		EnemyMove currentEnemy = this;
		
		if(currentEnemy.health<=0){
			return null;
		}
		
		return currentEnemy;
	}
}
