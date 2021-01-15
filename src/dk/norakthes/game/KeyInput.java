package dk.norakthes.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //Key events for player 1

                switch (key) {
                    case KeyEvent.VK_W -> tempObject.setVelY(-5);
                    case KeyEvent.VK_A -> tempObject.setVelX(-5);
                    case KeyEvent.VK_S -> tempObject.setVelY(5);
                    case KeyEvent.VK_D -> tempObject.setVelX(5);

                }

            }

            if (tempObject.getId() == ID.Player2) {
                //Key events for player 2

                switch (key) {
                    case KeyEvent.VK_UP -> tempObject.setVelY(-5);
                    case KeyEvent.VK_LEFT -> tempObject.setVelX(-5);
                    case KeyEvent.VK_DOWN -> tempObject.setVelY(5);
                    case KeyEvent.VK_RIGHT -> tempObject.setVelX(5);

                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //Key events for player 1

                switch (key) {
                    case KeyEvent.VK_W, KeyEvent.VK_S -> tempObject.setVelY(0);
                    case KeyEvent.VK_A, KeyEvent.VK_D -> tempObject.setVelX(0);
                }

            }

            if (tempObject.getId() == ID.Player2) {
                //Key events for player 2

                switch (key) {
                    case KeyEvent.VK_UP, KeyEvent.VK_DOWN -> tempObject.setVelY(0);
                    case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> tempObject.setVelX(0);

                }
            }
        }


    }
}
