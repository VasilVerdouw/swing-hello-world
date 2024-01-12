package nl.vasilverdouw.example_code;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
public class Gui extends JFrame implements ActionListener {

    private JLabel scoreLabel;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private String score = "0-0";
    private RockPaperScissorsGame gameLogic;

    public Gui() {
        setTitle("Rock Paper Scissors Game");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        scoreLabel = new JLabel("Score: " + score);
        add(scoreLabel);

        rockButton = new JButton();
        rockButton.addActionListener(this);
        try {
            BufferedImage img = scaleImage("src/main/resources/rps/R.jpeg", 300, 300);
            rockButton.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        add(rockButton);

        paperButton = new JButton();
        paperButton.addActionListener(this);
        try {
            BufferedImage img = scaleImage("src/main/resources/rps/paper-sheets-1570078601-5102292.jpeg", 300, 300);
            paperButton.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        add(paperButton);

        scissorsButton = new JButton();
        scissorsButton.addActionListener(this);
        try {
            BufferedImage img = scaleImage("src/main/resources/rps/S.jpeg", 300, 300);
            scissorsButton.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        add(scissorsButton);

        setLayout(new java.awt.FlowLayout());

        gameLogic = new RockPaperScissorsGame(); // Initialize the game logic
    }

    public void actionPerformed(ActionEvent e) {
        String userChoice = "";
        if (e.getSource() == rockButton) {
            userChoice = "rock";
        } else if (e.getSource() == paperButton) {
            userChoice = "paper";
        } else if (e.getSource() == scissorsButton) {
            userChoice = "scissors";
        }

        int computerChoice = gameLogic.generateRandomNumber();
        String computerAnswer = gameLogic.convertNumberToAnswer(computerChoice);

        gameLogic.handleGuess(userChoice, computerAnswer);
        score = ScoreController.updateScore(score, userChoice, computerAnswer);
        scoreLabel.setText("Score: " + score);

        if (score.startsWith("3") || score.endsWith("3")) {
            JOptionPane.showMessageDialog(this, "Game Over! Final Score: " + score);
            resetGame();
        }
    }

    private void resetGame() {
        score = "0-0";
        scoreLabel.setText("Score: " + score);
    }

    private BufferedImage scaleImage(String file, int width, int height) throws IOException {
        BufferedImage img = ImageIO.read(new File(file));
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(scaledImg, 0, 0, null);
        g2d.dispose();
        return bufferedImage;
    }

}