package view;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(){
        this.setPreferredSize(new java.awt.Dimension(800, 600));
        this.setUndecorated(true);
        this.setTitle("Culebra By Yaider");
        this.pack(); // sirve para ajustar el tamaño de los componentes
        this.setLocationRelativeTo(null); // Debe ir después de pack porque si no falla
        initComponents();
        this.setVisible(true);
    }

    private void initComponents(){
        addTempTilesTest();
    }

    private void addTempTilesTest(){
        TempTilesTest tempTilesTest = new TempTilesTest();
        this.add(tempTilesTest);
    }
}
