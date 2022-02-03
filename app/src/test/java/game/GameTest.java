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

  @Test public void testGetsWordToGuess() {
    WordChoser wordChoser = mock(WordChoser.class);
    when(wordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    
    Game game = new Game(wordChoser);
    assertEquals("Returns the word to guess, with hidden characters", game.getWordToGuess(), "M_____");
  }

  @Test public void testGetRemainingAttempts() {
    WordChoser wordChoser = mock(WordChoser.class);
    
    Game game = new Game(wordChoser);
    assertEquals("initializes with 10 remaining attempts", Integer.valueOf(10), game.getRemainingAttempts());
  }

  @Test public void testGuessLetterReturnsTrueWhenCorrectGuess() {
    WordChoser wordChoser = mock(WordChoser.class);
    when(wordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");
    
    Game game = new Game(wordChoser);
    assertTrue(game.guessLetter('K'));    
  }

  @Test public void testGuessLetterStoresTheLetterWhenCorrectGuess() {
    WordChoser wordChoser = mock(WordChoser.class);
    when(wordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Game game = new Game(wordChoser);
    game.guessLetter('K');

    assertTrue(game.getGuessedChars().contains('K'));
  }

  @Test public void testGuessLetterReturnsFalseWhenIncorrectGuess() {
    WordChoser wordChoser = mock(WordChoser.class);
    when(wordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Game game = new Game(wordChoser);
    assertFalse(game.guessLetter('T'));
  }

  @Test public void testGuessLetterReducesAmountToGuessWhenIncorrectGuess() {
    WordChoser wordChoser = mock(WordChoser.class);
    when(wordChoser.getRandomWordFromDictionary()).thenReturn("MAKERS");

    Game game = new Game(wordChoser);
    game.guessLetter('L');
    assertEquals(Integer.valueOf(9), game.getRemainingAttempts());
  }

}
