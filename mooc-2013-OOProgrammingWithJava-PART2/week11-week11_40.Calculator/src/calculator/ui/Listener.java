/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.ui;

import calculator.logic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Apo
 */
public class Listener implements ActionListener{
    private Calculator calculator;
    private JTextField result;
    private JTextField input;
    private JButton reset;
    
    public Listener(Calculator calculator, JTextField result, JTextField input,
            JButton reset) {
        this.calculator = calculator;
        this.input = input;
        this.result = result;
        this.reset = reset;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("+")) {
            try {
                calculator.add(Integer.parseInt(input.getText()));
            }
            catch(Exception exception) {
            }
            
            checkReset();
        }
        else if(e.getActionCommand().equals("-")){
            try {
                calculator.subtract(Integer.parseInt(input.getText()));
            }
            catch(Exception exception) {
            }
            
            checkReset();
        }
        else {
            calculator.reset();
            reset.setEnabled(false);
        }
        
        
        input.setText("");
        result.setText(calculator.getResult() + "");
    }
    
    private void checkReset() {
        if(calculator.getResult() == 0) {
                reset.setEnabled(false);
            }
            else {
                reset.setEnabled(true);
            }
    }
}
