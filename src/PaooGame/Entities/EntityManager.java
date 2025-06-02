package PaooGame.Entities;

import PaooGame.Camera;
import PaooGame.Graphics.GameMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Entity> entities = new ArrayList<>();

    public EntityManager() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void clearEntities() {
        entities.clear();
    }

    public void updateAll(GameMap gameMap, Enemy boss) {
        for (Entity e : entities) {
            if (e.isActive()) {
                e.update(gameMap, boss);
            }
        }
    }

    public void renderAll(Graphics g, Camera camera) {
        for (Entity e : entities) {
            if (e.isActive()) {
                e.render(g, camera);
            }
        }
    }
}