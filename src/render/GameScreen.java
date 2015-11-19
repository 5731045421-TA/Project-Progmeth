package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


import com.sun.prism.Image;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;

import input.InputUtility;
import logic.Field;
import logic.Player;


public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a,b =0;
	private Point imgPoint;
	private Point imgPoint2;
	private Point imgPoint3;
	private Point imgPoint4;
	private Point imgPoint5;
	private Point imgPoint6;
	private Point imgPoint7;
		
	
	public static AffineTransformOp aop;
	static{
		AffineTransform at = new AffineTransform();
		at.rotate(Math.toRadians(90));
		aop = new AffineTransformOp(at,AffineTransformOp.TYPE_BICUBIC);
	}	
	public GameScreen(){
		setPreferredSize(new Dimension(1200,700));
		imgPoint = new Point(350, 625);
		imgPoint2 = new Point(425, 625);
		imgPoint3 = new Point(500, 625);
		imgPoint4 = new Point(575, 625);
		imgPoint5 = new Point(650, 625);
		imgPoint6 = new Point(725, 625);
		imgPoint7 = new Point(800, 625);
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				InputUtility.setMouseX(e.getX());
				InputUtility.setMouseY(e.getY());
				//System.out.println(InputUtility.getMouseX()+" "+InputUtility.getMouseY());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (RenderManager.turret != null&& imgPoint != null ) {
                     Point me = e.getPoint();
                     Rectangle bounds = new Rectangle(imgPoint, 
                    		 new Dimension(RenderManager.turret.getWidth(), RenderManager.turret.getHeight()));
                     if (bounds.contains(me)) {
                         System.out.println("turret was clicked!");
                     }
                 }
				 if (RenderManager.turret2 != null&& imgPoint2 != null ) {
                     Point me = e.getPoint();
                     Rectangle bounds = new Rectangle(imgPoint2, 
                    		 new Dimension(RenderManager.turret2.getWidth(), RenderManager.turret2.getHeight()));
                     if (bounds.contains(me)) {
                         System.out.println("turret2 was clicked!");
                     }
                 }
				 if (RenderManager.turret3 != null&& imgPoint3 != null ) {
                     Point me = e.getPoint();
                     Rectangle bounds = new Rectangle(imgPoint3, 
                    		 new Dimension(RenderManager.turret3.getWidth(), RenderManager.turret3.getHeight()));
                     if (bounds.contains(me)) {
                         System.out.println("turret3 was clicked!");
                     }
                 }
				 if (RenderManager.turret4 != null&& imgPoint4 != null ) {
                     Point me = e.getPoint();
                     Rectangle bounds = new Rectangle(imgPoint4, 
                    		 new Dimension(RenderManager.turret4.getWidth(), RenderManager.turret4.getHeight()));
                     if (bounds.contains(me)) {
                         System.out.println("turret4 was clicked!");
                     }
                 }
				 if (RenderManager.turret5 != null&& imgPoint5 != null ) {
                     Point me = e.getPoint();
                     Rectangle bounds = new Rectangle(imgPoint5, 
                    		 new Dimension(RenderManager.turret5.getWidth(), RenderManager.turret5.getHeight()));
                     if (bounds.contains(me)) {
                         System.out.println("turret5 was clicked!");
                     }
                 }
				 if (RenderManager.turret6 != null&& imgPoint6 != null ) {
                     Point me = e.getPoint();
                     Rectangle bounds = new Rectangle(imgPoint6, new Dimension(RenderManager.turret6.getWidth(), 
                    		 RenderManager.turret6.getHeight()));
                     if (bounds.contains(me)) {
                         System.out.println("turret6 was clicked!");
                     }
                 }
				 if (RenderManager.turret7 != null&& imgPoint7 != null ) {
                     Point me = e.getPoint();
                     Rectangle bounds = new Rectangle(imgPoint7, new Dimension(RenderManager.turret7.getWidth(), 
                    		 RenderManager.turret7.getHeight()));
                     if (bounds.contains(me)) {
                         System.out.println("turret7 was clicked!");
                     }
                 }
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g);
		
		Field.drawMap(g,Field.map);
		if(!outOfField(a,300)){
			g2d.drawImage(RenderManager.turret, aop, a++, 300);	
			System.out.println("here");
		}
		if(!outOfField(b++ -50,300))g2d.drawImage(RenderManager.turret2, aop, (b++)-50, 300);
		drawStatusBar(g);
	}

	private boolean outOfField(int x, int y) {
		if(x<0||x>1200||y<0||y>600)return true;
		return false;
	}
	
	public void drawStatusBar(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.fillRect(0, 600, 1200, 100);
		g2d.setColor(Color.BLACK);
		
		g2d.setFont(new Font("Tahoma", Font.BOLD, 20));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Live :"+Player.life, 35,625);
		g2d.drawImage(RenderManager.heart, null, 10, 605);	
		g2d.drawString("Money :"+Player.money, 35, 655);
		g2d.drawImage(RenderManager.coin, null, 10, 635);
		g2d.drawString("Wave :  0/7", 35, 685);
		g2d.drawImage(RenderManager.devil, null, 10, 665);
		g2d.setFont(new Font("Tahoma", Font.PLAIN, 15));
		g2d.drawString("$100", 355, 625);
		g2d.drawString("$150", 430, 625);
		g2d.drawString("$200", 505, 625);
		g2d.drawString("$250", 580, 625);
		g2d.drawString("$300", 655, 625);
		g2d.drawString("$400", 730, 625);
		g2d.drawString("$500", 805, 625);
		g2d.drawImage(RenderManager.turret, null, 350, 625);	
		g2d.drawImage(RenderManager.turret2, null, 425, 625);
		g2d.drawImage(RenderManager.turret3, null, 500, 625);
		g2d.drawImage(RenderManager.turret4, null, 575, 625);
		g2d.drawImage(RenderManager.turret5, null, 650, 625);
		g2d.drawImage(RenderManager.turret6, null, 725, 625);
		g2d.drawImage(RenderManager.turret7, null, 800, 625);
		g2d.drawImage(RenderManager.stat, null, 900, 600);
		JButton button = new JButton();
		button.setText("SELL");
		button.setBounds(930, 650, 40, 20);
		this.add(button);
	}
	
	
}
