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
	public static BufferedImage turret = null;
	public static BufferedImage turret2 = null;
	public int a,b = 0;
	static{
		try {
			grass = ImageIO.read(new File("grass.png"));
			road = ImageIO.read(new File("road.png"));
			turret = ImageIO.read(new File("tower/turret-5-1.png"));
			turret2 = ImageIO.read(new File("tower/turret-7-1.png"));
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
		setPreferredSize(new Dimension(1200,800));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g);
		
			for(int y  = 0;y < 14; y++){
				for(int x =0;x < 24;x++){
					if(Field.getTerrainAt(x,y) == 0)g2d.drawImage(grass, null, x*50, y*50);
					if(Field.getTerrainAt(x,y) == 1)g2d.drawImage(road, null, x*50, y*50);
				}
		}
		if(!outOfField(a,300))g2d.drawImage(turret, aop, a++, 300);	
		if(!outOfField(b++ -50,300))g2d.drawImage(turret2, aop, (b++)-50, 300);
		g2d.fillRect(0, 700, 1200, 100);
		g2d.setColor(Color.BLACK);
		
		g2d.setFont(new Font("Tahoma", Font.BOLD, 30));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Live :"+Player.life, 5, 755);
	}

	private boolean outOfField(int x, int y) {
		if(x<0||x>1200||y<0||y>700)return true;
		return false;
	}
	
	
	
	
}
