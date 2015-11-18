package logic;

public class Player {
	public static int money;
	private static String name;
	public static int life;
	public Player(String name) {
		Player.money = 500;
		Player.name = name;
		Player.life = 30;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		if(money<0)money=0;
		Player.money = money;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		if(life<0)life=0;
		Player.life = life;
	}
	public String getName() {
		return name;
	}
	
}
