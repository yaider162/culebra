package globals;

import java.awt.*;
import java.io.File;
import java.io.IOException;

// Aquí se encuentran todas las variables globales que se utilizan en el proyecto
public class GLOBAL {
    public static int NORTH = 0;
    public static int EAST = 1;
    public static int SOUTH = 2;
    public static int WEST = 3;

    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public static int SIZE = 20; // tamaño de la celda

    public static int SNAKE_SPEED = 100; // controla la velocidad del head

    public static int SNAKE_INITIAL_X = 400;
    public static int SNAKE_INITIAL_Y = 300;

    public static String TITLE = "Culebra By Yaider";

    public static Color DEFAULT_COLOR = new Color(32, 32, 32);
    public static Color BACKGROUND_COLOR = new Color(215, 210, 237);

    private static final String FONT_PATH = "src/main/resources/fonts/Minecraft.ttf";
    public static Font PIXEL_FONT;

    static {
        try {
            PIXEL_FONT = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_PATH));
        } catch (FontFormatException | IOException e) {
            System.out.println("JAJA fallo la fuente");
            throw new RuntimeException(e);
        }
    }
    public static Font DEFAULT_FONT = PIXEL_FONT.deriveFont(30f);
    public static Font DEFAULT_FONT_TITLES = PIXEL_FONT.deriveFont(50f);
    public static Font DEFAULT_FONT_SMALL = PIXEL_FONT.deriveFont(20f);
}
