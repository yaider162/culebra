package view;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(){
        this.setPreferredSize(new java.awt.Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setTitle("Culebra By Yaider");
        initComponents();
    }

    private void initComponents(){
        this.setVisible(true);
    }
}
