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
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.BorderLayout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputListener;


/**
 *
 * @author nick
 */
public class window extends JFrame implements KeyListener
{ 
    //private data
    public Container contents;

    window()
    {
        super("paint");
          
        //create drawing screen
        Container pane = getContentPane();
        DrawingPane canvis = new DrawingPane();

        
        //create shape buttions
        JPanel shapePanel = new JPanel();
        JButton makeLine = new JButton("Make Line");
        JButton makeRectangle = new JButton("Make square");
        JButton makeRectangleF = new JButton("Make Filled Square");
        JButton makeElipse = new JButton("Make Elipse");
        JButton makeElipseF = new JButton("Make Filled Elipse");
        shapePanel.add( makeLine );
        shapePanel.add( makeRectangle );
        shapePanel.add( makeRectangleF );
        shapePanel.add( makeElipse );
        shapePanel.add( makeElipseF );
        
        
        
        
        //create color buttons
        JPanel colorPanel = new JPanel();
        JButton color1 = new JButton("color 1");
        JButton color2 = new JButton("color 2");
        JButton color3 = new JButton("color 3");
        JButton color4 = new JButton("color 4");
        JButton color5 = new JButton("color 5");
        JButton color6 = new JButton("color 6");
        JButton color7 = new JButton("color 7");
        JButton color8 = new JButton("color 8");
        colorPanel.add(color1);
        colorPanel.add(color2);
        colorPanel.add(color3);
        colorPanel.add(color4);
        colorPanel.add(color5);
        colorPanel.add(color6);
        colorPanel.add(color7);
        colorPanel.add(color8);
        
        
        
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

class DrawingPane extends JPanel implements  ActionListener, MouseWheelListener,
        MouseInputListener, KeyListener
{
    //private data
    private int currX, currY, newX, newY;
     
    public DrawingPane()
    {
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
        this.currX = me.getX();
        this.currY = me.getY();
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
        System.out.println("drag");
        
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



    