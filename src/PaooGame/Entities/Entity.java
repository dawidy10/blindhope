package PaooGame.Entities;

import PaooGame.Camera;
import PaooGame.Graphics.GameMap;

import java.awt.*;

public abstract class Entity {
    protected int x, y;
    // Position
    protected int width, height;  // Size
    public int speed;
    public int health;
    protected boolean active = true;
    public abstract void update(GameMap gameMap, Enemy boss);
    public abstract void render(Graphics g, Camera camera);
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public boolean isActive() {
        return active;
    }
}