package calculator.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import calculator.logic.Calculator;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Apo
 */
public class MenuPanel extends JPanel{
    private Calculator calculator;
    private JTextField result;
    private JTextField input;
    
    public MenuPanel(Calculator calculator, JTextField result, JTextField input) {
        super(new GridLayout(1, 3));
        this.calculator = calculator;
        this.input = input;
        this.result = result;
        createComponents();
    }
    
    public void createComponents() {
        JButton add = new JButton("+");
        JButton subtract = new JButton("-");
        JButton reset = new JButton("Z");
        reset.setEnabled(false);
        
        Listener listener = new Listener(calculator, result, input, reset);
        add.addActionListener(listener);
        subtract.addActionListener(listener);
        reset.addActionListener(listener);
        
        this.add(add);
        this.add(subtract);
        this.add(reset);
    }
}
