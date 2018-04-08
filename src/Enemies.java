import java.awt.*;

public abstract class Enemies  {
    protected double x,y;
    protected int health;
    protected int width;
    protected int height;
    protected double xMove;
    protected boolean alive;
    public Enemies(float x,float y){
        width = 100;
        height = 150;
        health = 3;
        this.x = x;
        this.y = y;
        xMove = 1;
        alive = true;
    }
    public void tick() {
        changeDirection();
        move();

    }
    public void move(){
        x += xMove;
    }
    public boolean getAlive(){
        return alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void changeHealth(){
        health -= 1;
    }
    public abstract void render(Graphics g);
    public abstract void changeDirection();
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,width ,height);
    }
}