package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Survey");
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }


    public JFrame getFrame() {
        return frame;
    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        
        container.add(new JLabel("Are you?"));
        container.add(new JCheckBox("Yes!"));
        container.add(new JCheckBox("No!"));
        container.add(new JLabel("Why?"));
        
        JRadioButton button1 = new JRadioButton("No reason.");
        JRadioButton button2 = new JRadioButton("Because it is fun!");
        
        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        
        container.add(button1);
        container.add(button2);
        container.add(new JButton("Done!"));
    }
}
