package Interface;

import java.awt.Graphics2D;

public interface IRenderable {
 public void draw(Graphics2D g2d);
 public int getZ();
 public boolean isDestroyed();
 public boolean isVisible();
}
