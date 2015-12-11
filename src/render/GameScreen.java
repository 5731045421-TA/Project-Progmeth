package render;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import com.sun.prism.Image;

import input.InputUtility;
import logic.Enemy;
import logic.EnemyMove;
import logic.Field;
import logic.Player;

import logic.Tower;

import logic.Wave;


public class GameScreen extends JComponent {

	/**
	 * 
	 */
	int a,b = 0;
	private static final long serialVersionUID = 1L;
	private int[] range = {50,80,100,120,200,150,120};
	private int[] damage = {2,5,8,12,5,20,30};
	private int[] cost = {100,150,200,250,300,400,500};
	public static final AlphaComposite transcluentWhite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
	public static final AlphaComposite opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
	private Point imgPoint[] = new Point[7];
	
	public EnemyMove[] enemyMap =new EnemyMove[200];
	private int enemies=0;
	
	Wave wave;
	
	public static AffineTransformOp aop;
	
	
	
	static {
		AffineTransform at = new AffineTransform();
		at.rotate(Math.toRadians(90));
		aop = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
	}

	public GameScreen() {
		setPreferredSize(new Dimension(1200, 700));
		for (int i = 0; i < 7; i++) {
			imgPoint[i] = new Point(350 + (i * 75), 625);
		}

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				InputUtility.setMouseX(e.getX());
				InputUtility.setMouseY(e.getY());
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (InputUtility.isMouseLeftDown()) {
						InputUtility.setAlreadyClick(true);
					}
					InputUtility.setMouseLeftDown(true);
					InputUtility.setMouseLeftTriggered(true);
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					InputUtility.setMouseRightDown(true);
					InputUtility.setMouseRightTriggered(true);
					for (int i = 0; i < 7; i++) {
						if (InputUtility.getClickOnTurret(i)) {
							InputUtility.setClickOnTurret(false, i);
						}
					}
				}
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
				for (int i = 0; i < 7; i++) {
					if (RenderManager.turret[i] != null && imgPoint[i] != null && InputUtility.isMouseLeftDown()) {
						Point me = e.getPoint();
						Rectangle bounds = new Rectangle(imgPoint[i],
								new Dimension(RenderManager.turret[i].getWidth(), RenderManager.turret[i].getHeight()));
						if (bounds.contains(me)) {
							System.out.println("turret" + i + " was clicked!");
							InputUtility.setClickOnTurret(true, i);
						}
					}
				}
			}
		});
		
		wave=new Wave(this);
		this.wave.waveNumber=0;
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER)wave.nextWave();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);

		Field.drawMap(g, Field.map);

		int i=0;
		if(i>=6)i=0;
		if (!Field.outOfField(a/50, 300/50)) 
			g2d.drawImage(RenderManager.animationCreep1[0][i], aop, a++, 300);
		if (!Field.outOfField((a++-50)/50, 300/50))
			g2d.drawImage(RenderManager.animationCreep2[1][i], aop, (a++)-50, 300);
		if(!Field.outOfField((a++-150)/50, 300/50))
			g2d.drawImage(RenderManager.animationCreep1[2][i], null, (a++)-150, 300);
		if(!Field.outOfField((a++-200)/50, 300/50))
			g2d.drawImage(RenderManager.animationCreep1[3][i], null, (a++)-200, 300);
		
		

		drawStatusBar(g);
		drawClickImage(g);

		addTurret(g);
		Tower.draw(g);


		
		
		//Enemies
		for(int j=0;j<enemyMap.length;j++){
			if(enemyMap[j]!=null){
				g.drawImage(enemyMap[j].enemy.texture, enemyMap[j].xPos+50, enemyMap[j].yPos+50, 50,50,null);
			}
		}

	}

	public void drawStatusBar(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(0, 600, 1200, 100);
		g2d.setColor(Color.BLACK);

		g2d.setFont(new Font("Tahoma", Font.BOLD, 20));
		g2d.setColor(Color.WHITE);
		g2d.drawString("Live :" + Player.player.life, 35, 625);
		g2d.drawImage(RenderManager.heart, null, 10, 605);
		g2d.drawString("Money :" + Player.player.money, 35, 655);
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
		for (int i = 0; i < 7; i++) {
			g2d.drawImage(RenderManager.turret[i], null, 350 + (i * 75), 625);
		}
		g2d.drawImage(RenderManager.stat, null, 900, 600);
		JButton button = new JButton();
		button.setBounds(930, 650, 40, 20);
		this.add(button);
	}

	public void drawAura(Graphics g) {
		int x = InputUtility.getMouseX() / 50;
		int y = InputUtility.getMouseY() / 50;
		Graphics2D g2d = (Graphics2D) g;
		if (!Field.outOfField(x, y) && Field.getTerrainAt(x, y) != 1) {
			g2d.setComposite(transcluentWhite);
			g2d.setColor(Color.WHITE);
			g2d.fillRect(x * 50, y * 50, 49, 49);
			g2d.setComposite(opaque);
		} else {
			g2d.setComposite(transcluentWhite);
			g2d.setColor(Color.RED);
			g2d.fillRect(x * 50, y * 50, 49, 49);
			g2d.setComposite(opaque);
		}

	}

	private void drawClickImage(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < 7; i++) {
			if (Player.player.money > cost[i] && InputUtility.getClickOnTurret(i)) {
				drawAura(g);
				g2d.drawImage(RenderManager.turret[i], null,
						InputUtility.getMouseX() - RenderManager.turret[i].getWidth() / 2,
						InputUtility.getMouseY() - RenderManager.turret[i].getHeight() / 2);
			}
		}
	}

	int is = 0;

	private void addTurret(Graphics g) {
		int x = InputUtility.getMouseX() / 50;
		int y = InputUtility.getMouseY() / 50;
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < 7; i++) {
			if (Player.player.money > cost[i] && InputUtility.isMouseLeftDown() && InputUtility.getClickOnTurret(i) && InputUtility.isAlreadyClick() && !Field.outOfField(x, y)) {
				InputUtility.setClickOnTurret(false, i);
				InputUtility.setAlreadyClick(false);
				InputUtility.setMouseLeftDown(false);
//				System.out.println("turrret summon" + i);
				Tower.addTower(new Tower(i, x, y, range[i], damage[i]));
				Player.player.money -= cost[i];
//				System.out.println(Tower.towers.get(is++).x);

			}
		}
	}
	
	public void spawnEnemy(){
		for(int i=0;i<enemyMap.length;i++){
			if(enemyMap[i]==null){
				enemyMap[i]=new EnemyMove(Enemy.enemyList[0], level.spawnPoint);
				break;
			}
		}
	}
	
	public void update() {
		if(wave.waveSpawning){
			wave.spawnEnemies();
		}
	}
	
}
