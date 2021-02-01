package dk.norakthes.game;

import java.awt.*;
import java.util.Random;

public class BasicEnemy extends GameObject {
    private int width = 16, height = 16;

    private Handler handler;

    private boolean intersects = false;

    public BasicEnemy(int x, int y, int velX, int velY, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        this.velX = velX;
        this.velY = velY;
    }



    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }


    public void setScale(float scale) {
        this.width = Math.round(this.width * scale);
        this.height = Math.round(this.height * scale);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        //if (x <= 0 || x >= Game.GAMEWIDTH - width) velX *= -1; //Reverses direction when hitting the corners
        //if (y <= 0 || y >= Game.GAMEHEIGHT - height) velY *= -1;

        handler.addObject(new ParticleTrail(x, y, Color.red, 16, 16, 0.09f, ID.ParticleTrail, handler));

        collision();

        if (intersects) {
            handler.removeObject(this);
        }
    }




    private void collision() {
        if (getBounds().intersects(Game.bottom)) {
            //Collision logic
            intersects = true;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
