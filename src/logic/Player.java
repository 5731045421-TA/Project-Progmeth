package logic;

public class Player {
	public static int money;
	public static int life;
	public final static Player player = new Player();
	
	public Player() {
		this.money = 500;
		this.life = 30;
	}
	public static int getMoney() {
		return money;
	}
	public static void setMoney(int money) {
		if(money<0)money=0;
		Player.money = money;
	}
	public static int getLife() {
		return life;
	}
	public static void setLife(int life) {
		if(life<0)life=0;
		Player.life = life;
	}
	public static void decreaseLife(){
		setLife(life-1);
	}
	
}
