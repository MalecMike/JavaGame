import java.awt.*;

public class GameState extends State {

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
    public GameState(Game game){
        super(game);
        playerOne = new PlayerOne(game,10,420);
        playerTwo = new PlayerTwo(game,1060,420);
        scopePlayerOne = new ScopePlayerOne(game,playerOne,10,10);
        scopePlayerTwo = new ScopePlayerTwo(game,playerTwo,10,10);
        shootPlayerOne = new ShootPlayerOne(50,50,game,playerOne);
        shootPlayerTwo = new ShootPlayerTwo(50,50,game,playerTwo);
        enemyList = new ListOfEnemysAndObstacles();
        firstEnemy = new FirstEnemy(250,33);
        secondEnemy = new SecondEnemy(550,33);
        thirdEnemy = new ThirdEnemy(520,230);
        collisionDetection = new CollisionDetection(playerOne,playerTwo,enemyList,shootPlayerOne,shootPlayerTwo,firstEnemy,secondEnemy,thirdEnemy);

    }
    @Override
    public void tick() {
        playerOne.tick();
        playerTwo.tick();
        shootPlayerOne.tick();
        shootPlayerTwo.tick();
        collisionDetection.tick();
        firstEnemy.tick();
        secondEnemy.tick();
        thirdEnemy.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.backGround,0,0,null);
        g.drawImage(Assets.obstaclesOne,270,470,null);
        g.drawImage(Assets.obstaclesOne,35,390,null);
        g.drawImage(Assets.obstaclesOne,800,470,null);
        g.drawImage(Assets.obstaclesOne,1035,390,null);
        g.drawImage(Assets.obstacleTwo,28,270,null);
        g.drawImage(Assets.obstacleTwo,1120,270,null);
        g.drawImage(Assets.bottom,0,580,null);
        g.drawImage(Assets.mainObstacle,500,378,null);
        g.drawImage(Assets.top,200,190,null);
        g.drawImage(Assets.topLittle,585,140,null);
        shootPlayerOne.render(g);
        shootPlayerTwo.render(g);
        playerOne.render(g);
        playerTwo.render(g);
        scopePlayerOne.render(g);
        scopePlayerTwo.render(g);
        enemyList.render(g);
        firstEnemy.render(g);
        secondEnemy.render(g);
        thirdEnemy.render(g);

    }

    public PlayerOne getPlayerOne() {
        return playerOne;
    }
}