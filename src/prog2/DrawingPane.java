package prog2;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
import javax.swing.JList;
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
        MouseInputListener, KeyListener, MouseListener
{
    //private data
    private int currX = 0, currY = 0, newX = 0, newY = 0,
            currX2 = 0 , currY2 = 0;
    private boolean leftButtonPress = false;
    private Color outlineColor , fillColor;
    private boolean fill;
    private int shapeType = 1;
    
    public ArrayList<Shape> shapeList = new ArrayList<Shape>();
    
    
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
    
    @Override
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );	// clear drawing canvas

        
        if( shapeType == 1) //create line
        {
            shapeList.add(new Line(currX, currY, currX2, currY2, fillColor ));
        }
        else if( shapeType == 2 ) //create rectangle
        {
            shapeList.add(new Rectangle(currX, currY, currX2, currY2, fillColor ));
        }
        else if( shapeType == 3 )//create filled rectangle
        {
            
        }
        else if( shapeType == 4 ) //create ellipse
        {
            shapeList.add(new Ellipse(currX, currY, currX2, currY2, fillColor ));
        }
        else if( shapeType == 5) //create filled ellipse
        {
            
        }
        
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
    
    @Override
    public void keyPressed( KeyEvent event )
    {
        // print key presses
        System.out.println( "You pressed key: " + ( char )event.getKeyCode() + " (key code " + event.getKeyCode() + ")" );
        
        // exit if Escape key is pressed
        if ( event.getKeyCode() == 27 || event.getKeyCode() == 81){
            
            //check for exit
            int exit = JOptionPane.showConfirmDialog( null, "Are you sure "
                    + "you would like to quit?", "Exit Confirmation" ,
                    JOptionPane.YES_NO_OPTION);
            if( exit == 0)
            {
               System.exit( 0 );
            }
        }
    }
    @Override
    public void keyReleased( KeyEvent event ) { }
    @Override
    public void keyTyped( KeyEvent event ) { }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(fill == false)
            fill = true;
        else
            fill = false;
        
    }
    
    //color functions
    public void cColor1(){
        fillColor = new Color( 255, 0 , 0);
    }
    public void cColor2(){
        fillColor = new Color( 0, 255 , 0);
    }
    public void cColor3(){
        fillColor = new Color( 0, 0 , 255);
    }
    public void cColor4(){
        fillColor = new Color( 255, 255 , 0);
    }
    public void cColor5(){
        fillColor = new Color( 255, 0 , 255);
    }
    public void cColor6(){
        fillColor = new Color( 0, 255, 255);
    }
    public void cColor7(){
        fillColor = new Color( 0, 0 , 0);
    }
    public void cColor8(){
        fillColor = new Color( 255, 255 , 255);
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
    
    
}
