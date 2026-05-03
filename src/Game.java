import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Game {

    // Two player objects
    Player player1;
    Player player2;

    // Stores all rounds played in the match
    ArrayList<Round> roundHistory = new ArrayList<Round>();

    public void play(Scanner input) {

        // Taking player names
        System.out.print("Enter Player 1 name: ");
        player1 = new Player(input.nextLine());

        System.out.print("Enter Player 2 name: ");
        player2 = new Player(input.nextLine());

        /*
         * Loop runs until one player gets 2 points
         * (Best of 3 game)
         */
        while(player1.score < 2 && player2.score < 2) {

            // Get valid choices from both players
            String choice1 = getValidChoice(input, player1.name);
            String choice2 = getValidChoice(input, player2.name);

            // Determine winner of the round
            String winner = getRoundWinner(choice1, choice2);

            // Update score and get result message
            String result = updateScoreAndGetResult(winner);

            // Save round info in history
            roundHistory.add(new Round(choice1, choice2, result));

            // Display round result and score
            System.out.println(result);
            System.out.println("Score: " + player1.name + " " + player1.score +
                               " - " + player2.name + " " + player2.score);
        }

        // Show final winner
        showMatchWinner();

        // Show all rounds played
        showHistory();

        // Save history to file
        saveHistory();
    }

    /*
     * Keeps asking until user enters:
     * rock / paper / scissor
     */
    public String getValidChoice(Scanner input, String playerName) {

        System.out.print(playerName + " choose rock, paper, or scissor: ");

        String choice = input.nextLine().toLowerCase();

        // Repeat until valid input
        while(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissor")) {
            System.out.print("Invalid input. Enter rock, paper, or scissor: ");
            choice = input.nextLine().toLowerCase();
        }

        return choice;
    }

    /*
     * Determines winner based on rules:
     * rock beats scissor
     * paper beats rock
     * scissor beats paper
     */
    public String getRoundWinner(String choice1, String choice2) {

        if(choice1.equals(choice2)) {
            return "draw";
        }

        if(choice1.equals("rock") && choice2.equals("scissor")) {
            return "player1";
        }
        else if(choice1.equals("paper") && choice2.equals("rock")) {
            return "player1";
        }
        else if(choice1.equals("scissor") && choice2.equals("paper")) {
            return "player1";
        }
        else {
            return "player2";
        }
    }

    /*
     * Updates score and returns result message
     */
    public String updateScoreAndGetResult(String winner) {

        String result;

        if(winner.equals("player1")) {
            player1.addPoint();
            result = player1.name + " won the round";
        }
        else if(winner.equals("player2")) {
            player2.addPoint();
            result = player2.name + " won the round";
        }
        else {
            result = "Draw";
        }

        return result;
    }

    /*
     * Displays final winner of the match
     */
    public void showMatchWinner() {

        if(player1.score == 2) {
            System.out.println(player1.name + " wins the match!");
        }
        else {
            System.out.println(player2.name + " wins the match!");
        }
    }

    /*
     * Prints all rounds played
     */
    public void showHistory() {

        System.out.println("\nRound History:");

        for(int i = 0; i < roundHistory.size(); i++) {
            System.out.println((i + 1) + ". " + roundHistory.get(i));
        }
    }

    /*
     * Saves round history to a file named history.txt
     */
    public void saveHistory() {

        try {
            FileWriter writer = new FileWriter("history.txt");

            for(int i = 0; i < roundHistory.size(); i++) {
                writer.write(roundHistory.get(i).toString() + "\n");
            }

            writer.close();
            System.out.println("History saved to file.");
        }
        catch(IOException e) {
            System.out.println("Error saving history.");
        }
    }
}

/*
 * Represents one round of the game
 */
class Round {

    String p1;
    String p2;
    String result;

    public Round(String p1, String p2, String result) {
        this.p1 = p1;
        this.p2 = p2;
        this.result = result;
    }

    /*
     * Defines how the round will be printed
     */
    public String toString() {
        return p1 + " vs " + p2 + " -> " + result;
    }
}