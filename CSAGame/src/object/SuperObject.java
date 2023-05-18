package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.Util;

public class SuperObject {

	public void draw(Graphics2D g2, GamePanel gp) {
		
		BufferedImage image;
		String name;
		boolean collision = false;
		int worldX, worldY;
		Rectangle soldiArea = new Rectangle(0, 0, 48, 48);
		int solidAreaDefaultX = 0;
		int solidAreaDefaultY = 0;
		Util util = new Util();
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.worldY &&			
				worldY - gp.tileSize < gp.player.worldY - gp.player.worldY) {
			
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);	
		}		
	}
	
}