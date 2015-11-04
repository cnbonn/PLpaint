/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint;


import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
/**
 *
 * @author Nick and Kendra
 */
public abstract class Shape extends JPanel
{
    protected int centerx, centery;

    protected int currx1, curry1, currx2, curry2;
    protected int newx, newy;
    protected String name;
    protected Color outlineColor, fillColor;
    //constructor
    
    public Shape( )
    {
        currx1 = 0;
        curry1 = 0;
        this.name = name;
    }
    
    public Shape( int x, int y)
    {
        currx1 = x;
        curry2 = y;
    }
    
    protected void draw(Graphics g)
    {
        super.paintComponent(g);
    }
    
    abstract public void move(int newx, int newy);
            
    public String toString()
    {
        return" Shape: " + name;               
    }
    
    abstract protected void findCenter();
 
}
