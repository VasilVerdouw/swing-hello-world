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
public class ScoreController {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    public static String updateScore(String score, String guess, String answer) {
        if (guess.equals(answer)) {
            return score;
        } else if (guess.equals(ROCK) && answer.equals(PAPER)) {
            return updateScoreForComputer(score);
        } else if (guess.equals(ROCK) && answer.equals(SCISSORS)) {
            return updateScoreForUser(score);
        } else if (guess.equals(PAPER) && answer.equals(ROCK)) {
            return updateScoreForUser(score);
        } else if (guess.equals(PAPER) && answer.equals(SCISSORS)) {
            return updateScoreForComputer(score);
        } else if (guess.equals(SCISSORS) && answer.equals(ROCK)) {
            return updateScoreForComputer(score);
        } else if (guess.equals(SCISSORS) && answer.equals(PAPER)) {
            return updateScoreForUser(score);
        } else {
            return score;
        }
    }

    public static String updateScoreForUser(String score) {
        String[] scoreArray = score.split("-");
        int userScore = Integer.parseInt(scoreArray[0]);
        int computerScore = Integer.parseInt(scoreArray[1]);
        userScore++;
        return userScore + "-" + computerScore;
    }

    public static String updateScoreForComputer(String score) {
        String[] scoreArray = score.split("-");
        int userScore = Integer.parseInt(scoreArray[0]);
        int computerScore = Integer.parseInt(scoreArray[1]);
        computerScore++;
        return userScore + "-" + computerScore;
    }

}
