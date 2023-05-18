package main;

import entity.NPC;

public class AssetPlacement {

	GamePanel gp;
	
	public AssetPlacement(GamePanel gp) {
		this.gp = gp;
	}

	public void setNPC() {
		gp.npc[0] = new NPC(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
	}
}
