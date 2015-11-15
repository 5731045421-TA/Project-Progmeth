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
	public static BufferedImage image = null;
	static{
		try {
			image = ImageIO.read(new File("grass.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public GameScreen(){
		setPreferredSize(new Dimension(1200,800));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g);
		if(image != null){
			for(int x  = 0;x <= 1150; x+=50){
				for(int y =0;y <= 650;y+=50){
					g2d.drawImage(image, null, x, y);
				}
			}
			
		}
		g2d.fillRect(0, 700, 1200, 100);
		g2d.setColor(Color.BLACK);
		
		g2d.setFont(new Font("Tahoma", Font.BOLD, 30));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Live :"+Player.life, 5, 755);
	}
	
	
	
}
