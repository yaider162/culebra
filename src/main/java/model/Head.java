package model;

import globals.GLOBAL;
import lombok.Getter;
import lombok.Setter;
import view.SnakePanel;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Head extends JComponent{
    private int x;
    private int y;
    private int direction; // 0: arriba, 1: derecha, 2: abajo, 3: izquierda
    private final int SIZE = GLOBAL.SIZE;

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
    public void move() {
        int prevX = x;
        int prevY = y;
        switch (direction) {
            case 0: // arriba
                y -= SIZE;
                if (y < 20) {
                    y = 0;
                    direction = GLOBAL.SOUTH; // cambia abajo
                }
                break;
            case 1: // derecha
                x += SIZE;
                if (x + SIZE > getParent().getWidth()-20) {
                    x = getParent().getWidth() - SIZE;
                    direction = GLOBAL.WEST; // cambia a izquierda
                }
                break;
            case 2: // abajo
                y += SIZE;
                if (y + SIZE > getParent().getHeight()-20d) {
                    y = getParent().getHeight() - SIZE;
                    direction = GLOBAL.NORTH; // cambia a arriba
                }
                break;
            case 3: // izquierda
                x -= SIZE;
                if (x < 20) {
                    x = 0;
                    direction = GLOBAL.EAST; // cambia a derecha
                }
                break;
        }
        setLocation(x, y);
        repaint();
        ((SnakePanel) getParent()).updateTail(prevX, prevY);
        ((SnakePanel) getParent()).checkFoodCollision();
    }

}
