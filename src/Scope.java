import java.awt.*;

public abstract class Scope {
    protected Game game;
    protected PlayerOne playerOne;
    protected PlayerTwo playerTwo;
    protected int width,height;
    public Scope(Game game,int width,int height){
        this.game = game;
        this.width = width;
        this.height = height;
    }
    public abstract void render(Graphics g);

}