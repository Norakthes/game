package dk.norakthes.game;


import java.awt.*;
import java.util.UUID;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;
    protected UUID uuid;

    /**
     * @param x X position where the object is spawned
     * @param y Y position where the object is spawned
     * @param id The id of the object
     */
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
        this.uuid = UUID.randomUUID();
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    /**
     * @return Gets the bounds of the rectangle around the object. This is used for collision logic
     */
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

    /**
     * @param velX Presumed velocity of the object
     * @return Returns true if velY is equal to the velocity of the object
     */
    public boolean isVelX(int velX) {
        return velX == this.velX;
    }

    /**
     * @return Gets the velocity of the object
     */
    public int getVelY() {
        return velY;
    }

    /**
     * @param velY presumed velocity of the object
     * @return returns true if velY is equal to the velocity of the object
     */
    public boolean isVelY(int velY) {
        return velY == this.velY;
    }

    /**
     * @return Gets the UUID of the object
     */
    public UUID getUUID(){
        return uuid;
    }

    /**
     * @param uuid Sets the UUID of the object. Only use this code for debug purposes
     */
    @Deprecated
    public void setUUID(UUID uuid){
        this.uuid = uuid;
    }
}
