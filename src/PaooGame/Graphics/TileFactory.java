package PaooGame.Graphics;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class TileFactory {
    private Map<String, Tile> tileCache = new HashMap<>();

    public Tile getTile(String type) {
        if (!tileCache.containsKey(type)) {
            BufferedImage texture = loadTexture(type);
            switch (type){
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "56":
                    tileCache.put(type, new Tile(type, texture, false));
                    break;
                case "8":
                case "9":
                case "10":
                case "11":
                case "-1":
                case "14":
                case "15":
                    tileCache.put(type, new Tile(type, texture, true));
                    break;
                default:
                    System.err.println("Unknown tile type: " + type + ", defaulting to walkable with tile 0");
                    tileCache.put(type, new Tile(type, texture, true));
                    break;

            }

        }
        return tileCache.get(type);
    }

    private BufferedImage loadTexture(String type) {
        BufferedImage img = Assets.tileMap.get(type);
        if (img == null) {
            System.err.println("Unknown tile type: " + type);
            img = Assets.tileMap.get("0");
        }
        return img;
    }
    public void clearCache() {
        tileCache.clear();
        System.out.println("TileFactory cache cleared");
    }
}
