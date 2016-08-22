package com.company;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{

    public static void main(String[] args) {
        Game app = new Game();
        JFrame frame = new JFrame("PONG");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(app);
        frame.setVisible(true);
    }
}
