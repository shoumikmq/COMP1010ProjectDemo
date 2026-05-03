public class Player {

    // Stores the player's name
    String name;

    // Stores the player's score
    int score;

    /*
     * Constructor: creates a new Player object
     * and sets initial score to 0
     */
    public Player(String name) {
        this.name = name;
        score = 0;
    }

    /*
     * Adds 1 point to the player's score
     */
    public void addPoint() {
        score++;
    }
}