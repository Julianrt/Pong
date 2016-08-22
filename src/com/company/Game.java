package com.company;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Game extends JPanel{

    protected Ball ball;


    public Game(){
        ball = new Ball(this);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(getWidth()/2,0,1,getHeight());
        ball.paint(g2d);
    }

    public void move(){
        ball.move();
    }

    public static void main(String[] args) {
        Game app = new Game();
        JFrame frame = new JFrame("PONG");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(app);
        frame.setVisible(true);

        while(true){
            app.repaint();
            app.move();
            try{
                Thread.sleep(5);
            }catch(Exception ex){}

        }
    }
}
