package dk.norakthes.game;

import java.awt.*;

public class HUD {

    private static final int HUDWIDTH = 400;
    public static int HEALTH = 100;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);

    }

    public void render(Graphics g) {
        //Background
        g.setColor(Color.gray);
        g.fillRect(15,15,HUDWIDTH,32);

        //Health
        g.setColor(Color.green);
        g.fillRect(15,15,HEALTH*(HUDWIDTH/100),32);

        //Border
        g.setColor(Color.white);
        g.drawRect(15,15,HUDWIDTH,32);
    }

}
