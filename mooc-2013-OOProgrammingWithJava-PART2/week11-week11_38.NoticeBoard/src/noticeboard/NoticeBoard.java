package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        JTextField textBox = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel text = new JLabel("");
        TextCopier copier = new TextCopier(textBox, text);
        button.addActionListener(copier);
        
        container.add(textBox);
        container.add(button);
        container.add(text);
    }
}
