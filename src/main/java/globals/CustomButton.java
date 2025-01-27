package globals;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    private final int width;
    private final int height;
    private final int size;
    private final Color color;
    public CustomButton(String text, int width, int height, int size, Color color) {
        super(text);
        this.width = width;
        this.height = height;
        this.size = size;
        this.color = color;
        setBounds(0, 0, width, height);
        setBackground(color);
        customize();
    }
    private void customize(){
        setFont(GLOBAL.DEFAULT_FONT);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        hoverEffect();
    }
    private void hoverEffect(){
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(color.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(color);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                setBackground(color.darker());
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                setBackground(color.brighter());
            }
        });
    }
}
