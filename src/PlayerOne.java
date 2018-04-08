import java.awt.*;

public class PlayerOne extends Creatures {
    private Game game;

    public PlayerOne(Game game, float x, float y) {
        super(x, y);
        this.game = game;
        width = 50;
        height = 110;
        speed = 1;
    }

    public void tick() {
        getInput();
        move();
        fall();
    }

    public void getInput() {
        xMove = 0;
        if (game.getKeyManager().upFirstPlayer) {
            jump(5);
        }
        if (game.getKeyManager().leftFirstPlayer) {
            xMove = -speed;
            left = true;
            right = false;
        }
        if (game.getKeyManager().rightFirstPlayer) {
            xMove = speed;
            right = true;
            left = false;
        }
    }

    public void move() {
        if (!playerOneHorizontalCollision) {
            moveX();
        }
        if (!playerOneVerticalCollision) {
            moveY();
        }
        noEscapeMap();
    }

    public void render(Graphics g) {
        if(left && alive ){
            width = 50;
            g.drawImage(Assets.playerOne, (int) x - 25, (int) y + 3, null);
        }
        if(right && alive){
            width = 50;
            g.drawImage(Assets.playerOneRight, (int) x, (int) y + 3, null);
        }
        if(health == 3){
            g.setColor(Color.green);
            g.fillRect((int)x,(int)y - 15,width,5);
        }
        if(health == 2){
            g.setColor(Color.yellow);
            g.fillRect((int)x,(int)y - 15,width / 2,5);
        }
        if(health == 1){
            g.setColor(Color.red);
            g.fillRect((int)x,(int)y - 15,width / 3,5);
        }
        if(health == 0){
            alive = false;
        }
        /*
        g.setColor(Color.black);
        g.fillRect(getBotBounds().x,getBotBounds().y,getBotBounds().width,getBotBounds().height);
        g.fillRect(getLeftBounds().x,getLeftBounds().y,getLeftBounds().width,getLeftBounds().height);
        g.fillRect(getTopBounds().x,getTopBounds().y,getTopBounds().width,getTopBounds().height);
        g.fillRect(getRightBounds().x,getRightBounds().y,getRightBounds().width,getRightBounds().height);
        */
    }
}