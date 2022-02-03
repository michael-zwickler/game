package game;

import java.util.Random;

public class WordChoser {

  private static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

  public String getRandomWordFromDictionary() {
    Random rand = new Random();
    int randomIndex = rand.nextInt(DICTIONARY.length);
    return DICTIONARY[randomIndex]; 
  }
  
}
