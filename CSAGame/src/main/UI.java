package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40;
	Font arial_80;
	public boolean gameFinished = false;

	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.BOLD, 40);
		arial_80 = new Font("Arial", Font.BOLD, 40);
	}
	
	public void draw(Graphics2D g2) {	
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.WHITE);
		
		if (gp.gameState == gp.playState) {
			
		}
		if (gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
	}
	
	public void drawPauseScreen() {
		
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight/2;
		

		
		g2.drawString(text, x, y);
	}
	
	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
}