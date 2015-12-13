package gameMain;

import javax.swing.JComponent;
import javax.swing.JFrame;

import logic.Tower;
import render.GameScreen;




public class Main {
	public static JComponent gameScreen;
	public static JComponent spawn;
	public static void main(String[] args) {

		
		JFrame frame = new JFrame("Defenseder game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameScreen = new GameScreen();
		//spawn=new Spawn(1);
		
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("Thread is intterupt");
			}
			gameScreen.repaint();
			//spawn.repaint();
		}
	}

}
