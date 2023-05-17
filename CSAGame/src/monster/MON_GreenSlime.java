package monster;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.AssetPlacement;
import main.GamePanel;

public class MON_GreenSlime extends Entity {
	
	GamePanel gp;
	AssetPlacement ap;

	public MON_GreenSlime(GamePanel gp1) {
		super(gp1);
		
		gp = gp1;
		
		name = "Green Slime";
		speed = 1;
		maxLife = 4;
		life = maxLife;
		
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getMonsterImage();
		moveNPC();
	}
	
	public void getMonsterImage() {

		down1 = setup("/monster/greenslime_down_1");
		down2 = setup("/monster/greenslime_down_2");
		up1 = setup("/monster/greenslime_down_1");
		up2 = setup("/monster/greenslime_down_2");
		right1 = setup("/monster/greenslime_down_1");
		right2 = setup("/monster/greenslime_down_2");
		left1 = setup("/monster/greenslime_down_1");
		left2 = setup("/monster/greenslime_down_2");

	}
	
	public void draw(Graphics2D g2, int x, int y) {
		BufferedImage image = down1;
		moveNPC();
		
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
		g2.drawImage(image, x, y, null);
		
	}
	

	
}
