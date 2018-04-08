import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private Display display;
    public int width,height;
    public String title;

    private Thread thread;
    private boolean running = false;

    private State state;
    private GameState gameState;
    private MenuState menuState;
    private CoOpState coOpState;
    private KeyManager keyManager;
    private GameCamera camera;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    // klasa ktorej potrzebujemy do images
    private BufferedImage bufferedImage;

    public Game(String title,int width,int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
        gameState = new GameState(this);
        coOpState = new CoOpState(this);
        menuState = new MenuState(this,gameState,state,coOpState,keyManager);


    }
    public void initialization(){
        display = new Display(title,width,height);
        Assets.init();
        camera = new GameCamera(0,0,gameState,this);
        state = menuState;
        State.setState(state);
        display.getjFrame().addKeyListener(keyManager);
    }
    public void tick(){
        keyManager.tick();
        if(State.getState() != null){
            State.getState().tick();
        }
        camera.tick(coOpState);
    }
    public void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bufferStrategy.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) graphics;
        graphics.clearRect(0, 0, width, height);
        if(State.getState() == coOpState) {
            g2d.translate(camera.getX(), camera.getY());
            graphics.clearRect(0, 0, width, height);
            if (State.getState() != null) {
                State.getState().render(graphics);
            }
            g2d.translate(-camera.getX(), -camera.getY());
            bufferStrategy.show();
            graphics.dispose();
        }
        else {
            if (State.getState() != null) {
                State.getState().render(graphics);
            }
            bufferStrategy.show();
            graphics.dispose();
        }
    }
    public void run(){
        initialization();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while(running){
            now = System.nanoTime();
            delta += (now -lastTime) / timePerTick;
            lastTime = now;
            if(delta >= 1){
                tick();
                render();
            }

        }
        stop();
    }
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public KeyManager getKeyManager() {
        return keyManager;
    }

    public Graphics getGraphics() {
        return graphics;
    }
}