package nl.vasilverdouw.example_code;

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
public class RockPaperScissorsGame {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    public void playRockPaperScissorsGame() {
        String score = "0-0";
        String userAnswer = "";
        String computerAnswer = "";
        System.out.println("Let's play rock, paper, scissors! First to 3 wins!");
        while (!score.startsWith("3") && !score.endsWith("3")) {
            System.out.println("Rock, paper, or scissors?");
            int computerChoice = generateRandomNumber();
            userAnswer = System.console().readLine();
            computerAnswer = convertNumberToAnswer(computerChoice);
            handleGuess(userAnswer, computerAnswer);
            score = ScoreController.updateScore(score, userAnswer, computerAnswer);
            System.out.println("The score is " + score);
        }
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * 3 + 1);
    }

    public static String convertNumberToAnswer(int number) {
        if (number == 1) {
            return ROCK;
        } else if (number == 2) {
            return PAPER;
        } else {
            return SCISSORS;
        }
    }

    public static void handleGuess(String guess, String answer) {
        if (!guess.equals("rock") && !guess.equals("paper") && !guess.equals("scissors")) {
            System.out.println("Your guess must be rock, paper, or scissors.");
        } else if (guess.equals(answer)) {
            System.out.println("It's a tie!");
        } else if (guess.equals(ROCK) && answer.equals(PAPER)) {
            System.out.println("You lose!");
        } else if (guess.equals(ROCK) && answer.equals(SCISSORS)) {
            System.out.println("You win!");
        } else if (guess.equals(PAPER) && answer.equals(ROCK)) {
            System.out.println("You win!");
        } else if (guess.equals(PAPER) && answer.equals(SCISSORS)) {
            System.out.println("You lose!");
        } else if (guess.equals(SCISSORS) && answer.equals(ROCK)) {
            System.out.println("You lose!");
        } else if (guess.equals(SCISSORS) && answer.equals(PAPER)) {
            System.out.println("You win!");
        }
    }
}
