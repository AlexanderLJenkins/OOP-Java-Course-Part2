package clicker.ui;

import clicker.applicationlogic.PersonalCalculator;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        PersonalCalculator a = new PersonalCalculator();
        UserInterface ui = new UserInterface(a);
        SwingUtilities.invokeLater(ui);
    }
}
