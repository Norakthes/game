package dk.norakthes.game;

import java.awt.*;
import java.util.Random;

public class BasicEnemy extends GameObject {
    private int width = 16, height = 16;

    private Handler handler;
    private Random r = new Random();

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        if (x <= 0 || x >= Game.GAMEWIDTH - width) velX *= -1;
        if (y <= 0 || y >= Game.GAMEHEIGHT - height) velY *= -1;

        handler.addObject(new ParticleTrail(x, y, Color.red, 16, 16, 0.02f, ID.ParticleTrail, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }
}
