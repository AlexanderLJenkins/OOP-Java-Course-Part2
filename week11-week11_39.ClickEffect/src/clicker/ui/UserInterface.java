package clicker.ui;

import clicker.applicationlogic.PersonalCalculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private PersonalCalculator personalCalculator;

    public UserInterface(PersonalCalculator personalCalculator) {
        this.personalCalculator = personalCalculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new BorderLayout());
        JLabel counterDisplay = new JLabel("0");
        JButton clickButton = new JButton("Click!");
        ClickListener listener = new ClickListener(personalCalculator, counterDisplay);
        clickButton.addActionListener(listener);
        
        container.add(counterDisplay, BorderLayout.NORTH);
        container.add(clickButton, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
