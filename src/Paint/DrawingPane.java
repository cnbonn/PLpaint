package Paint;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nick
 */
public class DrawingPane extends JPanel implements  ActionListener, MouseWheelListener,
        MouseInputListener,  MouseListener
{
    //private data
    private int currX = 0, currY = 0, newX = 0, newY = 0,
            currX2 = 0 , currY2 = 0;
    
    //for moving one shape, which will be stored in 'moving'
    private int indexShortest;
    public ArrayList<Shape> moving = new ArrayList<Shape>();
    
    private boolean leftButtonPress = false;
    private boolean rightButtonPress = false;
    protected Color outlineColor , fillColor;
    private boolean fill;
    private int shapeType = 1;
    private boolean isOutline = true;
    
    public ArrayList<Shape> shapeList = new ArrayList<Shape>();
    
    
    public DrawingPane()
    {
        shapeList = new ArrayList();
        super.setFocusable(true); //set frame to focous
        addMouseListener( this );
        this.setBackground(Color.white);
        repaint();
    }
    
    
    // start with 800x600 canvas
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension( 800, 600 );
    }
    
    @Override
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );	// clear drawing canvas

        if( shapeType == 1) //create line
            shapeList.add(new Line(currX, currY, currX2, currY2, outlineColor ));
        else if( shapeType == 2 ) //create rectangle
            shapeList.add(new Rectangle(currX, currY, currX2, currY2,
                    outlineColor ));
        else if( shapeType == 3 )//create filled rectangle
            shapeList.add(new FilledRectangle(currX, currY, currX2, currY2,
                    fillColor, outlineColor ));
        else if( shapeType == 4 ) //create ellipse
            shapeList.add(new Ellipse(currX, currY, currX2, currY2, outlineColor ));
        else if( shapeType == 5) //create filled ellipse
            shapeList.add(new FilledEllipse(currX, currY, currX2, currY2,
                    fillColor, outlineColor ));
        
        //draw all shapes in shape list
        for (Shape s : shapeList) {
            s.draw(g);
        }
        
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {

    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        
        this.newX = me.getX();
        this.newY = me.getY();
        
        System.out.println("click");
 
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if ( SwingUtilities.isLeftMouseButton( me ) )
        {
            this.currX = me.getX();
            this.currY = me.getY();
            System.out.println( "Mouse left button click: (" + currX + "," + currY + ")" );
            leftButtonPress = true;
        }
        
        else if( SwingUtilities.isRightMouseButton( me ))
        {
            this.currX = me.getX();
            this.currY = me.getY();
            System.out.println( "Mouse right button click: (" + currX + "," + currY + ")" );
            rightButtonPress = true;
            whichShape();
            System.out.println( "Selected shape at index " + indexShortest);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(leftButtonPress)
        {
            this.currX2 = me.getX();
            this.currY2 = me.getY();
            System.out.println( "Mouse left button release: (" + currX2 + "," + currY2 + ")" );
            leftButtonPress = false;          
            repaint();
        }
        
        else if(rightButtonPress)
        {
            this.currX2 = me.getX();
            this.currY2 = me.getY();
            System.out.println( "Mouse right button release: (" + currX2 + "," + currY2 + ")" );                                 
            
            rightButtonPress = false;
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
        //System.out.println("drag");
        
        this.newX = me.getX();
        this.newY = me.getY();

        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        this.newX = me.getX();
        this.newY = me.getY();
        
        //System.out.println("position " + newX + " " + newY);
        
        this.repaint();
        
    }
   
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(fill == false)
            fill = true;
        else
            fill = false;
        
    }
    
    //color functions
    public void cColor1(boolean color){
        isOutline = color;
        if( isOutline == false)
        {
            System.out.println("Fill Color: Red");
            this.fillColor = new Color( 255, 0 , 0);
        }
        else
        {
            System.out.println("Outline Color: Red");
            this.outlineColor = new Color( 255, 0 , 0);   
        }
    }
    public void cColor2(boolean isOutline){
        if( isOutline == false)
        {
            System.out.println("Fill Color: Green");
            this.fillColor = new Color( 0, 255 , 0);
        }
        else
        {
            System.out.println("Outline Color: Green");
            this.outlineColor = new Color( 0, 255 , 0);
        }
    }
    public void cColor3(boolean isOutline){
        if( isOutline == false)
        {
            System.out.println("Fill Color: Blue");
            this.fillColor = new Color( 0, 0 , 255);
        }
        else 
        {
            System.out.println("Outline Color: Blue");
            this.outlineColor = new Color( 0, 0 , 255);
        }
    }
    public void cColor4(boolean isOutline){
        if( isOutline == false)
        {
            System.out.println("Fill Color: Yellow");
            this.fillColor = new Color( 255, 255 , 0);
        }
        else 
        {
            System.out.println("Outline Color: Yellow");
            this.outlineColor = new Color( 255, 255 , 0);
        }
    }
    public void cColor5(boolean isOutline){
        if( isOutline == false)
        {
            System.out.println("Fill Color: Magenta");
            this.fillColor = new Color( 255, 0 , 255);
        }
        else 
        {
            System.out.println("Outline Color: Magenta");
            this.outlineColor = new Color( 255, 0 , 255);
        }
    }
    public void cColor6(boolean isOutline){
        if( isOutline == false)
        {
            System.out.println("Fill Color: Cyan");
            this.fillColor = new Color( 0, 255, 255);
        }
        else 
        {
            System.out.println("Outline Color: Cyan");
            this.outlineColor = new Color( 0, 255 , 255);
        }
    }
    public void cColor7(boolean isOutline){
        if( isOutline == false)
        {
            System.out.println("Fill Color: Black");
            this.fillColor = new Color( 0, 0 , 0);
        }
        else 
        {
            System.out.println("Outline Color: Black");
            this.outlineColor = new Color( 0, 0 , 0);
        }
    }
    public void cColor8(boolean isOutline){
        if( isOutline == false)
        {
            System.out.println("Fill Color: White");
            this.fillColor = new Color( 255, 255 , 255);
        }
        else 
        {
            System.out.println("Outline Color: White");
            this.outlineColor = new Color( 255, 255 , 255);
        }
    }
    //shape identifyers
    public void sLine(){
        shapeType = 1;
    }
    public void sRectangle(){
        shapeType = 2;
    }
    public void sRectangleF(){
        shapeType = 3;
    }
    public void sEllipse(){
        shapeType = 4;
    }
    public void sEllipseF(){
        shapeType = 5;
    }
    
    public Color rFill()
    {
        return fillColor;
    }
    public Color rOutline()
    {
        return outlineColor;
    }
    
    
    public void whichShape()
    {
        double shortestDistance = 90000;
        double distance;      
        int xDiff, yDiff;    
              
        for (Shape s : shapeList) 
        {
            System.out.println("shape: " + s.toString() );
            //use pythagorean theorem to determine distance
            //between clicked x, y and the x, y of shape s
            
            System.out.println("X: " + s.centerx);
            System.out.println("Y: " + s.centery);
            xDiff = (currX- s.centerx)* (currX - s.centerx);
            yDiff = (currY - s.centery)*(currY - s.centery);           
            distance = Math.sqrt(xDiff + yDiff);
            
            System.out.println("DISTANCE: " + distance);
            if(distance  < shortestDistance)
            {
                shortestDistance = distance;
                this.indexShortest = shapeList.indexOf(s);
            }
            System.out.println(" index count" + shapeList.indexOf(s));
                                          
        }               
        System.out.println("index: " + indexShortest);
    }
    
    
}
