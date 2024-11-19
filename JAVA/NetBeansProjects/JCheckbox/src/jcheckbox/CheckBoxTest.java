/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcheckbox;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
/**
 *
 * @author Mauricio
 */
public class CheckBoxTest {
    public static void main(String[] args)
    {
        CheckBoxFrame checkBoxFrame;
        checkBoxFrame = new CheckBoxFrame();
        checkBoxFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        checkBoxFrame.setSize( 275, 100 ); // set frame size
        checkBoxFrame.setVisible( true ); // display frame 
        
    }
    
}
