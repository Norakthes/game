package dk.norakthes.game;


import java.awt.*;
import java.util.UUID;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;
    protected UUID uuid;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
        this.uuid = UUID.randomUUID();
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    public abstract void setScale(float scale);

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public ID getId() {
        return id;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getVelX() {
        return velX;
    }
    public boolean getVelX(int velX) {
        return velX == this.velX;
    }
    public int getVelY() {
        return velY;
    }
    public boolean getVelY(int velY) {
        return velY == this.velY;
    }
    public UUID getUUID(){
        return uuid;
    }
    public void setUUID(UUID uuid){
        this.uuid = uuid;
    }
}
