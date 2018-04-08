import java.awt.*;

public class PlayerTwo extends Creatures {
    private Game game;

    public PlayerTwo(Game game, float x, float y) {
        super(x, y);
        this.game = game;
        width = 50;
        height = 110;
        speed = 1;
    }

    @Override
    public void tick() {
        getInput();
        move();
        fall();
    }

    public void getInput() {
        xMove = 0;
        if (game.getKeyManager().upSecondPlayer) {
            jump(5);
        }
        if (game.getKeyManager().leftSecondPlayer) {
            xMove = -speed;
            left = true;
            right = false;
        }
        if (game.getKeyManager().rightSecondPlayer) {
            xMove = speed;
            right = true;
            left = false;
        }
    }

    public void move() {
        if (!playerTwoHorizontalCollision) {
            moveX();
        }
        if (!playerTwoVerticalCollision) {
            moveY();
        }
        noEscapeMap();

    }

    @Override
    public void render(Graphics g) {
        if(left && alive){
            width = 50;
            g.drawImage(Assets.playerTwo, (int) x - 25, (int) y + 3, null);
        }

        if(right && alive){
            g.drawImage(Assets.playerTwoRight, (int) x, (int) y + 3, null);
            width = 50;
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
        g.fillRect(getBotBounds().x,getBotBounds().y,getBotBounds().width,getBotBounds().height);
        g.fillRect(getLeftBounds().x,getLeftBounds().y,getLeftBounds().width,getLeftBounds().height);
        g.fillRect(getTopBounds().x,getTopBounds().y,getTopBounds().width,getTopBounds().height);
        g.fillRect(getRightBounds().x,getRightBounds().y,getRightBounds().width,getRightBounds().height);
        */
    }
}