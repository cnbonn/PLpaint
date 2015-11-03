/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paint;

/**
 *
 * @author nick
 */

import javax.swing.*;
import java.awt.event.*;

        
public class Paint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new window();
        
        frame.setSize(400,400);
        frame.setLocationRelativeTo( null ); //open in center of screen
        
        //exit confirmation
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                    null, "Are You Sure to would like to quit?", 
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    System.exit(0);
                }
            }   
        };
        frame.addWindowListener(exitListener);
        frame.setFocusable(true); //set frame to focous
        frame.pack();
        frame.setVisible(true); //set visible
    }
    
}
