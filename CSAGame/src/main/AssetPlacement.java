package main;

import monster.MON_GreenSlime;

public class AssetPlacement {

	GamePanel gp;
	
	public AssetPlacement(GamePanel gp) {
		this.gp = gp;
	}

	public void setMonster() {
		
		gp.monster[0] = new MON_GreenSlime(gp);
		gp.monster[0].worldX = gp.tileSize*21;
		gp.monster[0].worldY = gp.tileSize*22;
	}
}
