package Game;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Character.Enemy;
import Character.Tower;


public class Main {
	
	public static void main(String[] args) {
//		Tower a = new Tower();
//		Player b = new Player("Player1");
//		//have 500 money
//		a.buy(); //-100 = 300
//		if(a.canBuy())a.buy(); //-200 = 100
//		else System.out.println("money not enough to buy");
//		if(a.canUpgrade())a.upgate(); //not enough
//		else System.out.println("money not enough to upgrade");
//		System.out.println(Player.money);
//		
//		Enemy c = new Enemy(); //hp 10
//		a.shoot(c); 
//		a.shoot(c);
//		System.out.println(c.getHp());
//		if(c.isDead())System.out.println("Enemy c dead");
		
		JFrame frame = new JFrame("Tank game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComponent gameScreen = new GameScreen();
		
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		
	}

}
