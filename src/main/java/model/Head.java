package model;

import globals.GLOBAL;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Head implements Runnable{
    private int x;
    private int y;
    private int direction; // 0: arriba, 1: derecha, 2: abajo, 3: izquierda
    private final int SIZE = 20;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Head(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;

        // Este método se encarga de mover la cabeza cada GLOBAL.SNAKE_SPEED
        scheduler.scheduleAtFixedRate(this, 0, GLOBAL.SNAKE_SPEED, TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
        move();
    }
    private void move(){
        switch (direction){
            case 0:
                y -= SIZE;
                break;
            case 1:
                x += SIZE;
                break;
            case 2:
                y += SIZE;
                break;
            case 3:
                x -= SIZE;
                break;
        }
    }
}
