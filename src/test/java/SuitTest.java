import blackJack.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuitTest {

  @Test
  public void parse_validSuit(){
    Suit result = Suit.parse(Suit.HEARTS.getLabel());

    assertEquals(Suit.HEARTS, result);
  }

  @Test
  public void parse_invalidSuit(){
    Exception exception = null;
    try {
      Suit result = Suit.parse("Not A Real Suit");
    } catch(Exception e){
      exception = e;
    }

    assertEquals(IllegalArgumentException.class, exception.getClass());
  }
}
