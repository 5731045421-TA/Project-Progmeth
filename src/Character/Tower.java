package Character;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.Main;
import Game.Player;
import Graphic.IRenderable;
import Graphic.Resource;

public class Tower implements Buyable,Shootable,Upgrateable,IRenderable{
	protected int attack;
	protected int radius;
	protected int price;
	protected int[] upgradePrice;
	protected int state;
	public BufferedImage towerImage;
	public Tower() {
		this.attack = 5;
		this.radius = 2;
		this.price = 200;
		this.state = 0;
		upgradePrice  = new int[]{200,500,700};
	}

	@Override
	public void shoot(Enemy a) {
		a.damage(attack);
		
	}

	@Override
	public void upgrate() {
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

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		try{
			ClassLoader load = Resource.class.getClassLoader();
			towerImage = ImageIO.read(load.getResource("fileName"));
		}
		catch(IOException e){
			towerImage = null;
			
		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}



}
