package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame("Survery");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        // Create the components for a survery UI
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(new JLabel("Are you?"));
        container.add(new JCheckBox("Yes!"));
        container.add(new JCheckBox("No!"));
        
        container.add(new JLabel("Why?"));
        JRadioButton option1 = new JRadioButton("No reason.");
        JRadioButton option2 = new JRadioButton("Because it is fun!");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        container.add(option1);
        container.add(option2);
        
        container.add(new JButton("Done!"));
    }


    public JFrame getFrame() {
        return frame;
    }
}
