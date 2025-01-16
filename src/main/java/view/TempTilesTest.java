package view;

import javax.swing.*;
import java.awt.*;

public class TempTilesTest extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la cuadrícula
        g.setColor(Color.LIGHT_GRAY);

        // Tamaño de cada celda (20x20 píxeles)
        int tileSize = 20;

        int cols = 800 / tileSize; // Columnas en base al tamaño del panel
        int rows = 600 / tileSize; // Filas basándonos en el tamaño del panel

        for (int i = 0; i <= cols; i++) {
            // para dibujar cada line se necesitan dos puntos (Nota al pie)
            g.drawLine(i * tileSize, 0, i * tileSize, 600); // Líneas verticales
        }
        for (int i = 0; i <= rows; i++) {
            g.drawLine(0, i * tileSize, 800, i * tileSize); // Líneas horizontales
        }
    }
}
