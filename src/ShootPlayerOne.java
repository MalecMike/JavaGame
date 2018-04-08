import java.awt.*;

public class ShootPlayerOne extends Shoot {
    public ShootPlayerOne(int width,int height,Game game,PlayerOne playerOne){
        super(width,height,game);
        this.playerOne = playerOne;
        x = (int)playerOne.getX() + 50;
        y = (int)playerOne.getY() + 70;
    }
    @Override
    public void tick() {
        if(!moveShoot){
            x = (int)playerOne.getX();
            y = (int)playerOne.getY() + 30;
        }
        // przy kolizji z czym kolwiek ma wrocic na swoje miejsce to jest na czas prob i odjac graczu punkt zycia
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
    public void setMovers(){
        if(game.getKeyManager().upFirstPlayer && game.getKeyManager().shootFirstPlayer && canMoveInOtherWay && !game.getKeyManager().leftFirstPlayer && !game.getKeyManager().rightFirstPlayer){
            moveY = -3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().upFirstPlayer && game.getKeyManager().leftFirstPlayer && game.getKeyManager().shootFirstPlayer && canMoveInOtherWay){
            moveY = -3;
            moveX = -3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().upFirstPlayer && game.getKeyManager().rightFirstPlayer && game.getKeyManager().shootFirstPlayer && canMoveInOtherWay){
            moveY = -3;
            moveX = 3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }

        if(game.getKeyManager().downFirstPlayer && game.getKeyManager().shootFirstPlayer && canMoveInOtherWay && !game.getKeyManager().leftFirstPlayer && !game.getKeyManager().rightFirstPlayer){
            moveY = 3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().downFirstPlayer && game.getKeyManager().leftFirstPlayer && game.getKeyManager().shootFirstPlayer && canMoveInOtherWay){
            moveY = 3;
            moveX = -3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().downFirstPlayer && game.getKeyManager().rightFirstPlayer && game.getKeyManager().shootFirstPlayer && canMoveInOtherWay){
            moveY = 3;
            moveX = 3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().leftFirstPlayer && game.getKeyManager().shootFirstPlayer && canMoveInOtherWay){
            moveX = -3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
        if(game.getKeyManager().rightFirstPlayer && game.getKeyManager().shootFirstPlayer && canMoveInOtherWay){
            moveX = 3;
            moveShoot = true;
            alreadyShooted = true;
            canMoveInOtherWay = false;
        }
    }

    @Override
    public void render(Graphics g) {
        if(game.getKeyManager().shootFirstPlayer || alreadyShooted){
            g.drawImage(Assets.shootOne,x,y,null);
            g.setColor(Color.black);
            //g.fillRect(getBounds().x,getBounds().y,width,height);
        }
    }

}