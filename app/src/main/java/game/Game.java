package game;

import java.util.Random;

public class Game {

  private String wordToGuess;
  private Integer remainingAttempts;
  private static String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

  public Game(String wordToGuess) {
    this.wordToGuess = wordToGuess;
    this.remainingAttempts = 10;
  }

  public Game() {
    this(getRandomWordFromDictionary());
  }

  private static String getRandomWordFromDictionary() {
    Random randomIndex = new Random();
    String randomWord = DICTIONARY[randomIndex.nextInt(DICTIONARY.length)];
    return randomWord;
  }

  public String getWordToGuess() {
    StringBuilder hiddenWord = new StringBuilder();
    hiddenWord.append(wordToGuess.charAt(0));
    for (int i = 1; i < wordToGuess.length(); i++) {
      hiddenWord.append("_");
    }
    return hiddenWord.toString();
  }

  public Integer getRemainingAttempts() {
    return remainingAttempts;
  }

}
