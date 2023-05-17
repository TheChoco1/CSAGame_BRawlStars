package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Util;


public class Entity {
	
	public GamePanel gp;
	
	public final int screenX;
	public final int screenY;
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage stand, up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction = "up";
	
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	public int actionLockCounter = 0;
	
	public int maxLife;
	public int life;
	public String name;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
	}
	
	public BufferedImage setup(String name) {
		BufferedImage scaledImage = null;
		Util u = new Util();
		
		try {
			scaledImage = ImageIO.read(getClass().getResourceAsStream(name + ".png"));
			scaledImage = u.scaleImage(scaledImage, gp.tileSize, gp.tileSize);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return scaledImage;
	}
	
	public void moveNPC() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int ran = random.nextInt(10);
			
			if (ran <= 2) {
				direction = "up";
			}
			if (ran > 2 && ran <= 5) {
				direction = "down";
			}
			if (ran > 5 && ran <=7) {
				direction = "left";
			}
			if (ran > 7 && ran <= 10) {
				direction = "right";
			}
			
			actionLockCounter = 0;
		}

	}
	public void update() {
		moveNPC();
		
		collisionOn = false;
		gp.cHand.checkTile(this);
	}
	
	public void draw(Graphics2D g2, int x, int y) {
		BufferedImage image = down1;
		
		switch(direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			break;
//		case "standing":
//			image = stand;
//			break;
		}
		g2.drawImage(image, screenX, screenY, null);
		
	}


}