package logic;

import javax.swing.ImageIcon;

import Interface.Damageable;

public class Enemy implements Damageable{
	public static final Enemy[] enemyList=new Enemy[100];
	public static final Enemy slime=new EnemySlime(0,5,3,10,3,4).getTextureFile("creep1.png");
	
	public int id;
	public int price;
	public double speed;
	public double attackSpeed;
	public int damage;
	public int health;
	
	public String textureFile="";
	public java.awt.Image texture=null;
	

	
	public Enemy(int id,int price,int damage,int health,double speed,double attackSpeed) {
		if(enemyList[id]!=null){
			System.out.println("[TowerInitialization] Two enemies with same id");
		}else{
			enemyList[id]=this;
			
			this.id=id;
			this.price=price;
			this.damage=damage;
			setHealth(health);
			this.speed=speed;
			this.attackSpeed=attackSpeed;
		}
		
		
	}

	

	@Override
	public void damage(int attack) {
		setHealth(getHealth() - attack); 
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int hp) {
		if(hp<0)hp=0;
		this.health = hp;
	}


	@Override
	public boolean isDead() {
		if(this.health <= 0)return true;
		return false;
	}
	
	public static startup() {
		
	}
	
	public Enemy getTextureFile(String str) {
		this.textureFile=str;
		this.texture=new ImageIcon("res/enemy"+this.textureFile).getImage();
		
		return this;
	}
	

}
