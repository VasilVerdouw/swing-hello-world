package nl.vasilverdouw.example_code;

import javax.swing.SwingUtilities;

/*
 * -----------------------
 * 
 * NOTICE
 * 
 * This code is NOT written by me, Vasil Verdouw.
 * It has been provided as an example of how to use Swing.
 * 
 * -----------------------
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Gui gui = new Gui();
            gui.setVisible(true);
        });
    }
}
