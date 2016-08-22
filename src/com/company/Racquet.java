package com.company;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Racquet {

    private int x,y;

    protected int moveY;

    private final int WIDTH = 16;

    private final int HEIGHT = 32;

    private Game app;

    public KeyListener listener;

    public Racquet(Game app, int x, int keyUP, int keyDOWN){
        this.app = app;
        this.x = x;
        this.y = app.getHeight()/2-32;
        this.moveY = 0;

         listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == keyUP)
                    moveY=-1;
                else if(e.getKeyCode() == keyDOWN)
                    moveY=1;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==keyUP || e.getKeyCode()==keyDOWN)
                    moveY=0;
            }
        };
    }

    public void paint(final Graphics2D g2d){
        g2d.fillRect(x,y,WIDTH,HEIGHT);
    }

    public void move(){
        if((moveY==-1 && y>=0) || (moveY==1&&y<=app.getHeight()-HEIGHT))
            y+=moveY;
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }


}
