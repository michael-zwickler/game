package game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {
  @Test public void testGetsWordToGuess() {
    Game game = new Game("Makers");
    assertEquals("chooses a word at random", game.getWordToGuess(), "M_____");
  }

  @Test public void testGetRemainingAttempts() {
    Game game = new Game("Makers");
    assertEquals("initializes with 10 remaining attempts", Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test public void testGetRemainingAttemptsEmptyConstructor() {
    Game game = new Game();
    assertEquals("initializes with 10 remaining attempts", Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test public void testGetsWordToGuessEmptyConstructor() {
    Game game = new Game();
    assertEquals("chooses a word at random", game.getWordToGuess().isEmpty(), false);
  }
}
