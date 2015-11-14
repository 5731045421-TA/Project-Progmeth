package Game;

public class Player {
	public static int money;
	private String name;
	public static int life;
	public Player(String name) {
		this.money = 500;
		this.name = name;
		this.life = 30;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public String getName() {
		return name;
	}
	
}
