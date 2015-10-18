/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 *
 * @author nick
 */
public class window extends JFrame
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
        menu.add( mItem );
    }
}
