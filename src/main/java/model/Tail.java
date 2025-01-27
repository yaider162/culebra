package model;

import globals.GLOBAL;

import javax.swing.*;
import java.awt.*;

public class Tail extends JComponent {
    private final int SIZE = 20;
    private final Color color = GLOBAL.DEFAULT_COLOR;

    public Tail(int x, int y) {
        setBounds(x, y, SIZE, SIZE);
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, SIZE, SIZE);
    }
}
