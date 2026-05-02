public class Player {
    String name;
    int score;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public void addPoint() {
        score++;
    }
}