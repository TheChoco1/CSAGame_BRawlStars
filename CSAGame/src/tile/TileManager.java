package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Util;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/worldmap01.txt");
	}
	
	public void getTileImage() {
		
		setup(0, "ground", false);
		setup(1, "rock", true);
		setup(2, "water", true);
		setup(3, "sand", false);
		setup(4, "tree", true);
		setup(5, "wall", true);
		setup(6, "bottomWater_WavesDown", true);
	}
	
	public void setup(int index, String name, boolean collision) {
		
		Util u = new Util();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + name + ".png"));
			tile[index].image = u.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String fileInput) {
		
		try {
			InputStream is = getClass().getResourceAsStream(fileInput);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col<gp.maxWorldCol && row<gp.maxWorldRow) {
				String line  = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch(Exception e) {
			
		}

	}
	
	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY ) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, null);
			}
			
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
	
}
