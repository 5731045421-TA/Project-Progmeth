package render;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.sun.xml.internal.stream.Entity;

import Interface.Damageable;
import Interface.IRenderable;
import Interface.Upgrateable;
import gameMain.Main;
import logic.Enemy;

public class Spawn extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int state;
	private ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	private ArrayList<IRenderable> renderOfEnemys = new ArrayList<>();

	public Spawn(int state) {
		// TODO Auto-generated constructor stub
		this.state=state;
		switch (state) {
		case 1:
			for(int i=0;i<4;i++){
				enemys.add(new Enemy(1,i));
			}
			break;

		default:
			break;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d=(Graphics2D)g;
		super.paintComponent(g);
		
//		if(outOfField(a,300)){
//			g2d.drawImage(RenderManager.e, xform, obs)
//		}
	}
}
