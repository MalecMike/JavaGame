import java.awt.*;

public class FirstEnemy extends Enemies {
    public FirstEnemy(float x,float y){
        super(x,y);
    }
    @Override
    public void render(Graphics g) {
        if(xMove == -1 && alive)
            g.drawImage(Assets.enemy,(int)x,(int)y,null);
        if(xMove == 1 && alive)
            g.drawImage(Assets.enemyRight,(int)x,(int)y,null);
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
        //g.fillRect(getBounds().x,getBounds().y,getBounds().width,getBounds().height);
    }

    @Override
    public void changeDirection() {
        if(x <= 200){
            xMove = 1;
        }
        if(x >= 420){
            xMove = -1;
        }
    }
}