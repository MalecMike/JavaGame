import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Obstacles {
    private int x;
    private int y;
    private int width;
    private int height;
    private int left;
    private int right;
    private int top;
    private int bot;
    Rectangle rectangle;
    public Obstacles(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.left = x - width/2;
        this.right = x + width/2;
        this.top = y - height/2;
        this.bot = y + height/2;

        rectangle = new Rectangle(x,y,width,height);
    }
    public void tick(){
        getBounds();
        getTopBounds();
        getLeftBounds();
        getRightBounds();
        getBotBounds();
    }
    public void render(Graphics g) {
        /*
        g.setColor(Color.black);
        g.fillRect(getTopBounds().x - 2,getTopBounds().y,getTopBounds().width + 3,getTopBounds().height);
        g.fillRect(getBotBounds().x,getBotBounds().y,getBotBounds().width,getBotBounds().height);
        g.fillRect(getLeftBounds().x,getLeftBounds().y,getLeftBounds().width,getLeftBounds().height);
        g.fillRect(getRightBounds().x,getRightBounds().y,getRightBounds().width,getRightBounds().height);
        */


    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public Rectangle getTopBounds(){
        return new Rectangle(x + 2,y,width,4);
    }
    public Rectangle getLeftBounds(){
        return new Rectangle(x,y+2,4,height);
    }
    public Rectangle getRightBounds(){
        return new Rectangle((int)x + width ,(int)y + 2,4,height + 2);
    }
    public Rectangle getBotBounds(){
        return new Rectangle((int)x,(int)y + height,width + 4,4);
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBot() {
        return bot;
    }

    public void setBot(int bot) {
        this.bot = bot;
    }
}