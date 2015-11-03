/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint;

import java.awt.Color;
import java.awt.Graphics;
import Paint.Shape;

/**
 *
 * @author 1905065
 */
public class Rectangle extends Shape
{
    protected int x1, y1 ,width , height;
 
    public Rectangle()
    {
        x1 = 0;
        y1 = 0;
        width = 0;
        height = 0;
    }
    public Rectangle( int x1, int y1, int x2, int y2, Color outlineColor)
    {
        if( x1 < x2 && y1 < y2)
        {
            this.x1 = x1;
            this.y1 = y1;
            this.width = x2-x1;
            this.height = y2-y1;
        }
        else if (x1 > x2 && y1 > y2 )
        {
            this.x1 = x2;
            this.y1 = y2;
            this.width = x1-x2;
            this.height = y1-y2;
        }
        this.outlineColor = outlineColor;
    }
    protected void draw( Graphics g)
    {
        super.paintComponent(g);
        g.setColor( outlineColor );
        g.drawRect(x1,y1,width,height);
    }
    public void move()
    {
        
    }
}
