package thequizmaster.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import thequizmaster.Constants;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[524];
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean slashPressed = false;
    public boolean changePlayer = false;
    public boolean upReleased = false;
    public boolean downReleased = false;
    public boolean enterReleased = false;
    public int playerSelection = 0;
    public boolean selectionChanged = false;
    public boolean interacting = false;
    public boolean useItem = true;
    public boolean droppingItem = true;
    public boolean wantsBioMenu = false;

    public void update(){
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        droppingItem = keys[KeyEvent.VK_Q];
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
        if(e.getKeyCode() == KeyEvent.VK_R) {
        	changePlayer = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
        	upReleased = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
        	downReleased = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
        	enterReleased = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_1) {
            setPlayerSelection(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_2) {
            setPlayerSelection(1);
        }
        if(e.getKeyCode() == KeyEvent.VK_3) {
            setPlayerSelection(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_4) {
            setPlayerSelection(3);
        }
        if(e.getKeyCode() == KeyEvent.VK_5) {
            setPlayerSelection(4);
        }
        if(e.getKeyCode() == KeyEvent.VK_6) {
            setPlayerSelection(5);
        }
        if(e.getKeyCode() == KeyEvent.VK_7) {
            setPlayerSelection(6);
        }
        if(e.getKeyCode() == KeyEvent.VK_8) {
            setPlayerSelection(7);
        }
        if(e.getKeyCode() == KeyEvent.VK_9) {
            setPlayerSelection(8);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            useItem = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_E) {
            interacting = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
            wantsBioMenu = true;
        }

    }

    public void setPlayerSelection(int selection){
        playerSelection = selection;
        selectionChanged = true;
    }
}
