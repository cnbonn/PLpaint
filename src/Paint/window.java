/*
 * RUN IN JAVA SWING NETBEANS
 */
package Paint;


import java.awt.Container;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.Dialog;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.KeyboardFocusManager;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;




/****************************************************
 * class: window
 * Implements: actionlistener
 * @author Nick
 * 
 * this class sets up the main gui and creates button
 * connections to actions. 
 *****************************************************/
public class window extends JFrame implements ActionListener
{ 
    //private data
    public Container contents;
    public Color outlineColor, fillColor;
    private JButton  outline, fill ,color1, color2, color3, color4, color5, 
            color6,color7, color8, makeLine, makeRectangle, makeRectangleF, 
            makeElipse, makeElipseF;
    private JToggleButton toggle;
    DrawingPane canvis;
    boolean isOutline = true;

    window()
    {
        super("Paint");
        
        //this.setFocusable(true);
        //create drawing screen
        Container pane = getContentPane();
        canvis = new DrawingPane();

        
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
        //toggle button
        outline = new JButton( " Outline ");
        
        fill = new JButton( " Fill ");
                
        color1 = new JButton("RED");
        color1.setBackground(new Color(255,0,0));
        
        color2 = new JButton("GREEN");
        color2.setBackground(new Color(0,255,0));
         
        color3 = new JButton("BLUE");
        color3.setBackground(new Color(0,0,255));
         
        color4 = new JButton("YELLOW");
        color4.setBackground(new Color(255,255,0));
        
        color5 = new JButton("MAGENTA");
        color5.setBackground(new Color(255,0,255));
         
        color6 = new JButton("CYAN");
        color6.setBackground(new Color(0,255,255));
        
        color7 = new JButton("BLACK");
        color7.setBackground(new Color(0,0,0));
        
        color8 = new JButton("WHITE");
        color8.setBackground(new Color(255,255,255));
      
        //add shapes
        colorPanel.add(outline);
        colorPanel.add(fill);
        colorPanel.add(color1);
        colorPanel.add(color2);
        colorPanel.add(color3);
        colorPanel.add(color4);
        colorPanel.add(color5);
        colorPanel.add(color6);
        colorPanel.add(color7);
        colorPanel.add(color8);
        
        //action listeners for colors
        outline.addActionListener(this);
        fill.addActionListener(this);
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
        
        //Help menu
        menu = new JMenu ("Help");
        menuBar.add( menu );
        
        mItem = new JMenuItem ( "Help" );
        mItem.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae)
            {
                JOptionPane.showMessageDialog(null , "Welcome to the Help Menu\n"
                        + "To Draw click on the screen and drag to draw\n"
                        + "To select a color click on the buttion you want\n\t"
                        + " to change the color of ( fill or outline)\n"
                        + "To change you shape click on the shape you\n"
                        + "\t want to draw\n"
                        + "\n\n"
                        + "HOTKEYS\n"
                        + "Q or Esc : quit the program\n"
                        + "C : clear the screen\n"
                        + "D: delete the last object"
                        
                );
                
            }
        });
        menu.add( mItem );
        
        mItem = new JMenuItem ( "about");
        mItem.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae)
            {
                JOptionPane.showMessageDialog(null , "Paint v.0.0.1\n"
                        + "Created by Charles Bonn\n"
                        + "\tand\n"
                        + "Kendra Deziel\n"
                        + "Programming langugages 2015"
                        
                );
            }
        });
        
        menu.add( mItem );
        //add tool panels
        pane.add(shapePanel, BorderLayout.NORTH);
        pane.add(colorPanel, BorderLayout.SOUTH);
        
        //mouse misteners
        this.addMouseWheelListener(canvis);
        this.addMouseMotionListener(canvis);
        this.addMouseListener(canvis);
        
        //add key listener
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
  .addKeyEventDispatcher(new KeyEventDispatcher() {
      @Override
      public boolean dispatchKeyEvent(KeyEvent e) {
        System.out.println("Got key event!" + e);
        if( e.getKeyCode() == 27 || e.getKeyCode() == 81 )
        {
            System.out.println(" quit ");
            int exit = JOptionPane.showConfirmDialog( null, "Are you sure "
                    + "you would like to quit?", "Exit Confirmation" ,
                    JOptionPane.YES_NO_OPTION);
            if( exit == 0)
            {
               System.exit( 0 );
            }
        }
        else if( e.getKeyCode() == 68)
          {
            canvis.delete();
            System.out.println("Delete");
          }
        else if(e.getKeyCode() == 67)
        {
            canvis.clearScreen();
            System.out.println("clear screen");
            
            
          }
        canvis.repaint();
        canvis.revalidate();;
        return false;
      }
    });
        
       pack();
    }
    
    
    /*******************************************
     * function: action performed
     * @param evt 
     * @override
     * 
     * handles button clicks and directs them to
     * change drawing variables.
     *******************************************/
    @Override
    public void actionPerformed( ActionEvent evt)
    {
        Object source = evt.getSource();
        //if fill shape is selected
        if( source == fill)
            isOutline = false;   
        else if ( source == outline)
            isOutline = true;

        //color objects
        if ( source == color1 )
        {
            canvis.cColor1(isOutline);
            updateButton(isOutline);
        }
        else if ( source == color2 )
        {
            canvis.cColor2(isOutline);
            updateButton(isOutline);
        }
        else if ( source == color3 )
        {
            canvis.cColor3(isOutline);
            updateButton(isOutline);
        }
        else if ( source == color4 )
        {
            canvis.cColor4(isOutline);
            updateButton(isOutline);
        }
        else if ( source == color5 )
        {
            canvis.cColor5(isOutline);
            updateButton(isOutline);
        }
        else if ( source == color6 )
        {
            canvis.cColor6(isOutline);
            updateButton(isOutline);
        }
        else if ( source == color7 )
        {
            canvis.cColor7(isOutline);
            updateButton(isOutline);
        }
        else if ( source == color8 )
        {
            canvis.cColor8(isOutline);
            updateButton(isOutline);
        }
       
        //shape objects
        if ( source == makeLine )
        { 
            canvis.sLine();
            System.out.println("Shape: Line");
        }
        else if ( source == makeRectangle )
        {
            canvis.sRectangle();
            System.out.println("Shape: Rectangle");
        }
        else if ( source == makeRectangleF )
        {
            canvis.sRectangleF();
            System.out.println("Shape: Filled Rectangle");
        }
        else if ( source == makeElipse )
        {
            canvis.sEllipse();
            System.out.println("Shape: Elipse");
        }
        else if ( source == makeElipseF )
        {
            canvis.sEllipseF();
            System.out.println("Shape: Filled Elipse");
        }  
    }
    
    /**********************************************
     * Function: updateButton
     * @param isOutline
     * 
     * based on the input of isOutline, will update
     * the button color of outline or fill
     *************************************************/
    public void updateButton(boolean isOutline)
    {
        if( isOutline == true)
            updateOutline();
        else
           updateFill();
    }
    
    /****************************************
     * Function updateFill
     * 
     * this will grab the color of fill and 
     * set the fill button to match this color
     *****************************************/
    public void updateFill()
    {
        //update fill
        this.fillColor = canvis.rFill();
        this.fill.setBackground(this.fillColor);
        System.out.println("Set to fill " + fillColor);
        
    }
    /*************************************
     * function updateOutline
     * 
     * this will grab the color of outline
     * and set the outline button to match
     * this color
     *************************************/
    public void updateOutline()
    {
        //update outline
        this.outlineColor = canvis.rOutline();
        this.outline.setBackground(this.outlineColor);
        this.outline.setFocusable(false);
        System.out.println("Set to outline " + outlineColor);
    }
}
