package thequizmaster.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import thequizmaster.Constants;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[200];
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean slashPressed = false;
    public boolean changePlayer = false;

    public void update(){
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        if(e.getKeyCode() == Constants.KEY_SLASH) {
        	slashPressed = true;
        }
        if(e.getKeyCode() == Constants.KEY_E) {
        	changePlayer = true;
        }
    }

    
}
