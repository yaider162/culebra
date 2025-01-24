package model;

import globals.GLOBAL;
import view.SnakePanel;

import javax.swing.*;
import java.util.Random;

public class Food extends JComponent {
    private final int x;
    private final int y;
    private final int SIZE = GLOBAL.SIZE;

    public Food(){
        Random rd = new Random();
        this.x = rd.nextInt(800/SIZE)*SIZE;
        this.y = rd.nextInt(600/SIZE)*SIZE;

        setBounds(x, y, SIZE, SIZE);

    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.RED);
        g.fillOval(0, 0, SIZE, SIZE);
    }

    public void checkHead(){
        SnakePanel parent = (SnakePanel) getParent();
        if (parent.getHead().getX() == x && parent.getHead().getY() == y) {
            parent.addTailSegment();
            parent.remove(this);
        }
    }
}
