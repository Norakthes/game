package dk.norakthes.game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serializable;
import java.util.Random;

public class Game extends Canvas implements Runnable, Serializable {
    // Sets the window resolution
    public static final int WIDTH = 1280, HEIGHT = 720 /*WIDTH / 12 * 9*/;
    public static final int GAMEWIDTH = 1264, GAMEHEIGHT = 681;

    private Thread thread;
    private boolean running = false;

    private final Random r;
    private final Handler handler;
    private final HUD hud;

    private static final long serialVersionUID = 6230805852286428605L;


    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Game", this);

        hud = new HUD();


        r = new Random();

        Player player = new Player(GAMEWIDTH/2-32,(GAMEHEIGHT/4)*3-32,ID.Player, handler);
        player.setCollision(true);

        handler.addObject(player);

        //BasicEnemy basicEnemy = new BasicEnemy(GAMEWIDTH/3,(GAMEHEIGHT/4)*3,0,0,ID.BasicEnemy,handler);
        //handler.addObject(basicEnemy);
        //for (int i = 0; i < 1; i++) handler.addObject(new BasicEnemy(r.nextInt(GAMEWIDTH),r.nextInt(GAMEHEIGHT), 1, 1,ID.BasicEnemy, handler));

        long timer = System.currentTimeMillis();
        while (running) {
            if (System.currentTimeMillis() - timer > 0) {
                timer += 100;

//                float scale = 0f;
//                scale += 1.1f;
//                basicEnemy.setScale(scale);

                handler.addObject(new BasicEnemy(r.nextInt(GAMEWIDTH), 0, 0, 10, ID.BasicEnemy, handler));
                //System.out.println(handler.object.size());
            }
        }
    }

    public synchronized void start() {
        // Initializes thread and runs it
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        // Standard Java GameLoop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames); // Remember: remove sout before done
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    public static final Rectangle bottom = new Rectangle(-10, GAMEHEIGHT-50, GAMEWIDTH+10,GAMEHEIGHT);

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);

        handler.render(g);

        hud.render(g);

        g2d.draw(bottom);

        g.dispose();
        bs.show();
    }

    //Doesn't allow a number to go over a specific amount
    //Used when you don't want the player to get through the screen border
    public static int clamp(int var, int min, int max) {
        if (var >= max) {return var = max;}
        else if (var <= min) {return var = min;}
        else {return var;}
    }

    public static void main(String[] args) {
        new Game();
    }


}
