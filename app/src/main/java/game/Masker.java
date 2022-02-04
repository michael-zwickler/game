package game;

import java.util.List;

public class Masker {

  private Masker() {}

  public static String getMaskedWord(String wordToGuess, List<Character> guessedChars) {
    StringBuilder hiddenWord = new StringBuilder();
    hiddenWord.append(wordToGuess.charAt(0));
    
    for (int i = 1; i < wordToGuess.length(); i++) {
      char currentChar = wordToGuess.charAt(i);
      if (guessedChars.contains(currentChar)) {
        hiddenWord.append(currentChar);   
      } else {
        hiddenWord.append("_");
      }
    }
    
    return hiddenWord.toString();        
  }
  
}
