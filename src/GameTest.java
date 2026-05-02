import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {

    @Test
    public void testRockBeatsScissor() {
        Game game = new Game();
        assertEquals("player1", game.getRoundWinner("rock", "scissor"));
    }

    @Test
    public void testPaperBeatsRock() {
        Game game = new Game();
        assertEquals("player1", game.getRoundWinner("paper", "rock"));
    }

    @Test
    public void testScissorBeatsPaper() {
        Game game = new Game();
        assertEquals("player1", game.getRoundWinner("scissor", "paper"));
    }

    @Test
    public void testDraw() {
        Game game = new Game();
        assertEquals("draw", game.getRoundWinner("rock", "rock"));
    }

    @Test
    public void testPlayer2Wins() {
        Game game = new Game();
        assertEquals("player2", game.getRoundWinner("rock", "paper"));
    }
}