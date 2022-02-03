package game;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private String wordToGuess;
  private Integer remainingAttempts;
  private List<Character> guessedChars;

  public Game(WordChoser wordChoser) {
    this(wordChoser.getRandomWordFromDictionary());
  }

  public Game(String wordToGuess) {
    this.wordToGuess = wordToGuess;
    this.remainingAttempts = 10;
    this.guessedChars = new ArrayList<>();
  }

  public String getWordToGuess() {
    StringBuilder hiddenWord = new StringBuilder();
    hiddenWord.append(wordToGuess.charAt(0));
    for (int i = 1; i < wordToGuess.length(); i++) {
      hiddenWord.append("_");
    }
    return hiddenWord.toString();
  }

  public List<Character> getGuessedChars() {
    return guessedChars;
  }

  public Boolean guessLetter(char guessedChar) {
    Boolean isCorrectGuess = wordToGuess.contains("" + guessedChar);
    if (isCorrectGuess) 
      this.guessedChars.add(guessedChar);
    else 
      this.remainingAttempts--;

    return isCorrectGuess;
  }

  public Integer getRemainingAttempts() {
    return remainingAttempts;
  }

}
