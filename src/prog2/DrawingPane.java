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
     
    public DrawingPane()
    {
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
        g.setColor( Color.BLUE );
        g.drawLine( currX, currY, currX2, currY2 );
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
        
    }
}
