package dk.norakthes.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    private final int playerHeight = 32, playerWidth = 32;

    public Player(int x, int y, ID id) {
        super(x, y, id);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.GAMEWIDTH-playerWidth);
        y = Game.clamp(y, 0, Game.GAMEHEIGHT-playerHeight);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, playerWidth, playerHeight);
    }


}
