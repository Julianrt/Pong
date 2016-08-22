package com.company;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

     private Game app;

    private int x, y, moveX, moveY;

    private final int DIAMETER = 8;


    public Ball(Game app){
        this.app = app;
        this.x = 20;
        this.y = 20;
        this.moveX=1;
        this.moveY=-1;
    }

    public void paint(final Graphics2D g2d){
        g2d.fillRect(x,y,DIAMETER,DIAMETER);
    }
    public void move(){


        if(collisionPlayerOne()){
            x=66;
            moveX=1;
        }
        else if(collisionPlayerTWO()){
            x=520;
            moveX=-1;
        }
        else if(x<=0) {
            app.pointPlayerTwo();
            x = app.getWidth()/2;
        }
        else if(x>=app.getWidth()-DIAMETER) {
            app.pointPlayerOne();
            x = app.getWidth() / 2;
        }

        if (y<=0)
            moveY=1;
        else if(y>=app.getHeight()-DIAMETER)
            moveY=-1;

        x+=moveX;
        y+=moveY;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER,DIAMETER);
    }
    public boolean collisionPlayerOne(){
        return app.playerONE.getBounds().intersects(getBounds());
    }
    public boolean collisionPlayerTWO(){
        return app.playerTWO.getBounds().intersects(getBounds());
    }

}
