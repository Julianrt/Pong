package com.company;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

    private Game app;

    private int x, y, moveY;

    public int moveX;

    private final int DIAMETER = 8;


    public Ball(Game app){
        this.app = app;
        this.x = app.getWidth()/2;
        this.y = 0;
        this.moveX=1;
        this.moveY=-1;
    }

    public void paint(final Graphics2D g2d){
        g2d.fillRect(x,y,DIAMETER,DIAMETER);
    }
    public void move(){


        if(collisionPlayerOne()){
            x=app.playerONE.getX()+16;
            if(app.playerONE.moveY==1){
                moveX=2;
                moveY=1;
            }
            else if(app.playerONE.moveY==-1){
                moveX=2;
                moveY=-1;
            }
            else{
                moveX=1;
            }
        }
        else if(collisionPlayerTWO()){
            x=app.playerTWO.getX()-DIAMETER;
            if(app.playerTWO.moveY==1){
                moveX=-2;
                moveY=1;
            }
            else if(app.playerTWO.moveY==-1){
                moveX=-2;
                moveY=-1;
            }
            else{
                moveX=-1;
            }
        }
        else if(x<=0) {
            app.pointPlayerTwo();
            x = app.getWidth()/2;
            y=0;
            moveX=1;
            if(app.scorePlayerTwo>=5){
                app.win();
            }
        }
        else if(x>=app.getWidth()-DIAMETER) {
            app.pointPlayerOne();
            x = app.getWidth() / 2;
            y=0;
            moveX=-1;
            if(app.scorePlayerOne>=5){
                app.win();
            }
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
