package nl.vasilverdouw;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HelloWorldScreen helloWorldScreen = new HelloWorldScreen();
            helloWorldScreen.setVisible(true);
        });
    }
}