package game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MaskerTest {

  @Test public void testGetMaskedWord() {

    List<Character> guessedChars = new ArrayList<>();
    guessedChars.add('E');
    guessedChars.add('V');

    assertEquals("DEVE___E_", Masker.getMaskedWord("DEVELOPER", guessedChars));
  }
  
}
