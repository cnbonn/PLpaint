/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2;


import java.awt.Container;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.border.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.BorderLayout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputListener;


/**
 *
 * @author nick
 */
public class window extends JFrame implements KeyListener, ActionListener
{ 
    //private data
    public Container contents;
    public Color outlineColor, fillColor;
    private JButton color1, color2, color3, color4, color5, color6, color7,
            color8, makeLine, makeRectangle, makeRectangleF, makeElipse,
            makeElipseF;

    window()
    {
        super("paint");
          
        //create drawing screen
        Container pane = getContentPane();
        DrawingPane canvis = new DrawingPane();

        
        //create shape buttions
        JPanel shapePanel = new JPanel();
        makeLine = new JButton("Make Line");
        makeRectangle = new JButton("Make square");
        makeRectangleF = new JButton("Make Filled Square");
        makeElipse = new JButton("Make Elipse");
        makeElipseF = new JButton("Make Filled Elipse");
 
        //add buttions
        shapePanel.add( makeLine );
        shapePanel.add( makeRectangle );
        shapePanel.add( makeRectangleF );
        shapePanel.add( makeElipse );
        shapePanel.add( makeElipseF );
        //acction listeners for shapes
        makeLine.addActionListener(this);
        makeRectangle.addActionListener(this);
        makeRectangleF.addActionListener(this);
        makeElipse.addActionListener(this);
        makeElipseF.addActionListener(this);
        
        //create color buttons 
        //color format color( float r, float g, float b )
        JPanel colorPanel = new JPanel();
        color1 = new JButton("color 1");
        color1.setBackground(new Color(255,0,0));
        
        
        color2 = new JButton("color 2");
        color2.setBackground(new Color(0,255,0));
        
        
        color3 = new JButton("color 3");
        color3.setBackground(new Color(0,0,255));
        
        
        color4 = new JButton("color 4");
        color4.setBackground(new Color(255,255,0));
        
        
        color5 = new JButton("color 5");
        color5.setBackground(new Color(255,0,255));
        
        
        color6 = new JButton("color 6");
        color6.setBackground(new Color(0,255,255));
        
        
        color7 = new JButton("color 7");
        color7.setBackground(new Color(0,0,0));
        ;
        
        color8 = new JButton("color 8");
        color8.setBackground(new Color(255,255,255));
      
        //add shapes
        colorPanel.add(color1);
        colorPanel.add(color2);
        colorPanel.add(color3);
        colorPanel.add(color4);
        colorPanel.add(color5);
        colorPanel.add(color6);
        colorPanel.add(color7);
        colorPanel.add(color8);
        //action listeners for colors
        color1.addActionListener(this);
        color2.addActionListener(this);
        color3.addActionListener(this);
        color4.addActionListener(this);
        color5.addActionListener(this);
        color6.addActionListener(this);
        color7.addActionListener(this);
        color8.addActionListener(this);
        
        pane.add(canvis); //add drawing surface
        
        //create menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar( menuBar );
        
        JMenu menu = new JMenu ("File");
        menuBar.add( menu );
        
        //quit item
        JMenuItem mItem = new JMenuItem ( "Quit" );
        mItem.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae )
            {
                //popup window with exit confermation
                int exit = JOptionPane.showConfirmDialog( null, "Are you sure "
                    + "you would like to quit?", "Exit Confermation" ,
                    JOptionPane.YES_NO_OPTION);
                if( exit == 0)
                {
                System.exit( 0 );
                }
            }
        } );
        menu.add( mItem );
        
        //tool menu
        menu = new JMenu ("Tools");
        menuBar.add( menu );
        
        //colors tools
        JCheckBoxMenuItem cItem = new JCheckBoxMenuItem ( "Colors" );
        menu.add( cItem );
        
        //shape tools
        cItem = new JCheckBoxMenuItem( "Shapes" );
        menu.add( cItem );
        
        //Help menu
        menu = new JMenu ("Help");
        menuBar.add( menu );
        
        mItem = new JMenuItem ( "Help" );
        mItem.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae)
            {
                JFrame help = new helpMenu();
                help.pack();
                help.setLocationRelativeTo( null );
                help.setSize(300,300);
                help.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                help.setVisible(true);
            }
        });
        menu.add( mItem );
        
        mItem = new JMenuItem ( "about");
        mItem.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae)
            {
                JFrame aboutMenu = new helpMenu();
                aboutMenu.pack();
                aboutMenu.setLocationRelativeTo( null );
                aboutMenu.setSize(300,300);
                aboutMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                aboutMenu.setVisible(true);
            }
        });
        
        
        menu.add( mItem );
        
        pane.add(shapePanel, BorderLayout.NORTH);
        //colorPanel.setLayout(4,2,2,4);
        pane.add(colorPanel, BorderLayout.SOUTH);
        
        //add key listener
        this.addKeyListener( canvis );
        
        this.addMouseWheelListener(canvis);
        this.addMouseMotionListener(canvis);
        this.addMouseListener(canvis);
        
        
        
       
    }
    
    // required by KeyListener interface
    // key press handler
    @Override
    public void actionPerformed( ActionEvent evt)
    {
        Object source = evt.getSource();
        //color objects
        if ( source == color1 ) System.out.println("Color: Red");
        else if ( source == color2 ) System.out.println("Color: Green");
        else if ( source == color3 ) System.out.println("Color: Blue");
        else if ( source == color4 ) System.out.println("Color: Yellow");
        else if ( source == color5 ) System.out.println("Color: Magenta");
        else if ( source == color6 ) System.out.println("Color: Cyan");
        else if ( source == color7 ) System.out.println("Color: Black") ;
        else if ( source == color8 ) System.out.println("Color: White");
        
        //shape objects
        if ( source == makeLine ) System.out.println("Shape: Line");
        else if ( source == makeRectangle ) System.out.println("Shape: Rectangle");
        else if ( source == makeRectangleF ) System.out.println("Shape: Filled Rectangle");
        else if ( source == makeElipse ) System.out.println("Shape: Elipse");
        else if ( source == makeElipseF ) System.out.println("Shape: Filled Elipse");
        
        
        
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
}

/*class DrawingPane extends JPanel implements  ActionListener, MouseWheelListener,
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
}*/



    