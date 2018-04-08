import java.util.List;

public class CollisionDetection {
    private PlayerOne playerOne;
    private PlayerTwo playerTwo;
    private ListOfEnemysAndObstacles listOfEnemysAndObstacles;
    private ShootPlayerOne shootPlayerOne;
    private ShootPlayerTwo shootPlayerTwo;
    private FirstEnemy firstEnemy;
    private SecondEnemy secondEnemy;
    private ThirdEnemy thirdEnemy;

    public CollisionDetection(PlayerOne playerOne, PlayerTwo playerTwo, ListOfEnemysAndObstacles listOfEnemysAndObstacles,ShootPlayerOne shootPlayerOne,ShootPlayerTwo shootPlayerTwo,FirstEnemy firstEnemy,SecondEnemy secondEnemy,ThirdEnemy thirdEnemy) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.listOfEnemysAndObstacles = listOfEnemysAndObstacles;
        this.shootPlayerOne = shootPlayerOne;
        this.shootPlayerTwo = shootPlayerTwo;
        this.firstEnemy = firstEnemy;
        this.secondEnemy = secondEnemy;
        this.thirdEnemy = thirdEnemy;
    }
    public void tick(){
        checkPlayerOneVerticalCollisionWithObstacles();
        checkPlayerOneHorizontalCollisionWithObstacles();
        checkPlayerTwoVerticalCollisionWithObstacles();
        checkPlayerTwoHorizontalCollisionWithObstacles();
        checkShootPlayerOneWithPlayerTwo();
        checkShootPlayerOneObstacle();
        checkShootPlayerOneFirstEnemy();
        checkShootPlayerOneSecondEnemy();
        checkShootPlayerOneThirdEnemy();
        checkShootPlayerTwoWithPlayerOne();
        checkShootPlayerTwoObstacle();
        checkShootPlayerTwoFirstEnemy();
        checkShootPlayerTwoSecondEnemy();
        checkShootPlayerTwoThirdEnemy();
        firstOne();
        firstTwo();
        secondOne();
        secondTwo();
        thirdOne();
        thirdTwo();

    }
    public void firstOne(){
        if(firstEnemy.getBounds().intersects(playerOne.getBounds()) && (firstEnemy.getAlive())){
            playerOne.changeHealth();
        }
    }
    public void firstTwo(){
        if(firstEnemy.getBounds().intersects(playerTwo.getBounds()) && (firstEnemy.getAlive())){
            playerTwo.changeHealth();
        }
    }
    public void secondOne(){
        if(secondEnemy.getBounds().intersects(playerOne.getBounds()) && (secondEnemy.getAlive())){
            playerOne.changeHealth();
        }
    }
    public void secondTwo(){
        if(secondEnemy.getBounds().intersects(playerTwo.getBounds()) && (secondEnemy.getAlive())){
            playerTwo.changeHealth();
        }
    }
    public void thirdOne(){
        if(thirdEnemy.getBounds().intersects(playerOne.getBounds()) && (thirdEnemy.getAlive())){
            playerOne.changeHealth();
        }
    }
    public void thirdTwo(){
        if(thirdEnemy.getBounds().intersects(playerTwo.getBounds()) && (thirdEnemy.getAlive())){
            playerTwo.changeHealth();
        }
    }
    public void makeChangeForTwo(){
        shootPlayerTwo.setMoveShoot(false);
        shootPlayerTwo.setAlreadyShooted(false);
        shootPlayerTwo.setCanMoveInOtherWay(true);
        shootPlayerTwo.setCollision(true);
    }
    public void makeChangeForOne(){
        shootPlayerOne.setMoveShoot(false);
        shootPlayerOne.setAlreadyShooted(false);
        shootPlayerOne.setCanMoveInOtherWay(true);
        shootPlayerOne.setCollision(true);
    }
    public void checkShootPlayerTwoWithPlayerOne(){
        if(shootPlayerTwo.getBounds().intersects(playerOne.getBounds()) && shootPlayerTwo.isAlreadyShooted()){
            playerOne.changeHealth();
            makeChangeForTwo();
        }
    }
    public void checkShootPlayerTwoObstacle(){
        for (int i = 0; i < listOfEnemysAndObstacles.getObstaclesList().size(); i++){
            if(shootPlayerTwo.getBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getTopBounds())){
                makeChangeForTwo();
            }
        }
    }
    public void checkShootPlayerTwoFirstEnemy(){
        if(shootPlayerTwo.getBounds().intersects(firstEnemy.getBounds()) && (firstEnemy.getAlive()) && shootPlayerTwo.alreadyShooted){
            firstEnemy.changeHealth();
            makeChangeForTwo();
        }
    }
    public void checkShootPlayerTwoSecondEnemy(){
        if(shootPlayerTwo.getBounds().intersects(secondEnemy.getBounds()) && (secondEnemy.getAlive() && shootPlayerTwo.alreadyShooted)){
            secondEnemy.changeHealth();
            makeChangeForTwo();
        }
    }
    public void checkShootPlayerTwoThirdEnemy(){
        if(shootPlayerTwo.getBounds().intersects(thirdEnemy.getBounds()) && (thirdEnemy.getAlive() && shootPlayerTwo.alreadyShooted)){
            thirdEnemy.changeHealth();
            makeChangeForTwo();
        }
    }
    public void checkShootPlayerOneWithPlayerTwo(){
        if(shootPlayerOne.getBounds().intersects(playerTwo.getBounds()) && shootPlayerOne.isAlreadyShooted()){
            playerTwo.changeHealth();
            makeChangeForOne();
        }
    }
    public void checkShootPlayerOneObstacle(){
        for (int i = 0; i < listOfEnemysAndObstacles.getObstaclesList().size(); i++){
            if(shootPlayerOne.getBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getTopBounds())){
                makeChangeForOne();
            }
        }
    }
    public void checkShootPlayerOneFirstEnemy(){
        if(shootPlayerOne.getBounds().intersects(firstEnemy.getBounds()) && (firstEnemy.getAlive()) && shootPlayerOne.alreadyShooted){
            firstEnemy.changeHealth();
            makeChangeForOne();
        }
    }
    public void checkShootPlayerOneSecondEnemy(){
        if(shootPlayerOne.getBounds().intersects(secondEnemy.getBounds()) && (secondEnemy.getAlive() && shootPlayerOne.alreadyShooted)){
            secondEnemy.changeHealth();
            makeChangeForOne();
        }
    }
    public void checkShootPlayerOneThirdEnemy(){
        if(shootPlayerOne.getBounds().intersects(thirdEnemy.getBounds()) && (thirdEnemy.getAlive() && shootPlayerOne.alreadyShooted)){
            thirdEnemy.changeHealth();
            makeChangeForOne();
        }
    }


    public void checkPlayerOneVerticalCollisionWithObstacles() {
        for (int i = 0; i < listOfEnemysAndObstacles.getObstaclesList().size(); i++) {
            if (playerOne.getBotBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getTopBounds()) && (playerOne.yMove > 0)) {
                playerOne.setyMove(0);
                playerOne.setCanJump(true);
                playerOne.setFalling(false);
                playerOne.setPlayerOneverticalCollision(true);
                break;
            }
            else {
                playerOne.setPlayerOneverticalCollision(false);
                playerOne.setFalling(true);
            }
            if (playerOne.getBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getBotBounds()) && playerOne.yMove < 0) {
                playerOne.setyMove(0);
                playerOne.setPlayerOneverticalCollision(true);
                System.out.println("kolizja dolna");
                break;
            }
            else playerOne.setPlayerOneverticalCollision(false);
        }

    }
    public void checkPlayerOneHorizontalCollisionWithObstacles() {
        for (int i = 0; i < listOfEnemysAndObstacles.getObstaclesList().size(); i++) {
            if (playerOne.getBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getRightBounds()) && playerOne.xMove < 0) {
                playerOne.setxMove(0);
                playerOne.setPlayerOneHorizontalCollision(true);
                System.out.println("kolizja lewa");
                break;
            }
            else playerOne.setPlayerOneHorizontalCollision(false);
            if (playerOne.getBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getLeftBounds()) && playerOne.xMove > 0) {
                playerOne.setxMove(0);
                playerOne.setPlayerOneHorizontalCollision(true);
                System.out.println("kolizja prawa");
                break;
            }
            else playerOne.setPlayerOneHorizontalCollision(false);
        }
    }
    public void checkPlayerTwoVerticalCollisionWithObstacles() {
        for (int i = 0; i < listOfEnemysAndObstacles.getObstaclesList().size(); i++) {
            if (playerTwo.getBotBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getTopBounds()) && (playerTwo.yMove > 0)) {
                playerTwo.setyMove(0);
                playerTwo.setCanJump(true);
                playerTwo.setFalling(false);
                playerTwo.setPlayerTwoVerticalCollision(true);
                break;
            }
            else {
                playerTwo.setPlayerTwoVerticalCollision(false);
                playerTwo.setFalling(true);
            }

            if (playerTwo.getBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getBotBounds()) && playerTwo.yMove < 0) {
                playerTwo.setyMove(0);
                playerTwo.setPlayerTwoVerticalCollision(true);
                break;
            }
            else playerTwo.setPlayerTwoVerticalCollision(false);
        }

    }
    public void checkPlayerTwoHorizontalCollisionWithObstacles() {
        for (int i = 0; i < listOfEnemysAndObstacles.getObstaclesList().size(); i++) {
            if (playerTwo.getBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getRightBounds()) && playerTwo.xMove < 0) {
                playerTwo.setxMove(0);
                playerTwo.setPlayerTwoHorizontalCollision(true);
                break;
            }
            else playerTwo.setPlayerTwoHorizontalCollision(false);
            if (playerTwo.getBounds().intersects(listOfEnemysAndObstacles.getObstaclesList().get(i).getLeftBounds()) && playerTwo.xMove > 0) {
                playerTwo.setxMove(0);
                playerTwo.setPlayerTwoHorizontalCollision(true);
                break;
            }
            else playerTwo.setPlayerTwoHorizontalCollision(false);
        }
    }
}