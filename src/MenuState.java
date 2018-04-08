import java.awt.*;

public class MenuState extends State {
    private Game game;
    private GameState gameState;
    private CoOpState coOpState;
    private State state;
    private KeyManager keyManager;
    private int choice;
    public MenuState(Game game,GameState gameState,State state,CoOpState coOpState,KeyManager keyManager){
        super(game);
        this.gameState = gameState;
        this.state = state;
        this.keyManager = keyManager;
        this.coOpState = coOpState;
        choice = 3;
    }
    public void tick(){
        setChoice();
        System.out.println(choice);
        changeState();
    }
    public void render(Graphics g){
        g.drawImage(Assets.menu,0,0,null);
        if(choice == 2)
            g.drawImage(Assets.arrow,540,160,null);
        if(choice == 1)
            g.drawImage(Assets.arrow,220,250,null);
        if(choice == 3)
            g.drawImage(Assets.arrow,600,250,null);
    }
    public void setChoice(){
        if(keyManager.rightFirstPlayer)choice = 3;
        if(keyManager.leftFirstPlayer)choice = 1;
        if(keyManager.downFirstPlayer)choice = 2;

    }
    public void changeState(){
        if(choice == 1 && keyManager.enter){
            State.setState(gameState);
        }
        if(choice == 3 && keyManager.enter){
            State.setState(coOpState);
        }
    }

}