import java.awt.*;

public class ScopePlayerOne extends Scope {
    public ScopePlayerOne(Game game,PlayerOne playerOne,int width,int height){
        super(game,width,height);
        this.playerOne = playerOne;
    }
    @Override
    public void render(Graphics g) {
        if(game.getKeyManager().upFirstPlayer && game.getKeyManager().rightFirstPlayer){
            g.drawImage(Assets.playerOneScope,(int)playerOne.getX() + 48,(int)playerOne.getY() - 25,null);
            return;
        }
        if(game.getKeyManager().upFirstPlayer && game.getKeyManager().leftFirstPlayer) {
            g.drawImage(Assets.playerOneScope,(int)playerOne.getX() - 20,(int)playerOne.getY() - 25,null);
            return;
        }
        if(game.getKeyManager().upFirstPlayer){
            g.drawImage(Assets.playerOneScope,(int)playerOne.getX() + 15,(int)playerOne.getY() - 25,null);
            return;
        }
        if(game.getKeyManager().downFirstPlayer && game.getKeyManager().rightFirstPlayer) {
            g.drawImage(Assets.playerOneScope,(int)playerOne.getX() + 52,(int)playerOne.getY() + 105,null);
            return;
        }
        if(game.getKeyManager().downFirstPlayer && game.getKeyManager().leftFirstPlayer) {
            g.drawImage(Assets.playerOneScope,(int)playerOne.getX() - 22,(int)playerOne.getY() + 105,null);
            return;
        }
        if(game.getKeyManager().downFirstPlayer){
            g.drawImage(Assets.playerOneScope,(int)playerOne.getX() + 15,(int)playerOne.getY() + 110,null);
            return;
        }
        if(game.getKeyManager().leftFirstPlayer){
            g.drawImage(Assets.playerOneScope,(int)playerOne.getX() - 25,(int)playerOne.getY() + 50,null);
            return;
        }
        if(game.getKeyManager().rightFirstPlayer){
            g.drawImage(Assets.playerOneScope,(int)playerOne.getX() + 52,(int)playerOne.getY() + 50,null);
            return;
        }

    }
}