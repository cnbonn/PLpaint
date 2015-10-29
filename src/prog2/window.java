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
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author nick
 */
public class window extends JFrame implements KeyListener
{
    
    //private data
    private Container contents;
    private JButton lineButton, rectangleButton, elipseButton, fRectangleButton,
            fElipseButton;
    private ButtonGroup shapeGroup;
    private JToolBar shapeBar;
    
    window()
    {
        super("paint");
        
        contents = getContentPane();
        contents.setLayout( new BoxLayout( contents, BoxLayout.Y_AXIS));
        
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
        

        makeShapeButtons();
        //add key listener
        pack();
        addKeyListener( this );
    }
    
    
    

    private void makeShapeButtons()
    {
        lineButton = new JButton("Line");
        rectangleButton = new JButton("Rect");
        fRectangleButton = new JButton("FRect");
        elipseButton = new JButton("Elipse");
        fElipseButton = new JButton("FElipse");
        
        
        shapeGroup = new ButtonGroup();
        shapeGroup.add(lineButton);
        shapeGroup.add(rectangleButton);
        shapeGroup.add(fRectangleButton);
        shapeGroup.add(elipseButton);
        shapeGroup.add(fElipseButton);
        
        shapeBar = new JToolBar("Shapes");
        shapeBar.add(lineButton);
        shapeBar.add(rectangleButton);
        shapeBar.add(fRectangleButton);
        shapeBar.add(elipseButton);
        shapeBar.add(fElipseButton);
        
        contents.add(shapeBar);
        
    }
    
    private void makeColorButtons()
    {
        
    }
    
    
    // required by KeyListener interface
    // key press handler
    @Override
    public void keyPressed( KeyEvent event )
    {
        // print key presses
        
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
