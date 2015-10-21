/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2;


import javax.swing.*;
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
    window()
    {
        super("paint");
        
                
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
                System.exit( 0 );
            }
        } );
        menu.add( mItem );
        
        //Help menu
        menu = new JMenu ("Help");
        menuBar.add( menu );
        
        mItem = new JMenuItem ( "about" );
        mItem.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae)
            {
                JFrame help = new helpMenu();
                help.setVisible(true);
                help.setSize(300,300);
                help.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        });
        menu.add( mItem );
        
        
        //add key listener
        addKeyListener( this );
    }
    
    // key press handler
    @Override
    public void keyPressed( KeyEvent event )
    {
        // print key presses

        // exit if Escape key is pressed
        if ( event.getKeyCode() == 27 || event.getKeyCode() == 81){
            System.exit( 0 );
        }
    }

    // required by KeyListener interface
    @Override
    public void keyReleased( KeyEvent event ) { }
    @Override
    public void keyTyped( KeyEvent event ) { }

    

}
