package dk.norakthes.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private final Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int modifier = e.getModifiersEx();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);


            // shift = 64
            // control = 128
            if (tempObject.getId() == ID.Player) {
                //Key events for player

                switch (key + modifier) {
                    case 64 + KeyEvent.VK_W: tempObject.setVelY(-10); break;
                    case 64 + KeyEvent.VK_A: tempObject.setVelX(-10); break;
                    case 64 + KeyEvent.VK_S: tempObject.setVelY(10); break;
                    case 64 + KeyEvent.VK_D: tempObject.setVelX(10); break;

                    case 64 + KeyEvent.VK_SHIFT: {
                        if (tempObject.isVelY(-5)) tempObject.setVelY(-10);
                        if (tempObject.isVelX(-5)) tempObject.setVelX(-10);
                        if (tempObject.isVelY(5)) tempObject.setVelY(10);
                        if (tempObject.isVelX(5)) tempObject.setVelX(10);
                        break;
                    }

                    case KeyEvent.VK_W: tempObject.setVelY(-5); break;
                    case KeyEvent.VK_A: tempObject.setVelX(-5); break;
                    case KeyEvent.VK_S: tempObject.setVelY(5); break;
                    case KeyEvent.VK_D: tempObject.setVelX(5); break;

                }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(0);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //Key events for player 1

                switch (key) {
                    case KeyEvent.VK_W: tempObject.setVelY(0); break;
                    case KeyEvent.VK_A: tempObject.setVelX(0); break;
                    case KeyEvent.VK_S: tempObject.setVelY(0); break;
                    case KeyEvent.VK_D: tempObject.setVelX(0); break;
                }

            }
        }

    }
}
