package com.company;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Game extends JPanel{

    protected Ball ball;

    protected Racquet playerONE;

    protected Racquet playerTWO;



    public Game(){
        this.setSize(600,500);
        ball = new Ball(this);
        playerTWO = new Racquet(this,getWidth()-66,KeyEvent.VK_UP,KeyEvent.VK_DOWN);
        playerONE = new Racquet(this,50,KeyEvent.VK_W,KeyEvent.VK_S);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.addKeyListener(playerONE.listener);
        this.addKeyListener(playerTWO.listener);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(getWidth()/2,0,1,getHeight());
        ball.paint(g2d);
        playerONE.paint(g2d);
        playerTWO.paint(g2d);
    }

    public void move(){
        ball.move();
        playerONE.move();
        playerTWO.move();
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
