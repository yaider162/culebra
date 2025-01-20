package view;

import globals.GLOBAL;
import model.Head;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakePanel extends JPanel implements KeyListener {
    private Head head;
    public SnakePanel() {
        this.setLayout(null);
        this.setBackground(new Color(238,238,228));
        this.head = new Head(GLOBAL.SNAKE_INITIAL_X, GLOBAL.SNAKE_INITIAL_Y, GLOBAL.NORTH);
        this.add(head);
        initMovement();
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    private void initMovement(){
        Timer timer = new Timer(GLOBAL.SNAKE_SPEED, e -> {
            head.move();
        });
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                head.setDirection(GLOBAL.NORTH);
                break;
            case KeyEvent.VK_RIGHT:
                head.setDirection(GLOBAL.EAST);
                break;
            case KeyEvent.VK_DOWN:
                head.setDirection(GLOBAL.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                head.setDirection(GLOBAL.WEST);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
