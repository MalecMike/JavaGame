import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage playerOne,playerTwo,shootOne,shootTwo,obstaclesOne,obstacleTwo,mainObstacle,bottom,top,topLittle,playerOneScope,playerTwoScope,enemy,enemyRight,enemyTwoRight,enemyTwoLeft,
            backGround,enemyThirdLeft,enemyThirdRight,playerOneRight,playerTwoRight,menu,arrow,coop;
    public static void init(){
        playerOne = ImageLoader.loadImage("playerOne.png");
        shootOne = ImageLoader.loadImage("playerOneShoot.png");
        playerOneScope = ImageLoader.loadImage("playerOneScope.png");
        playerTwo = ImageLoader.loadImage("playerTwo.png");
        shootTwo = ImageLoader.loadImage("playerTwoShoot.png");
        playerTwoScope = ImageLoader.loadImage("playerTwoScope.png");
        backGround = ImageLoader.loadImage("backGround.jpg");
        obstaclesOne = ImageLoader.loadImage("120x30.png");
        obstacleTwo = ImageLoader.loadImage("60x30.png");
        bottom = ImageLoader.loadImage("bottom.png");
        mainObstacle = ImageLoader.loadImage("mainObstacle.png");
        top = ImageLoader.loadImage("800x200.png");
        topLittle = ImageLoader.loadImage("50x50.png");
        enemy = ImageLoader.loadImage("Enemy.png");
        enemyRight = ImageLoader.loadImage("100x150Prawo.png");
        enemyTwoRight = ImageLoader.loadImage("enemyTwoRight.png");
        enemyTwoLeft = ImageLoader.loadImage("enemyTwoLeft.png");
        enemyThirdLeft = ImageLoader.loadImage("EnemyThirdLeft.png");
        enemyThirdRight = ImageLoader.loadImage("EnemyThirdRight.png");
        playerOneRight = ImageLoader.loadImage("playerOneRight.png");
        playerTwoRight = ImageLoader.loadImage("playerTworight.png");
        menu = ImageLoader.loadImage("menu.png");
        arrow = ImageLoader.loadImage("arrow.png");
        coop = ImageLoader.loadImage("coop map.png");



    }

}