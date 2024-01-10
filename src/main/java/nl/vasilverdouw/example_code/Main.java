package nl.vasilverdouw.example_code;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gui gui = new Gui();
            gui.setVisible(true);
        });
    }
}
