package logic;

import render.GameScreen;

public class SpawnThread implements Runnable{
	public static int spawnTime=100,spawnFrame=2400;
	@Override
	public void run() {
		while(true){
			mobSpawner();
			
			for(int i = 0;i<GameScreen.mobs.length;i++){//calculate position
				if(GameScreen.mobs[i].inGame){
					GameScreen.mobs[i].physic();

					
				}
			}
			
			
		}
		
	}
	
	public void mobSpawner(){
		if(spawnFrame >= spawnTime){
			for(int i =0;i<GameScreen.mobs.length;i++){
				if(!GameScreen.mobs[i].inGame&&!GameScreen.mobs[i].isDead){
					GameScreen.mobs[i].spawnMob(0);
					//System.out.println("here");
					break;
				}
				//System.out.println("hhere");
			}
			spawnFrame = 0;
		}else{
			spawnFrame++;
		}
	}

}
