import java.awt.*;

public class ScopePlayerTwo extends Scope {
    public ScopePlayerTwo (Game game,PlayerTwo playerTwo,int width,int height){
        super(game,width,height);
        this.playerTwo = playerTwo;
    }
    @Override
    public void render(Graphics g) {
        if(game.getKeyManager().upSecondPlayer && game.getKeyManager().rightSecondPlayer){
            g.drawImage(Assets.playerTwoScope,(int)playerTwo.getX() + 48,(int)playerTwo.getY() - 25,null);
            return;
        }
        if(game.getKeyManager().upSecondPlayer && game.getKeyManager().leftSecondPlayer) {
            g.drawImage(Assets.playerTwoScope,(int)playerTwo.getX() - 20,(int)playerTwo.getY() - 25,null);
            return;
        }
        if(game.getKeyManager().upSecondPlayer){
            g.drawImage(Assets.playerTwoScope,(int)playerTwo.getX() + 15,(int)playerTwo.getY() - 25,null);
            return;
        }
        if(game.getKeyManager().downSecondPlayer && game.getKeyManager().rightSecondPlayer) {
            g.drawImage(Assets.playerTwoScope,(int)playerTwo.getX() + 52,(int)playerTwo.getY() + 105,null);
            return;
        }
        if(game.getKeyManager().downSecondPlayer && game.getKeyManager().leftSecondPlayer) {
            g.drawImage(Assets.playerTwoScope,(int)playerTwo.getX() - 22,(int)playerTwo.getY() + 105,null);
            return;
        }
        if(game.getKeyManager().downSecondPlayer){
            g.drawImage(Assets.playerTwoScope,(int)playerTwo.getX() + 15,(int)playerTwo.getY() + 110,null);
            return;
        }
        if(game.getKeyManager().leftSecondPlayer){
            g.drawImage(Assets.playerTwoScope,(int)playerTwo.getX() - 25,(int)playerTwo.getY() + 50,null);
            return;
        }
        if(game.getKeyManager().rightSecondPlayer){
            g.drawImage(Assets.playerTwoScope,(int)playerTwo.getX() + 52,(int)playerTwo.getY() + 50,null);
            return;
        }
    }
}