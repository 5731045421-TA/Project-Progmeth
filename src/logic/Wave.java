package logic;

import render.GameScreen;

public class Wave {
	GameScreen screen;

	public int waveNumber = 0;
	public int enemiesThisRound = 7;
	public int enemiesPerRound = 49;

	boolean waveSpawning;

	public Wave(GameScreen screen) {
		this.screen = screen;
	}

	public void nextWave() {
		this.waveNumber++;
		this.enemiesThisRound = 0;
		this.waveSpawning = true;

		System.out.println("[Wave] Wave" + this.waveNumber + " incoming!");

		for (int i = 0; i < this.screen.enemyMap.length; i++) {
			this.screen.enemyMap[i] = null;
		}
	}

	private int currentDelay = 0;
	private int spawnRate = 1000;

	public void spawnEnemies() {
		if (this.enemiesThisRound < this.waveNumber * this.enemiesPerRound) {
			if (currentDelay < spawnRate) {
				currentDelay++;
			} else {
				currentDelay = 0;

				System.out.println("[Wave] Enemy Spawned");

				this.enemiesPerRound++;
				this.screen.spawnEnemy();
			}
		} else {
			this.waveSpawning = false;
		}
	}
}
