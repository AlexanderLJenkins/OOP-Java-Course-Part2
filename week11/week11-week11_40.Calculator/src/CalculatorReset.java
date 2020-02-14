
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * A class to implement adding to the calculator GUI.
 * @author Alex Jenkins
 */
public class CalculatorReset implements ActionListener {
    
    private JTextField display;
    private JTextField value;
    private JButton resetButton;

    public CalculatorReset(JTextField display, JTextField value, JButton resetButton) {
        this.display = display;
        this.value = value;
        this.resetButton = resetButton;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.display.setText("0");
        this.value.setText("");
        resetButton.setEnabled(false);
    }
}
