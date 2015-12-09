package logic;

import javax.swing.ImageIcon;

import Interface.Damageable;

public class Enemy implements Damageable{
	public static final Enemy[] enemyList=new Enemy[100];
	public static final Enemy slime=new EnemySlime(0,10,1).getTextureFile("creep1.png");
	
	public int hp;
	public int creepNumber;
	public int speed;
	
	public String textureFile="";
	public java.awt.Image texture=null;
	

	
	public Enemy(int creepNumber,int health,int speed) {
		if(enemyList[creepNumber]!=null){
			System.out.println("[TowerInitialization] Two enemies with same id");
		}else{
			enemyList[creepNumber]=this;
			
			this.setHp(health);
			this.creepNumber=creepNumber;
			
			this.speed=speed;
		}
		
		
	}

	public Enemy getTextureFile(String str) {
		this.textureFile=str;
		this.texture=new ImageIcon("res/enemy"+this.textureFile).getImage();
		
		return this;
	}

	@Override
	public void damage(int attack) {
		setHp(getHp() - attack); 
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		if(hp<0)hp=0;
		this.hp = hp;
	}


	@Override
	public boolean isDead() {
		if(this.hp <= 0)return true;
		return false;
	}


	

}
