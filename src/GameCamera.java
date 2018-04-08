public class GameCamera {
    private float x,y;
    private GameState gameState;
    private Game game;
    public GameCamera(float x ,float y,GameState gameState,Game game){
        this.x = x;
        this.y = y;
        this.gameState = gameState;
        this.game = game;
    }
    public void tick(State state){
        x -= 0.4f ;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}