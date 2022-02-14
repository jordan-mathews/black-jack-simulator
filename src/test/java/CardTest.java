import blackJack.Card;
import blackJack.Suit;
import blackJack.Value;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

  @Test
  void correctStringValue(){
    Card card = new Card(Suit.CLUBS, Value.ACE);

    assertEquals(card.toString(), Suit.CLUBS.toString() + Value.ACE);
  }

  @Test
  void generateCardFromString(){
    Card card = Card.fromString("CA");

    assertEquals(card.toString(), Suit.CLUBS.toString() + Value.ACE);
  }

}
