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


/******************************************************************
 * class: drawingPane
 * impliments: actionlistener, mousewheellistener, mouseinputlistener
 * mouselistener
 * @author Nick and Kendra
 * 
 * This class handles all the drawing and storing of shapes that have been
 * drawn. It class classes that implement shapes to be drawn
 * 
 ************************************************************************/
public class DrawingPane extends JPanel implements  ActionListener, MouseWheelListener,
        MouseInputListener,  MouseListener
{
    //private data
    private int currX = 0, currY = 0, newX = 0, //variables for mouse click location data
            newY = 0, currX2 = 0 , currY2 = 0;
    private int indexShortest = 0;              //used to find the index of the closest shape to a click
    private boolean leftButtonPress = false;    //will be true when left mouse button is pressed
    private boolean rightButtonPress = false;   //will be true when right mouse button is pressed
    private boolean fill;                       //determines whether or not a shape will be filled
    private int shapeType = 1;                  //determines if shape is a line, ellipse, rectangle, filled ellipse, or filled rectangle
    private boolean isOutline = true; 
    
    //protected data
    protected Color outlineColor , fillColor;   //color of shape outline and color of shape fill

    //public data
    public ArrayList<Shape> shapeList = new ArrayList<Shape>();  //shape list
    
    /****************************************
     * function: DrawingPane
     * 
     * this sets up the basic drawing surface
     * to be filled with shapes.
     **************************************/
    public DrawingPane()
    {
        addMouseListener( this );
        this.setBackground(Color.white);
        repaint();
    }
    
    
    /***********************************
     * functionL getPreferredSize
     * 
     * start with 800x600 canvas
     **********************************/
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension( 800, 600 );
    }
    
    
    /************************************
     * paintComponenet
     * @param g 
     * 
     * overrides paint component to call 
     * custom shape drawing methods.
     * 
     *********************************/
    @Override
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );          // clear drawing canvas

        //set if statement so shapes are not being created for every mouse click
        if(currX != currX2 || currY != currY2)
        {
            if( shapeType == 1)             //create line
                shapeList.add(new Line(currX, currY, currX2, currY2, outlineColor ));
            else if( shapeType == 2 )       //create rectangle
                shapeList.add(new Rectangle(currX, currY, currX2, currY2,
                        outlineColor ));
            else if( shapeType == 3 )       //create filled rectangle
                shapeList.add(new FilledRectangle(currX, currY, currX2, currY2,
                        fillColor, outlineColor ));
            else if( shapeType == 4 )       //create ellipse
                shapeList.add(new Ellipse(currX, currY, currX2, currY2, outlineColor ));
            else if( shapeType == 5)        //create filled ellipse
                shapeList.add(new FilledEllipse(currX, currY, currX2, currY2,
                        fillColor, outlineColor ));      
        }
        
        //draw all shapes in shape list
        for (Shape s : shapeList) 
        {
            s.draw(g);
        }
        
    }
    
    /************ unused function **********************/
    @Override  
    public void mouseWheelMoved(MouseWheelEvent mwe) 
    {

    }

    
    /***********************************************
     * function mouseClicked
     * 
     * @param me 
     * 
     * gets the current x and y position from the
     * mouse click
     **********************************************/
    @Override
    public void mouseClicked(MouseEvent me)
    {       
        this.newX = me.getX();
        this.newY = me.getY();
        
        System.out.println("click");
    }
    
    
    public void rePaint(Graphics g)
    {
        for (Shape s : shapeList)
        {
        if(rightButtonPress)
            continue;
        s.draw(g);
        }
    }

    /********************************************
     * function mousePressed
     * 
     * @param me 
     * 
     * left mouse button press will get position of 
     * click. right mouse button press will get 
     * position of click and find the nearest shape
     ********************************************/
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

    
    /****************************************************
     * function mouseReleased
     * 
     * @param me 
     * 
     * left mouse button release will draw a shape
     * right mouse button release will move the shape 
     * found in the right mouse button press
     ***************************************************/
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
            this.currX = me.getX();
            this.currY = me.getY();
            System.out.println( "Mouse right button release: (" + currX2 + "," + currY2 + ")" );   
            
            Shape shapeToMove = shapeList.get(indexShortest);    //move shape by getting its information,                 
            shapeToMove.move(currX, currY);                    //creating a copy at new location,           
            shapeList.add(shapeToMove);                          //adding altered shape to list       
            shapeList.remove(indexShortest);                     //and removing the old shape
            
            System.out.println("Removed " + indexShortest);      
            repaint();
            rightButtonPress = false;             
        }
    }

    
    /******** unused function ***************/
    @Override
    public void mouseEntered(MouseEvent me) 
    {
        
    }

    
    /********* unused function **************/
    @Override
    public void mouseExited(MouseEvent me) 
    {
        
    }

    
    /********* unused function **************/
    @Override
    public void mouseDragged(MouseEvent me) 
    {

    }

    /********* unused function **************/
    @Override
    public void mouseMoved(MouseEvent me) 
    {
      
    }
    
    
    /************************************
     * function: actionPerformed
     * @param ae 
     * 
     * override actionperformed to change state
     * of fill.
     ************************************/
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(fill == false)
            fill = true;
        else
            fill = false;        
    }
    
    
    /*********************************************
     * functions: cColor(1-8) 
     * 
     * @param isOutline
     * 
     * sets the color of the outline or fill in 
     * question, (given by value of isOutline) to 
     * the specified color. Color functions listed 
     * here in this order:
     * Red
     * Green
     * Blue
     * Yellow
     * Magenta
     * Cyan
     * Black
     * White
     ********************************************/
    
    /************ RED *********************/
    public void cColor1(boolean isOutline){
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
    
    /************* GREEN ******************/
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
    
    /************* BLUE ********************/
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
    
    /************** YELLOW *****************/
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
    
    /************* MAGENTA ******************/
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
    
    /************** CYAN *********************/
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
    
    /*************** BLACK ********************/
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
    
    /************** WHITE **********************/
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
    
    
    /****************************************
     * Functions: shape identifers
     * 
     * sets the value of "shape" variable to 
     * the user's desired shape, (from button 
     * click)
     ****************************************/
    public void sLine()
    {
        shapeType = 1;
    }
    public void sRectangle()
    {
        shapeType = 2;
    }
    public void sRectangleF()
    {
        shapeType = 3;
    }
    public void sEllipse()
    {
        shapeType = 4;
    }
    public void sEllipseF()
    {
        shapeType = 5;
    }
    
    
    /******************************
     * function: rFill
     * 
     * @return fillColor
     * 
     * returns user's chosen fill color
     ******************************/
    public Color rFill()
    {
        return fillColor;
    }
    
    
    /*******************************
     * function: rOutline
     * 
     * @return outlineColor
     * 
     * returns user's chosen outline color
     *******************************/
    public Color rOutline()
    {
        return outlineColor;
    }
    
    
    /*********************************
     * function whichShape
     * 
     * whichShape takes the  point of a 
     * right mouse release and increments 
     * through all shapes in the shaleList
     * array to find the one closest to 
     * that point. it changes "indexShortest"
     * to the index of the closest shape
     ********************************/
    public void whichShape()
    {
        double shortestDistance = 900000;
        double distance;      
        int xDiff, yDiff;    
              
        System.out.println("Point (" + currX + "," + currY + ")");
        for (Shape s : shapeList) 
        {
            System.out.println(s.toString());
            //use pythagorean theorem to determine distance
            //between clicked x, y and the x, y of shape s
            
            System.out.println("Center (" + s.centerx + "," + s.centery + ")");
            xDiff = (currX- s.centerx)*(currX - s.centerx);
            yDiff = (currY - s.centery)*(currY - s.centery);           
            distance = Math.sqrt(xDiff + yDiff);
            
            System.out.println("DISTANCE: " + distance);
            if(distance  < shortestDistance)
            {
                shortestDistance = distance;
                this.indexShortest = shapeList.indexOf(s);
            }
                                          
        }               
        System.out.println("index shortest dist: " + indexShortest);
    }
       
}
