/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Apo
 */
public class TextCopier implements ActionListener{
    private JTextField origin;
    private JLabel destination;
    
    public TextCopier(JTextField origin, JLabel destination) {
        this.destination = destination;
        this.origin = origin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        destination.setText(origin.getText());
        origin.setText("");
    }
    
    
}
