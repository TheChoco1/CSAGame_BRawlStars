package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	final int originalTitleSize = 16;
	final int scale = 3;
	
	public final int tileSize = originalTitleSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;
	public CollisionHandler cHand = new CollisionHandler(this);
	public UI ui = new UI(this);
	public Player player = new Player(this, keyH);
	public Util u = new Util();
	
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	
	public void setupGame() {
		gameState = titleState;
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		while(gameThread != null) {
			
			double drawInterval = 1000000000/FPS;
			double nextDrawTime = System.nanoTime() + drawInterval;
			
			update();
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;		

				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		
		if (gameState == playState) {
			player.update();
		} 
		if (gameState == pauseState) {
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//title Screen
		if (gameState == titleState) {
			ui.draw(g2);
		}else {
			//Others(NPC, Objects)
			tileM.draw(g2);
			
			player.draw(g2);
			
			ui.draw(g2);
		}
		
		
		g2.dispose();
	}
	
}
