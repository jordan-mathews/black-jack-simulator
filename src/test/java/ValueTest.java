import blackJack.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueTest {

  @Test
  public void parse_validSuit(){
    Value result = Value.parse(Value.TEN.getLabel());

    assertEquals(Value.TEN, result);
  }

  @Test
  public void parse_invalidSuit(){
    Exception exception = null;
    try {
      Value result = Value.parse("100");
    } catch(Exception e){
      exception = e;
    }

    assertEquals(IllegalArgumentException.class, exception.getClass());
  }
}
