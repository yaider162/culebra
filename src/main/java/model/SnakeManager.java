package model;

import globals.GLOBAL;

public class SnakeManager {
    private Head head;

    public SnakeManager() {
        head = new Head(400, 300, GLOBAL.NORTH);
    }
}
