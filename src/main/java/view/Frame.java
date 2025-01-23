package view;

import globals.GLOBAL;
import javax.swing.*;

public class Frame extends JFrame {
    public Frame( ) {
        this.setPreferredSize(new java.awt.Dimension(GLOBAL.WIDTH, GLOBAL.HEIGHT));
        this.setUndecorated(true);
        this.setTitle(GLOBAL.TITLE);
        this.pack(); // sirve para ajustar el tamaño de los componentes
        this.setLocationRelativeTo(null); // Debe ir después de pack porque si no falla
    }
    public void start() {
        initComponents();
        this.setVisible(true);
    }
    private void initComponents() {
        addSnakePanel();
    }
    private void addSnakePanel(){
        SnakePanel snakePanel = new SnakePanel();
        this.add(snakePanel);
    }
}
