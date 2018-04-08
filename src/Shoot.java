import java.awt.*;

public abstract class Shoot {
    protected int x,y;
    protected int moveX,moveY;
    protected int width,height;
    protected Game game;
    protected PlayerOne playerOne;
    protected PlayerTwo playerTwo;
    protected boolean moveShoot;
    protected boolean alreadyShooted;
    protected boolean canMoveInOtherWay;
    protected boolean collision;
    public Shoot(int width,int height,Game game){
        this.width = width;
        this.height = height;
        this.game = game;
        moveX = 0;
        moveY = 0;
        moveShoot = false;
        alreadyShooted = false;
        canMoveInOtherWay = true;
        collision = false;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y ,width ,height);
    }

    public boolean isCollision() {
        return collision;
    }

    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
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

    public boolean isMoveShoot() {
        return moveShoot;
    }

    public void setMoveShoot(boolean moveShoot) {
        this.moveShoot = moveShoot;
    }

    public boolean isAlreadyShooted() {
        return alreadyShooted;
    }

    public void setAlreadyShooted(boolean alreadyShooted) {
        this.alreadyShooted = alreadyShooted;
    }

    public boolean isCanMoveInOtherWay() {
        return canMoveInOtherWay;
    }

    public void setCanMoveInOtherWay(boolean canMoveInOtherWay) {
        this.canMoveInOtherWay = canMoveInOtherWay;
    }
}