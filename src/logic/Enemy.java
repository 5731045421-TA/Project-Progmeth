package logic;

import Interface.Damageable;

public class Enemy implements Damageable{
	private int hp;
	
	
	public Enemy() {
		this.setHp(10);
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