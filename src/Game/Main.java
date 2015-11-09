package Game;

import Character.Enemy;
import Character.Tower;

public class Main {
	
	public static void main(String[] args) {
		Tower a = new Tower();
		Player b = new Player("Player1");
		//have 500 money
		a.buy(); //-100 = 300
		if(a.canBuy())a.buy(); //-200 = 100
		else System.out.println("money not enough to buy");
		if(a.canUpgrade())a.upgate(); //not enough
		else System.out.println("money not enough to upgrade");
		System.out.println(Player.money);
		
		Enemy c = new Enemy(); //hp 10
		a.shoot(c); //-5
		a.shoot(c);
		System.out.println(c.getHp());
		if(c.isDead())System.out.println("Enemy c dead");
	}

}
