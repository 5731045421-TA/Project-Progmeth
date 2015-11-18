package gameMain;

import javax.swing.JComponent;
import javax.swing.JFrame;

import logic.Enemy;
import logic.Tower;
import render.GameScreen;



public class Main {
	
	public static void main(String[] args) {

		
		JFrame frame = new JFrame("Tank game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComponent gameScreen = new GameScreen();
		
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			gameScreen.repaint();
			
		}
	}

}
