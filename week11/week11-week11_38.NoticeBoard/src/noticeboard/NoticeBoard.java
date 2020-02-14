package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        
        JTextField top = new JTextField("I was copied here from the JTextField.");
        JLabel bottom = new JLabel("");
        JButton copyButton = new JButton("Copy!");
        
        ActionEventListener copyButtonAction = new ActionEventListener(top, bottom);
        copyButton.addActionListener(copyButtonAction);
        
        container.add(top);
        container.add(copyButton);
        container.add(bottom);
    }
}
