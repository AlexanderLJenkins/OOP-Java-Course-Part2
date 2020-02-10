package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A class which shall copy the contents of one JTextArea to another upon action.
 * @author Alex Jenkins
 */
public class ActionEventListener implements ActionListener {

    private JTextField origin;
    private JLabel destination;

    public ActionEventListener(JTextField origin, JLabel destination) {
        this.origin = origin;
        this.destination = destination;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.destination.setText(this.origin.getText());
        this.origin.setText("");
    }
    
}
