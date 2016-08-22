package com.company;

import java.awt.Graphics2D;

public class Ball {

     private Game app;

    private int x, y, moveX, moveY;

    private final int DIAMETER = 8;


    public Ball(Game app){
        this.app = app;

    }

    public void paint(final Graphics2D g2d){
        g2d.fillRect(x,y,DIAMETER,DIAMETER);
    }
    public void move(){

        if(x<=0)
            moveX=1;
        else if(x>=app.getWidth()-DIAMETER)
            moveX=-1;

        if (y<=0)
            moveY=1;
        else if(y>=app.getHeight()-DIAMETER)
            moveY=-1;

        x+=moveX;
        y+=moveY;
    }

}
