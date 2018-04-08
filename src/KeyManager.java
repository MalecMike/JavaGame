import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyManager implements KeyListener {
    private boolean [] keys;
    public boolean leftFirstPlayer,rightFirstPlayer,upFirstPlayer,downFirstPlayer,shootFirstPlayer;
    public boolean leftSecondPlayer,rightSecondPlayer,upSecondPlayer,downSecondPlayer,shootSecondPlayer;
    public boolean enter;
    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        upFirstPlayer = keys[KeyEvent.VK_W];
        downFirstPlayer = keys[KeyEvent.VK_S];
        leftFirstPlayer = keys[KeyEvent.VK_A];
        rightFirstPlayer = keys[KeyEvent.VK_D];
        shootFirstPlayer = keys[KeyEvent.VK_F];
        enter = keys[KeyEvent.VK_ENTER];
        upSecondPlayer = keys[KeyEvent.VK_I];
        downSecondPlayer = keys[KeyEvent.VK_K];
        leftSecondPlayer = keys[KeyEvent.VK_J];
        rightSecondPlayer = keys[KeyEvent.VK_L];
        shootSecondPlayer = keys[KeyEvent.VK_P];
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}