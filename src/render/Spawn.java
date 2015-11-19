package render;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.sun.xml.internal.stream.Entity;

import Interface.Damageable;
import Interface.IRenderable;
import Interface.Upgrateable;
import logic.Enemy;

public class Spawn extends JComponent implements Damageable, Upgrateable, IRenderable {

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
			//for(Entity)//POJ is doing
			break;

		default:
			break;
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void upgrate() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canUpgrade() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void damage(int attack) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}
}
