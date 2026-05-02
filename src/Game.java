import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Game {
    Player player1;
    Player player2;
    ArrayList<Round> roundHistory = new ArrayList<Round>();

    public void play(Scanner input) {
        System.out.print("Enter Player 1 name: ");
        player1 = new Player(input.nextLine());

        System.out.print("Enter Player 2 name: ");
        player2 = new Player(input.nextLine());

        while(player1.score < 2 && player2.score < 2) {
            System.out.print(player1.name + " choose rock, paper, or scissor: ");

            String choice1;
            while(true) {
                choice1 = input.nextLine().toLowerCase();

                if(choice1.equals("rock") || choice1.equals("paper") || choice1.equals("scissor")) {
                    break;
                }

                System.out.print("Invalid input. Enter rock, paper, or scissor: ");
            }

            System.out.print(player2.name + " choose rock, paper, or scissor: ");

            String choice2;
            while(true) {
                choice2 = input.nextLine().toLowerCase();

                if(choice2.equals("rock") || choice2.equals("paper") || choice2.equals("scissor")) {
                    break;
                }

                System.out.print("Invalid input. Enter rock, paper, or scissor: ");
            }

            String winner = getRoundWinner(choice1, choice2);
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

            Round r = new Round(choice1, choice2, result);
            r.addReplayRound(new Round(choice1, choice2, result));
            roundHistory.add(r);
     
            System.out.println(result);
            System.out.println("Score: " + player1.name + " " + player1.score +
                               " - " + player2.name + " " + player2.score);
        }

        if(player1.score == 2) {
            System.out.println(player1.name + " wins the match!");
        }
        else {
            System.out.println(player2.name + " wins the match!");
        }

        showHistory();
        saveHistory();
    }

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

    public void showHistory() {
        System.out.println("\nRound History:");

        for(int i = 0; i < roundHistory.size(); i++) {
            System.out.println((i + 1) + ". " + roundHistory.get(i));
        }
    }

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

class Round {
    String p1;
    String p2;
    String result;
    ArrayList<Round> replayRounds = new ArrayList<Round>();

    public Round(String p1, String p2, String result) {
        this.p1 = p1;
        this.p2 = p2;
        this.result = result;
    }

    public void addReplayRound(Round round) {
        replayRounds.add(round);
    }

    public String toString() {
        return p1 + " vs " + p2 + " -> " + result;
    }
}