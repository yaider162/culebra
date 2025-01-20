package model;

import globals.GLOBAL;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Getter
@Setter
public class Head extends JComponent{
    private int x;
    private int y;
    private int direction; // 0: arriba, 1: derecha, 2: abajo, 3: izquierda
    private final int SIZE = 20;

    public Head(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        setBounds(x, y, SIZE, SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, SIZE, SIZE);
    }
// TODO 2: implementar la cola
    public void move() {
        switch (direction) {
            case 0: // arriba
                y -= SIZE;
                if (y < 0) {
                    y = 0;
                    direction = GLOBAL.SOUTH; // cambia abajo
                }
                break;
            case 1: // derecha
                x += SIZE;
                if (x + SIZE > getParent().getWidth()) {
                    x = getParent().getWidth() - SIZE;
                    direction = GLOBAL.WEST; // cambia a izquierda
                }
                break;
            case 2: // abajo
                y += SIZE;
                if (y + SIZE > getParent().getHeight()) {
                    y = getParent().getHeight() - SIZE;
                    direction = GLOBAL.NORTH; // cambia a arriba
                }
                break;
            case 3: // izquierda
                x -= SIZE;
                if (x < 0) {
                    x = 0;
                    direction = GLOBAL.EAST; // cambia a derecha
                }
                break;
        }
        setLocation(x, y);
        repaint();
    }
}
