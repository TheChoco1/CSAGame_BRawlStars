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
	public int commandNum = 0;
	public int titleScreenState = 0; // 0: the first screen 1: second screen
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.BOLD, 40);
		arial_80 = new Font("Arial", Font.BOLD, 40);
	}
	
	public void draw(Graphics2D g2) {	
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.WHITE);
		//TITLE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		if (gp.gameState == gp.playState) {
			
		}
		if (gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
	}
	public void drawTitleScreen() {
		if(titleScreenState == 0) {
			g2.setColor(new Color(0,0,0));
			g2.fillRect(0,0, gp.screenWidth,gp.screenHeight);
			//Title NAme
			g2.setFont(arial_80.deriveFont(Font.BOLD,56F));
			String text = "Brawl Stars But Scuffed";
			int x = getXforCenteredText(text);
			int y = gp.tileSize*3;
			//Shadow
			g2.setColor(Color.gray);
			g2.drawString(text, x+3, y+3);
			//Main Color
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
			//IMAGE displayed
			x = gp.screenWidth/2 - (gp.tileSize*2)/2;//center point
			y += gp.tileSize*2;
			g2.drawImage(gp.player.down1,x,y,gp.tileSize*2, gp.tileSize*2,null);
					
			//MENU
			g2.setFont(arial_80.deriveFont(Font.BOLD,40F));
			
			text = "NEW GAME";
			x = getXforCenteredText(text);
			y += gp.tileSize*3.5;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">",x-gp.tileSize,y);
			}
			
			text = "LOAD GAME";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">",x-gp.tileSize,y);
			}
			text = "QUIT";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">",x-gp.tileSize,y);
			}
		}
		else if(titleScreenState == 1) {
			//BRAWLER SELECTION
			g2.setColor(Color.white);
			g2.setFont(arial_80.deriveFont(Font.BOLD,40F));
			
			String text  = "Select Your Brawler!";
			int x  = getXforCenteredText(text);
			int y = gp.tileSize*3;
			g2.drawString(text,x,y);
		
			text = "Shelly";
			x = getXforCenteredText(text);
			y += gp.tileSize*3;
			g2.drawString(text,x,y);
			if(commandNum == 0) {
				g2.drawString(">",x-gp.tileSize,y);
				
			}
			text = "Brock";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text,x,y);
			if(commandNum == 1) {
				g2.drawString(">",x-gp.tileSize,y);
				
			}
			text = "Spike";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text,x,y);
			if(commandNum == 2) {
				g2.drawString(">",x-gp.tileSize,y);
				
			}
			text = "Back";
			x = getXforCenteredText(text);
			y += gp.tileSize*2;
			g2.drawString(text,x,y);
			if(commandNum == 3) {
				g2.drawString(">",x-gp.tileSize,y);
				
			}

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
