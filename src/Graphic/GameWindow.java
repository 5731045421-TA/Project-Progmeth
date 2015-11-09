package Graphic;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


import com.sun.prism.Image;



@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	JFrame frame=new JFrame("Tower Defense");
	BufferedImage background;
	
	public GameWindow() throws IOException{
		
		frame.setPreferredSize(new Dimension(1280, 800));
		JPanel GamePanel =new JPanel(new BorderLayout());
		GamePanel.add(background);
		frame.setVisible(true);
		frame.pack();
	}
	
	public void setBackground(String fileName) throws IOException{
		this.background=ImageIO.read(new File(fileName));
	}
	public static JPanel drawGamePanel(){
	    //Create game panel and attributes
	    JPanel gamePanel = new JPanel();
	    java.awt.Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
	    ((Object) gamePanel).drawImage(background, 0, 0, null);
	    //Set Return
	    return gamePanel;
	}
}
