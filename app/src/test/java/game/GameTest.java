package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class GameTest {

  @Test public void testGetRandomWordFromDictionaryIsCalledOnce() {
    WordChoser wordChoser = mock(WordChoser.class);
    new Game(wordChoser);
    verify(wordChoser, times(1)).getRandomWordFromDictionary();
  }

  @Test public void testGetsWordToGuessWithRandomWord() {
    WordChoser wordChoser = mock(WordChoser.class);
    when(wordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    Game game = new Game(wordChoser);
    assertEquals("Returns the word to guess, with hidden characters", "M_____", game.getWordToGuess());
  }

  @Test public void testGetsWordToGuess() {
    Game game = new Game("MAKERS"); // ==> OBJ123456
    assertEquals("Returns the word to guess, with hidden characters", "M_____", game.getWordToGuess());
  }

  @Test public void testGetsWordToGuessWithACorrectGuess() {
    Game game = new Game("DEVELOPER");
    game.guessLetter('V');
    assertEquals("D_V______", game.getWordToGuess());
  }

  @Test public void testGetRemainingAttempts() {
    Game game = new Game("MAKERS");
    assertEquals("initializes with 10 remaining attempts", Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test public void testGuessLetterReturnsTrueWhenCorrectGuess() {
    Game game = new Game("MAKERS");
    assertTrue(game.guessLetter('K'));    
  }

  @Test public void testGuessLetterStoresTheLetterWhenCorrectGuess() {
    Game game = new Game("MAKERS");
    game.guessLetter('K');
    assertTrue(game.getGuessedChars().contains('K'));
  }

  @Test public void testGuessLetterReturnsFalseWhenIncorrectGuess() {
    Game game = new Game("MAKERS");
    assertFalse(game.guessLetter('T'));
  }

  @Test public void testGuessLetterReducesAmountToGuessWhenIncorrectGuess() {
    Game game = new Game("MAKERS");
    game.guessLetter('L');
    assertEquals(Integer.valueOf(9), game.getRemainingAttempts());
  }

  @Test public void testGameStatusAfterTooManyWrongGuesses() {
    Game game = new Game("MAKERS");
    for (int i = 0; i < 10; i++) {
      game.guessLetter('T');
    }
    assertTrue(game.isGameLost());
    assertFalse(game.isGameWon());
  }

  @Test public void testGameStatusWhenInitialized() {
    Game game = new Game("MAKERS");
    assertFalse(game.isGameLost());
    assertFalse(game.isGameWon());
  }

  @Test public void testGameStatusWhenAllGuessesCorrect() {
    Game game = new Game("ABC");
    game.guessLetter('B');
    game.guessLetter('C');
    assertFalse(game.isGameLost());
    assertTrue(game.isGameWon());
  }

  @Test public void testGameStatusWhenOverunningAttemps() {
    Game game = new Game("ABC");
    for (int i = 0; i < 10; i++) {
      game.guessLetter('T');
    }
    game.guessLetter('B');
    game.guessLetter('C');
    assertTrue(game.isGameLost());
    assertFalse(game.isGameWon());
  }

  @Test public void testGameStatusWhenAnsweringCorrectlyThenOverrunning() {
    Game game = new Game("ABC");
    game.guessLetter('B');
    game.guessLetter('C');
    for (int i = 0; i < 10; i++) {
      game.guessLetter('T');
    }
    assertFalse(game.isGameLost());
    assertTrue(game.isGameWon());
  }

  
}
