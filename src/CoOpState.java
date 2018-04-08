import java.awt.*;

public class CoOpState extends State {
    private Game game;
    private PlayerOne playerOne;
    private PlayerTwo playerTwo;
    private CollisionDetection collisionDetection;
    private ScopePlayerOne scopePlayerOne;
    private ScopePlayerTwo scopePlayerTwo;
    private ShootPlayerOne shootPlayerOne;
    private ShootPlayerTwo shootPlayerTwo;
    private FirstEnemy firstEnemy;
    private SecondEnemy secondEnemy;
    private ThirdEnemy thirdEnemy;
    private ListOfEnemysAndObstacles enemyList;
    public CoOpState(Game game){
        super(game);
        playerOne = new PlayerOne(game,10,420);
        playerTwo = new PlayerTwo(game,1060,420);
        scopePlayerOne = new ScopePlayerOne(game,playerOne,10,10);
        scopePlayerTwo = new ScopePlayerTwo(game,playerTwo,10,10);
        shootPlayerOne = new ShootPlayerOne(50,50,game,playerOne);
        shootPlayerTwo = new ShootPlayerTwo(50,50,game,playerTwo);


    }
    @Override
    public void tick() {
        playerOne.tick();
        playerTwo.tick();
        shootPlayerOne.tick();
        shootPlayerTwo.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.coop,0,0,null);
        shootPlayerOne.render(g);
        shootPlayerTwo.render(g);
        playerOne.render(g);
        playerTwo.render(g);
        scopePlayerOne.render(g);
        scopePlayerTwo.render(g);
    }

    public PlayerOne getPlayerOne() {
        return playerOne;
    }
}