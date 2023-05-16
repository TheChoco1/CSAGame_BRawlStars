package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea;
	public boolean collisionOn = false;
	
	public GamePanel gp;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
	}
	
	public BufferedImage setup(String image_name) {
		UtilityTool uT = new UtilityTool();
		BufferedImage image = null;
		
		try {
			
		} catch() {
			
		}
		return null;
	}
	
}