package model;

import javax.swing.*;
import java.awt.*;

public class Tail extends JComponent {
    private final int SIZE = 20;
    private final Color color = randomColor();

    public Tail(int x, int y) {
        setBounds(x, y, SIZE, SIZE);
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, SIZE, SIZE);
    }

    private Color randomColor(){
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }
}
