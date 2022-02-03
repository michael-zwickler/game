package game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordChoserTest {

  @Test public void testgetRandomWordFromDictionary() {
    WordChoser wordChoser = new WordChoser();
    String[] dictionary = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

    String randomWord = wordChoser.getRandomWordFromDictionary();

    Boolean isInDictionary = false;
    
    for (String str : dictionary) {
      if (str.equals(randomWord)) {
        isInDictionary = true;
      }  
    }

    assertTrue("The return string of getRandomWordFromDictionary should be out of the dictionary", isInDictionary);
  }
}
