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
    Game game = new Game(wordChoser);
    verify(wordChoser, times(1)).getRandomWordFromDictionary();
  }

  @Test public void testGetsWordToGuessWithRandomWord() {
    WordChoser wordChoser = mock(WordChoser.class);
    when(wordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    Game game = new Game(wordChoser);
    assertEquals("Returns the word to guess, with hidden characters", "M_____", game.getWordToGuess());
  }

  @Test public void testGetsWordToGuess() {
    Game game = new Game("MAKERS");
    assertEquals("Returns the word to guess, with hidden characters", "M_____", game.getWordToGuess());
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

}
