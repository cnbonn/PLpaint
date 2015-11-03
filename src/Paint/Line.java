/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author 1905065
 */
public class Line extends Shape
{
    protected int x1, y1 ,x2 , y2;
 
    public Line()
    {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }
    public Line( int x1, int y1, int x2, int y2, Color fillColor)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.name = "Line";
        this.fillColor = fillColor;
    }
    protected void draw( Graphics g)
    {
        super.paintComponent(g);
        g.setColor( fillColor );
        g.drawLine(x1,y1,x2,y2);
    }
    
    public String toString()
    {
        return "shape: "+ name + " ("+x1+","+y1+") & (" +x2+","+y2+")" ;
    }
    
    public void move( int newx, int newy)
    {
    
   
        //save shape temporarily
        //delete line
     
                        
    }
    
    
    protected void findCenter()
    {
        this.centerx = (x2 + x1)/2;
        this.centery = (y2 + y1)/2;
    }
}
