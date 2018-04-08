import java.awt.*;

public abstract class Creatures extends Entity {
    protected int health;
    protected double speed;
    protected double xMove,yMove;


    protected boolean playerOneVerticalCollision;
    protected boolean playerOneHorizontalCollision;

    protected boolean playerTwoVerticalCollision;
    protected boolean playerTwoHorizontalCollision;

    protected double gravity;
    protected double maxMoveY;
    protected boolean falling;
    protected boolean canJump;

    protected boolean left,right;

    protected boolean alive;


    public Creatures(float x, float y){
        super(x,y);
        health = 3;
        xMove = 0;
        yMove = 0;
        gravity = 0.1;
        maxMoveY = 5;
        playerOneVerticalCollision = false;
        playerOneHorizontalCollision =false;
        playerTwoVerticalCollision = false;
        playerTwoHorizontalCollision = false;
        left = false;
        right = true;
        alive = true;

    }
    public abstract void move();
    public void moveX(){
        x += xMove;
    }
    public void moveY(){
        y += yMove;
    }
    public void noEscapeMap(){
        if(x < 0)x = 0;
        if(x > 1150)x = 1150;
        if(y < 0){
            y = 0;
            falling = true;
        }
        if(y > 600)y = 600;
    }
    @Override
    public abstract void tick();
    @Override
    public abstract void render(Graphics g);

    public void fall(){
        if(falling)
            yMove += gravity;
        if(yMove > maxMoveY) yMove = maxMoveY;
    }
    public void jump(double jumpHeight){
        if(canJump){
            yMove -= jumpHeight;
            canJump = false;
        }
    }
    public void changeHealth(){
        health -= 1;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getMaxMoveY() {
        return maxMoveY;
    }

    public void setMaxMoveY(double maxMoveY) {
        this.maxMoveY = maxMoveY;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean canJump() {
        return canJump;
    }

    public void setCanJump(boolean jumping) {
        this.canJump = jumping;
    }

    public boolean isPlayerTwoVerticalCollision() {
        return playerTwoVerticalCollision;
    }

    public void setPlayerTwoVerticalCollision(boolean playerTwoVerticalCollision) {
        this.playerTwoVerticalCollision = playerTwoVerticalCollision;
    }

    public boolean isPlayerTwoHorizontalCollision() {
        return playerTwoHorizontalCollision;
    }

    public void setPlayerTwoHorizontalCollision(boolean playerTwoHorizontalCollision) {
        this.playerTwoHorizontalCollision = playerTwoHorizontalCollision;
    }
    public boolean isPlayerOneverticalCollision() {
        return playerOneVerticalCollision;
    }

    public void setPlayerOneverticalCollision(boolean playerOneverticalCollision) {
        this.playerOneVerticalCollision = playerOneverticalCollision;
    }

    public boolean isPlayerOneHorizontalCollision() {
        return playerOneHorizontalCollision;
    }

    public void setPlayerOneHorizontalCollision(boolean playerOneHorizontalCollision) {
        this.playerOneHorizontalCollision = playerOneHorizontalCollision;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public double getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public double getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}