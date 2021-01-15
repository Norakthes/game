package dk.norakthes.game;

import java.awt.*;

public class BasicEnemy extends GameObject {

    private final int enemyHeight = 16, enemyWidth = 16;

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.GAMEHEIGHT - enemyHeight) velY *= -1;
        if (x <= 0 || x >= Game.GAMEWIDTH - enemyWidth) velX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x,y,enemyWidth,enemyHeight);
    }
}
