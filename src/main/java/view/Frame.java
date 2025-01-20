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
        //addTempTilesTest();
    }
//    private void addTempTilesTest(){
//        TempTilesTest tempTilesTest = new TempTilesTest();
//        tempTilesTest.setBounds(0, 0, GLOBAL.WIDTH, GLOBAL.HEIGHT);
//        layeredPane.add(tempTilesTest, JLayeredPane.PALETTE_LAYER);
//    }
    private void addSnakePanel(){
        SnakePanel snakePanel = new SnakePanel();
        this.add(snakePanel);
    }
}
