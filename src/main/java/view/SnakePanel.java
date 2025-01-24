package view;

import globals.GLOBAL;
import lombok.Getter;
import model.Food;
import model.Head;
import model.Tail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class SnakePanel extends JPanel implements KeyListener {
    private final Head head;
    private final ArrayList<Tail> tailSegments;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public SnakePanel() {
        this.setLayout(null);
        this.setBackground(new Color(238,238,228));
        this.head = new Head(GLOBAL.SNAKE_INITIAL_X, GLOBAL.SNAKE_INITIAL_Y, GLOBAL.NORTH);
        this.tailSegments = new ArrayList<>();
        this.add(head);
        initMovement();
        this.addKeyListener(this);
        this.setFocusable(true);
        scheduleTailAddition();
    }
    private void initMovement(){
        Timer timer = new Timer(GLOBAL.SNAKE_SPEED, _ -> head.move());
        timer.start();
    }

    public void scheduleTailAddition() {
        scheduler.scheduleAtFixedRate(this::addFood, 4, 4, TimeUnit.SECONDS);
    }

    public void updateTail(int prevX, int prevY) {
        if (!tailSegments.isEmpty()) {
            Tail lastSegment = tailSegments.removeLast();
            lastSegment.setLocation(prevX, prevY);
            tailSegments.addFirst(lastSegment);
        }
    }
    public void addTailSegment() {
        int tailX = head.getX();
        int tailY = head.getY();
        if (!tailSegments.isEmpty()) {
            Tail lastSegment = tailSegments.getLast();
            tailX = lastSegment.getX();
            tailY = lastSegment.getY();
        }
        Tail newSegment = new Tail(tailX, tailY);
        tailSegments.add(newSegment);
        this.add(newSegment);
        this.repaint();
    }
    public void addFood() {
        Food food = new Food();
        this.add(food);
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        // los if es para que no se pueda cambiar de dirección en sentido contrario
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (head.getDirection() == GLOBAL.SOUTH) return;
                head.setDirection(GLOBAL.NORTH);
                break;
            case KeyEvent.VK_RIGHT:
                if (head.getDirection() == GLOBAL.WEST) return;
                head.setDirection(GLOBAL.EAST);
                break;
            case KeyEvent.VK_DOWN:
                if (head.getDirection() == GLOBAL.NORTH) return;
                head.setDirection(GLOBAL.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                if (head.getDirection() == GLOBAL.EAST) return;
                head.setDirection(GLOBAL.WEST);
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    public void checkFoodCollision() {
        for (Component component : getComponents()) {
            if (component instanceof Food) {
                ((Food) component).checkHead();
            }
        }
    }
}
