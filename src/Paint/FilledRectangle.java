package Paint;

import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nick
 */
public class FilledRectangle extends Rectangle{
    protected int x1, y1 ,width , height;
    protected Color fillColor, outlineColor;
    
    
    public FilledRectangle()
    {
        x1 = 0;
        y1 = 0;
        width = 0;
        height = 0;
    }
    public FilledRectangle( int x1, int y1, int x2, int y2,Color fillColor,
            Color outlineColor)
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
        this.name = "Rectangle";
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
        findCenter();
    }
    protected void draw( Graphics g)
    {
        super.paintComponent(g);
                       
        g.setColor( fillColor );
        g.fillRect(x1,y1,width,height);
    
        g.setColor( outlineColor );
        g.drawRect(x1,y1,width,height);
    }
       
    public String toString()
    {
        return "shape: "+ name + " ("+x1+","+y1+") & (" +width +","+height+")" ;
    }

    public void move(int newx, int newy)
    {
        //set new x and y values
        x1 = newx - width/2;
        y1 = newy + height/2;  
    }
    
    
    protected void findCenter()
    {
        this.centerx = x1 + width/2;
        this.centery = y1 - height/2;           
    }
}
