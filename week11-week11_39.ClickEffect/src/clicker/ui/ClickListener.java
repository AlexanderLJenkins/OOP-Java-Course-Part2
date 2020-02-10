package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * An action listener for clicks.
 * Upon clicking the calculator value is increased, and displayed in JLabel.
 * @author Alex Jenkins
 */
public class ClickListener implements ActionListener {

    private Calculator clickCounter;
    private JLabel counterValue;

    public ClickListener(Calculator clickCounter, JLabel counterValue) {
        this.clickCounter = clickCounter;
        this.counterValue = counterValue;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.clickCounter.increase();
        this.counterValue.setText("" + this.clickCounter.giveValue());
    }
}
