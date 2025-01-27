package view;

import globals.CustomButton;
import globals.GLOBAL;
import lombok.Getter;

import javax.swing.*;

public class InitPanel extends JPanel {
    private CustomButton startButton;
    private CustomButton exitButton;

    @Getter
    private boolean initSnakes = false;

    public InitPanel() {
        setBounds(0, 0, 800, 600);
        setLayout(null);
        setBackground(GLOBAL.BACKGROUND_COLOR);
        addComponents();
    }
    private void addComponents(){
        addButtons();
        addTitle();
        addAuthor();
    }
    private void addTitle(){
        JLabel title = new JLabel("Snake Game");
        title.setBounds(250, 100, 600, 50);
        title.setFont(GLOBAL.DEFAULT_FONT_TITLES);
        title.setForeground(GLOBAL.DEFAULT_COLOR);
        add(title);
    }
    private void addButtons(){
        startButton = new CustomButton("Start", 200, 50, 20, GLOBAL.DEFAULT_COLOR);
        startButton.addActionListener(_ -> {
            initSnakes = true;
        });
        startButton.setLocation(300, 300);
        add(startButton);

        exitButton = new CustomButton("Exit", 200, 50, 20, GLOBAL.DEFAULT_COLOR);
        exitButton.addActionListener( e -> System.exit(0));
        exitButton.setLocation(300, 400);
        add(exitButton);
    }

    private void addAuthor(){
        JLabel author = new JLabel("By Yaider");
        author.setBounds(50, 550, 100, 50);
        author.setFont(GLOBAL.DEFAULT_FONT_SMALL);
        author.setForeground(GLOBAL.DEFAULT_COLOR);
        add(author);
    }
}
