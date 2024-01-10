package nl.vasilverdouw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelloWorldScreen extends JFrame {
    public HelloWorldScreen() {
        setTitle("Hello World!");
        setSize(1280, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        add(panel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        add(panel2);

        JLabel label = new JLabel("Hello World!");
        panel.add(label);
    }
}
