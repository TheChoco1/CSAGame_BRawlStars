package entity;

import main.GamePanel;

public class NPC extends Entity{
	public NPC(GamePanel gp) {
		super(gp);
		
		direction = "down";
		speed = 1;
		
		getNPCImages();
	}
	
	public void getNPCImages() {
		down1 = setup("/npc/oldman_down_1");
		down2 = setup("/npc/oldman_down_2");
		up1 = setup("/npc/oldman_up_1");
		up2 = setup("/npc/oldman_up_2");
		left1 = setup("/npc/oldman_left_1");
		left2 = setup("/npc/oldman_left_2");
		right1 = setup("/npc/oldman_right_1");
		right2 = setup("/npc/oldman_right_2");
	}
}
