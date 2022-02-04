package game;

import java.util.ArrayList;
import java.util.List;

public class Game {

  // Static Variables -------------------------- //

  // Instance Variables ------------------------ //
  private Integer remainingAttempts;
  private String wordToGuess;
  private List<Character> guessedChars;
  private Boolean isGameLost, isGameWon;

  // Constructors -------------------------------//
  public Game(String wordToGuess) {
    this.wordToGuess = wordToGuess;
    this.remainingAttempts = 10;
    this.guessedChars = new ArrayList<>();
    this.isGameLost = false;
    this.isGameWon = false;
  }

  public Game(WordChoser wordChoser) {
    this(wordChoser.getRandomWordFromDictionary());
  }

  // Getters ------------------------------------// 
  public Integer getRemainingAttempts() { return this.remainingAttempts; }

  public boolean isGameLost() { return this.isGameLost; }

  public boolean isGameWon() { return this.isGameWon; }

  public List<Character> getGuessedChars() { return this.guessedChars; }

  public String getWordToGuess() {
    String maskedWord = Masker.getMaskedWord(wordToGuess, guessedChars);
    return maskedWord;
  }

  // Methods -----------------------------------//
  public Boolean guessLetter(char guessedChar) {
    Boolean isCorrectGuess = this.wordToGuess.contains("" + guessedChar);
    if (isCorrectGuess) 
      this.guessedChars.add(guessedChar);
    else 
      this.remainingAttempts--;

    this.evaluateGameStatus();
    return isCorrectGuess;
  }

  private void evaluateGameStatus() {
    if (this.isGameWon || this.isGameLost) return;

    Boolean isAttemptsLeft = this.remainingAttempts > 0;
    Boolean isWordGuessed = !this.getWordToGuess().contains("_");

    if (isAttemptsLeft && isWordGuessed) {
      this.isGameWon = true;     // this.isGameLost stays false
    } 
    if (!isAttemptsLeft && !isWordGuessed) {
      this.isGameLost = true;   // this.isGameWon stays false
    }    
  }
}
