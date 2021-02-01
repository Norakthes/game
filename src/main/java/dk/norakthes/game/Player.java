package dk.norakthes.game;

import java.awt.*;


public class Player extends GameObject {
    private final int playerHeight = 32, playerWidth = 32;

    private boolean collision = true;

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, playerWidth, playerHeight);
    }

    @Override
    public void setScale(float scale) {

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.GAMEWIDTH-playerWidth+8);
        y = Game.clamp(y, 0, Game.GAMEHEIGHT-playerHeight+8);

        //handler.addObject(new ParticleTrail(x, y, Color.white, playerWidth-12, playerHeight-12, 0.01f, ID.ParticleTrail, handler));

        collision();
    }

    protected boolean invulnFrames = false;

    protected void collision() {
        if (collision) {
            for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);

                if (tempObject.getId() == ID.BasicEnemy) {
                    if (getBounds().intersects(tempObject.getBounds())){
                        //Collision logic
                        if (!invulnFrames){
                            HUD.HEALTH -= 10;
                        }
                        if (HUD.HEALTH == 0) {
                            System.exit(0);
                        }
                    }
                }

            }
        }
    }

    protected void setCollision(boolean collision) {
        this.collision = collision;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, playerWidth, playerHeight);
    }


}
