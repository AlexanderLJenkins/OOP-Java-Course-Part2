
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * A class to implement adding to the calculator GUI.
 * @author Alex Jenkins
 */
public class CalculatorMinus implements ActionListener {
    
    private JTextField display;
    private JTextField value;
    private JButton resetButton;

    public CalculatorMinus(JTextField display, JTextField value, JButton resetButton) {
        this.display = display;
        this.value = value;
        this.resetButton = resetButton;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            int currentValue = Integer.parseInt(this.display.getText());
            int inputValue = 0;
            if (!this.value.getText().isEmpty()) {
                inputValue = Integer.parseInt(this.value.getText());
            }
            this.display.setText("" + (currentValue-inputValue));
            this.value.setText("");
            if (currentValue-inputValue == 0.0) {
                resetButton.setEnabled(false);
            } else {
                resetButton.setEnabled(true);
            }
        } catch (NumberFormatException e) {
            this.value.setText("");
        }
    }
}
