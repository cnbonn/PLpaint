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
 * @author nick
 * 
 * This class handles all the drawing and storing of shapes that have been
 * drawn. It class classes that impliment shapes to be drawn
 * 
 ************************************************************************/
public class DrawingPane extends JPanel implements  ActionListener, MouseWheelListener,
        MouseInputListener,  MouseListener
{
    //private data
    private int currX = 0, currY = 0, newX = 0, newY = 0,
            currX2 = 0 , currY2 = 0;
    private boolean leftButtonPress = false;
    protected Color outlineColor , fillColor;
    private boolean fill;
    private int shapeType = 1;
    private boolean isOutline = true; 
    public ArrayList<Shape> shapeList = new ArrayList<Shape>();  //shape list
    
    /****************************************
     * function: DrawingPane
     * 
     * this sets up the basic drawing surface
     * to be filled with shapes.
     **************************************/
    public DrawingPane()
    {
        shapeList = new ArrayList();
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
    
    @Override  //unused
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
    /*********************************8
     * function: actionPerformed
     * @param ae 
     * 
     * override actionperformed to change state
     * of fill.
     ******************/
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(fill == false)
            fill = true;
        else
            fill = false;
        
    }
    
    /****************************************
     * functions: cColor(1-8) 
     * @param isOutline
     * 
     * for each function of cColor
     * sets the color of the outline or fill
     * based off of isOutline to the specified color
     * then prints a message to the screen.
     ***************************************/
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
    
    
    /****************************
     * Functions: shape identifers
     * 
     * sets the shape to the user specified
     * shape.
     * 
     */
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
    /**********************8
     * function: rFill
     * @return 
     * 
     * returns the color of fillColor
     ************/
    public Color rFill()
    {
        return fillColor;
    }
    /**********************8
     * function: rOutline
     * @return 
     * 
     * returns the color of outlineColor
     ************/
    public Color rOutline()
    {
        return outlineColor;
    }
    
    
}
