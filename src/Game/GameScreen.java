package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


import com.sun.prism.Image;

import Game.Player;


public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static BufferedImage grass = null;
	public static BufferedImage road = null;
	public static BufferedImage heart = null;
	public static BufferedImage coin = null;
	public static BufferedImage devil = null;
	public static BufferedImage turret = null;
	public static BufferedImage turret2 = null;
	public static BufferedImage turret3 = null;
	public static BufferedImage turret4 = null;
	public static BufferedImage turret5 = null;
	public static BufferedImage turret6 = null;
	public static BufferedImage turret7 = null;
	public int a,b = 0;
	static{
		try {
			grass = ImageIO.read(new File("grass.png"));
			road = ImageIO.read(new File("road.png"));
			heart = ImageIO.read(new File("heart.png"));
			coin = ImageIO.read(new File("coin.png"));
			devil = ImageIO.read(new File("devil.png"));
			turret = ImageIO.read(new File("tower/turret-1-1.png"));
			turret2 = ImageIO.read(new File("tower/turret-2-1.png"));
			turret3 = ImageIO.read(new File("tower/turret-3-1.png"));
			turret4 = ImageIO.read(new File("tower/turret-4-1.png"));
			turret5 = ImageIO.read(new File("tower/turret-5-1.png"));
			turret6 = ImageIO.read(new File("tower/turret-6-1.png"));
			turret7 = ImageIO.read(new File("tower/turret-7-1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static AffineTransformOp aop;
	static{
		AffineTransform at = new AffineTransform();
		at.rotate(Math.toRadians(90));
		aop = new AffineTransformOp(at,AffineTransformOp.TYPE_BICUBIC);
	}	
	public GameScreen(){
		setPreferredSize(new Dimension(1200,700));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g);
		
			for(int y  = 0;y < 12; y++){
				for(int x =0;x < 24;x++){
					if(Field.getTerrainAt(x,y) == 0)g2d.drawImage(grass, null, x*50, y*50);
					if(Field.getTerrainAt(x,y) == 1)g2d.drawImage(road, null, x*50, y*50);
				}
		}
		if(!outOfField(a,300))g2d.drawImage(turret, aop, a++, 300);	
		if(!outOfField(b++ -50,300))g2d.drawImage(turret2, aop, (b++)-50, 300);
		g2d.fillRect(0, 600, 1200, 100);
		g2d.setColor(Color.BLACK);
		
		g2d.setFont(new Font("Tahoma", Font.BOLD, 20));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Live :"+Player.life, 35,625);
		g2d.drawImage(heart, null, 10, 605);	
		g2d.drawString("Money :"+Player.money, 35, 655);
		g2d.drawImage(coin, null, 10, 635);
		g2d.drawString("Wave :  0/7", 35, 685);
		g2d.drawImage(devil, null, 10, 665);
		g2d.setFont(new Font("Tahoma", Font.PLAIN, 15));
		g2d.drawString("$100", 355, 625);
		g2d.drawString("$150", 430, 625);
		g2d.drawString("$200", 505, 625);
		g2d.drawString("$250", 580, 625);
		g2d.drawString("$300", 655, 625);
		g2d.drawString("$400", 730, 625);
		g2d.drawString("$500", 805, 625);
		g2d.drawImage(turret, null, 350, 625);	
		g2d.drawImage(turret2, null, 425, 625);
		g2d.drawImage(turret3, null, 500, 625);
		g2d.drawImage(turret4, null, 575, 625);
		g2d.drawImage(turret5, null, 650, 625);
		g2d.drawImage(turret6, null, 725, 625);
		g2d.drawImage(turret7, null, 800, 625);
	}

	private boolean outOfField(int x, int y) {
		if(x<0||x>1200||y<0||y>600)return true;
		return false;
	}
	
	
	
	
}
