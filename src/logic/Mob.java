package logic;
import java.awt.*;
import java.awt.image.BufferedImage;

import render.RenderManager;

public class Mob extends Rectangle{
	
	public int xC,yC;
	public int mobSize = 7;
	public int mobWalk = 0;
	public int up = 0,down = 1,right = 2,left = 3;
	public int direction = right;
	public int mobHealth;
	public int mobID = -1;
	public int[] mobHp = {40,50,100,200,500};
	public boolean inGame = false;
	public boolean isDead = false;
	public boolean isUpward = false;
	public boolean isDownward = false;
	public boolean isRightward = false;
	public boolean isLeftward = false;
	
	public Mob(){
		
	}
	
	int i = 0;
	public void spawnMob(int mobID){
		//System.out.println("spawnMob");
		for(int y = 0;y<12;y++){
			if(Field.map[0][y] == 1){
				setBounds(0, 50*y, mobSize, mobSize);
				xC = 0;
				yC = y;
				//System.out.println("h");
			}
		}
		this.mobID = mobID;
		this.mobHealth = mobHp[mobID];
		inGame = true;
		isDead = false;
	}
	
	public int walkFrame = 0,walkSpeed = -1;
	public void physic(){
		if(walkFrame>=walkSpeed){
			if(direction == right){
				x++;
			}else if(direction == up){
				y--;
			}else if(direction == down){
				y++;
			}else if(direction == left){
				x--;
			}
			
			mobWalk++;
			
			if(mobWalk == 50){
				if(direction == right){
					xC++;
					isRightward = true;
				}else if(direction == up){
					yC--;
					isUpward = true;
				}else if(direction == down){
					yC++;
					isDownward = true;
				}else if (direction == left){
					xC--;
					isLeftward = true;
				}
				if(!isUpward){
					try {
						if(Field.map[xC][yC+1] == 1){
							direction = down;
						}
					} catch (Exception e) {}
				}
				if(!isDownward){
					try {
						if(Field.map[xC][yC-1] == 1){
							direction = up;
						}
					} catch (Exception e) {}
				}
				if(!isLeftward){
					try {
						if(Field.map[xC+1][yC] ==1){
							direction = right;
						}
					} catch (Exception e) {}
				}
				if(!isRightward){
					try {
						if(Field.map[xC-1][yC] == 1){
							direction = left;
						}
					} catch (Exception e) {}
				}
				
				if(Field.map[xC][yC] == 2){
					deleteMob();
					looseHealth();
				}
				
				isUpward = false;
				isDownward = false;
				isLeftward = false;
				isRightward = false;
				mobWalk = 0;
			}
			
			walkFrame = 0;
		}else{
			walkFrame++;
		}
	}
	
	public void deleteMob() {
		inGame = false;
		isDead = true;
	}
	
	public void looseHealth(){
		Player.decreaseLife();;
	}
	
	public BufferedImage[] selectEnemyPic(int id){
		switch (id) {
		case 0:
			return RenderManager.animationCreep1[0];
		case 1:
			return RenderManager.animationCreep1[1];
		case 2:
			return RenderManager.animationCreep1[2];
		case 3:
			return RenderManager.animationCreep2[0];
		case 4:	
			return RenderManager.animationCreep2[1];
		case 5:
			return RenderManager.animationCreep2[2];
		case 6:
			return RenderManager.animationCreep3[0];
		case 7:	
			return RenderManager.animationCreep3[1];
		default:
			return RenderManager.animationCreep3[2];
		}
	}
	int frameCount = 0,frameDo = 20;
	public void draw(Graphics g,int id){
		Graphics2D g2d = (Graphics2D)g;
		if(inGame){
			g2d.drawImage(selectEnemyPic(id)[i], null, x	,y);
			if(frameCount >= frameDo){
				i++;
				frameCount = 0;
			}else{
				frameCount++;
			}
			if(i==4)i=0;
			
		}
	}
}
