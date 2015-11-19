//package logic;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import logic.*;
//import render.RenderManager;
//
//public class GameLogic {
//
//	private RenderManager renderableContainer;
//	private List<Entity> gameObjectContainer;
//	
//	private Enemy[][] enemys=new Enemy[7][7];
//	private ArrayList<Tower> towers;
//	
//	public GameLogic(RenderManager renderableContainer){
//		this.renderableContainer = renderableContainer;
//		this.gameObjectContainer = new ArrayList<Entity>();
//	
//		Field field = new Field();
//		//renderableContainer.add(field);
//		for(int i=0;i<7;i++){
//			for(int j=0;j<7;j++){
//				enemys[i][j]=new Enemy();
//			}
//		}
//		mine = new Mine(100,100);
//		addNewObject(tank);
//		addNewObject(mine);
//	}
//	
//	protected void addNewObject(Entity entity){
//		gameObjectContainer.add(entity);
//		renderableContainer.add(entity);
//	}
//	
//	public void logicUpdate(){
//		tank.update();
//		if(!mine.isDestroyed() && tank.collideWith(mine)){
//			mine.onCollision(tank);
//		}
//	}
//}
