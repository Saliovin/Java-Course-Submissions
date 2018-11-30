package calculator.ui;


import calculator.logic.Calculator;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calculator;
    
    public GraphicCalculator() {
        calculator = new Calculator();
    }
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 200));
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        JTextField result = new JTextField("0");
        result.setEnabled(false);
        JTextField input = new JTextField();
        MenuPanel menu = new MenuPanel(calculator, result, input);
        
        container.add(result);
        container.add(input);
        container.add(menu);
    }

    public JFrame getFrame() {
        return frame;
    }
}
