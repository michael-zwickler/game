package game;

import java.util.ArrayList;
import java.util.List;

public class Game {

  private String wordToGuess;
  private Integer remainingAttempts;
  private List<Character> guessedChars;
  private Boolean isGameLost;
  private Boolean isGameWon;

  public Game(WordChoser wordChoser) {
    this(wordChoser.getRandomWordFromDictionary());
  }

  public Game(String wordToGuess) {
    this.wordToGuess = wordToGuess;
    this.remainingAttempts = 10;
    this.guessedChars = new ArrayList<>();
    this.isGameLost = false;
    this.isGameWon = false;
  }

  public String getWordToGuess() {
    String maskedWord = Masker.getMaskedWord(wordToGuess, guessedChars);
    return maskedWord;
  }

  public List<Character> getGuessedChars() {
    return this.guessedChars;
  }

  public Boolean guessLetter(char guessedChar) {
    Boolean isCorrectGuess = this.wordToGuess.contains("" + guessedChar);
    if (isCorrectGuess) 
      this.guessedChars.add(guessedChar);
    else 
      this.remainingAttempts--;

    this.evaluateGameStatus();
    return isCorrectGuess;
  }

  public Integer getRemainingAttempts() {
    return this.remainingAttempts;
  }

  public boolean isGameLost() {
    return this.isGameLost;
  }

  public boolean isGameWon() {
    return this.isGameWon;
  }

  private void evaluateGameStatus() {
    if (this.isGameWon || this.isGameLost) return;

    Boolean isAttemptsLeft = this.remainingAttempts > 0;
    Boolean isWordGuessed = !this.getWordToGuess().contains("_");

    if (isAttemptsLeft && isWordGuessed) {
      // this.isGameLost = false;
      this.isGameWon = true;
    } 
    if (!isAttemptsLeft && !isWordGuessed) {
      this.isGameLost = true;
      // this.isGameWon = false;
    }
        
  }

}
