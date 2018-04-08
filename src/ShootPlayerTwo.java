import java.awt.*;

public class ShootPlayerTwo extends Shoot {
    public ShootPlayerTwo(int width,int height,Game game,PlayerTwo playerTwo){
        super(width,height,game);
        this.playerTwo = playerTwo;
        x = (int)playerTwo.getX() + 15;
        y = (int)playerTwo.getY() + 15;
    }

    @Override
    public void tick() {
        if(!moveShoot){
            x = (int)playerTwo.getX();
            y = (int)playerTwo.getY() + 35;
        }
        if(x < 0 || x > 1200 || y < 0 || y > 600 || collision){
            moveShoot = false;
            canMoveInOtherWay = true;
            alreadyShooted = false;
            moveX = 0;
            moveY = 0;
        }
        collision = false;
        setMovers();
        x += moveX;
        y += moveY;
    }
    public void setMovers() {
        if(game.getKeyManager().upSecondPlayer && game.getKeyManager().shootSecondPlayer && canMoveInOtherWay && !game.getKeyManager().leftSecondPlayer && !game.getKeyManager().rightSecondPlayer){
            moveY = -3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().upSecondPlayer && game.getKeyManager().leftSecondPlayer && game.getKeyManager().shootSecondPlayer && canMoveInOtherWay){
            moveY = -3;
            moveX = -3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().upSecondPlayer && game.getKeyManager().rightSecondPlayer && game.getKeyManager().shootSecondPlayer && canMoveInOtherWay){
            moveY = -3;
            moveX = 3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }

        if(game.getKeyManager().downSecondPlayer && game.getKeyManager().shootSecondPlayer && canMoveInOtherWay && !game.getKeyManager().leftSecondPlayer && !game.getKeyManager().rightSecondPlayer){
            moveY = 3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().downSecondPlayer && game.getKeyManager().leftSecondPlayer && game.getKeyManager().shootSecondPlayer && canMoveInOtherWay){
            moveY = 3;
            moveX = -3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().downSecondPlayer && game.getKeyManager().rightSecondPlayer && game.getKeyManager().shootSecondPlayer && canMoveInOtherWay){
            moveY = 3;
            moveX = 3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().leftSecondPlayer && game.getKeyManager().shootSecondPlayer && canMoveInOtherWay){
            moveX = -3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().rightSecondPlayer && game.getKeyManager().shootSecondPlayer && canMoveInOtherWay){
            moveX = 3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
    }

    @Override
    public void render(Graphics g) {
        if(game.getKeyManager().shootSecondPlayer || alreadyShooted){
            g.drawImage(Assets.shootTwo,x,y,null);
            g.setColor(Color.black);
            //g.fillRect(getBounds().x,getBounds().y,width,height);
        }
    }
}