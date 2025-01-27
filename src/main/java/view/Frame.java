package view;

import globals.GLOBAL;
import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Frame extends JFrame {
    private InitPanel initPanel;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Frame( ) {
        this.setPreferredSize(new java.awt.Dimension(GLOBAL.WIDTH, GLOBAL.HEIGHT));
        this.setUndecorated(true);
        this.setTitle(GLOBAL.TITLE);
        this.setResizable(false);
        this.pack(); // sirve para ajustar el tamaño de los componentes
        this.setLocationRelativeTo(null); // Debe ir después de pack porque si no falla
    }
    public void start() {
        initComponents();
        scheduler.scheduleAtFixedRate(this::checkInitPanel, 0, 300, TimeUnit.MILLISECONDS);
        this.setVisible(true);
    }
    private void initComponents() {
        addInit();
    }
    private void checkInitPanel() {
        if (initPanel.isInitSnakes()) {
            SwingUtilities.invokeLater(() -> {
                this.remove(initPanel);
                addSnakePanel();
                this.revalidate();
                this.repaint();
            });
            scheduler.shutdown();
        }
    }
    void addSnakePanel(){
        SnakePanel snakePanel = new SnakePanel();
        this.add(snakePanel);
        snakePanel.requestFocus();
    }
    private void addInit(){
        initPanel = new InitPanel();
        this.add(initPanel);
    }
    // TODO: Implementar sistema de puntaje
}
