import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner is used to read input from the keyboard.
        Scanner input = new Scanner(System.in);

        // Create one Game object to control the whole match.
        Game game = new Game();

        // Start the game.
        game.play(input);

        // Close Scanner after the game is finished.
        input.close();
    }
}