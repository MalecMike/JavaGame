import java.awt.*;

public abstract class Entity {
    protected double x,y;
    protected int width,height;
    public Entity(double x,double y){
        this.x = x;
        this.y = y;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,width ,height);
    }
    public Rectangle getTopBounds(){
        return new Rectangle((int)x,(int)y,width,4);
    }
    public Rectangle getLeftBounds(){
        return new Rectangle((int)x,(int)y,4,height);
    }
    public Rectangle getRightBounds(){
        return new Rectangle((int)x + width,(int)y,4,height + 2);
    }
    public Rectangle getBotBounds(){
        return new Rectangle((int)x,(int)y + height,width + 4,4);
    }

    public double getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}