
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

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3,1));
        JTextField displayText = new JTextField("0");
        displayText.setEnabled(false);
        
        JTextField inputText = new JTextField("0");
        
        container.add(displayText);
        container.add(inputText);
        container.add(createPanel(displayText, inputText));
    }

    private JPanel createPanel(JTextField displayText, JTextField inputText) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton resetButton = new JButton("Z");
        resetButton.addActionListener(new CalculatorReset(displayText, inputText, resetButton));
        resetButton.setEnabled(false);
        
        JButton addButton = new JButton("+");
        addButton.addActionListener(new CalculatorPlus(displayText, inputText, resetButton));
        
        JButton minusButton = new JButton("-");
        minusButton.addActionListener(new CalculatorMinus(displayText, inputText, resetButton));

        panel.add(addButton);
        panel.add(minusButton);
        panel.add(resetButton);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
