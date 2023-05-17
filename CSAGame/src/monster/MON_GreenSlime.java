package monster;

import entity.Entity;
import main.GamePanel;

public class MON_GreenSlime extends Entity {
	
	GamePanel gp;

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
	
	
	
}
