package Character;

import Game.Main;
import Game.Player;

public class Tower implements Buyable,Shootable,Upgateable{
	protected int attack;
	protected int radius;
	protected int price;
	protected int[] upgradePrice;
	protected int state;
	public Tower() {
		this.attack = 5;
		this.radius = 2;
		this.price = 200;
		this.state = 0;
		upgradePrice  = new int[]{200,500,700};
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upgate() {
		Player.money = Player.money - upgradePrice[state];
		
	}
	
	@Override
	public boolean canUpgrade() {
		if(upgradePrice[state] <= Player.money) return true;
		return false;
	}

	@Override
	public void buy() {
		Player.money = Player.money - price;
		
	}

	@Override
	public boolean canBuy() {
		if(Player.money >= price) return true;
		return false;
	}



}
