import blackJack.Card;
import blackJack.Player;
import blackJack.Suit;
import blackJack.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

  @Test
  public void compareTo(){
    Player player1 = new Player("player1");
    Player player2 = new Player("player2");

    assertEquals(0, player2.compareTo(player1), "Player 2 tied with Player 2");

    player1.setScore(21);

    assertEquals(-1, player2.compareTo(player1), "Player 2 is loosing");
    assertEquals(1, player1.compareTo(player2), "Player 1 is winning");
  }


  @Test
  public void hasBlackJack(){
    Player player1 = new Player("player1");
    Player player2 = new Player("player2");

    player1.setScore(21);

    assertEquals(true, player1.hasBlackJack());
    assertEquals(false, player2.hasBlackJack());
  }

  @Test
  public void hasLost(){
    Player player1 = new Player("player1");
    Player player2 = new Player("player2");

    player1.setScore(22);

    assertEquals(true, player1.hasLost());
    assertEquals(false, player2.hasLost());
  }

  @Test
  public void addToHand(){
    Player player1 = new Player("player1");
    Card card = new Card(Suit.CLUBS, Value.ACE);

    assertEquals(0, player1.getScore());
    player1.addToHand(card);
    assertEquals(card.getCardValue(), player1.getScore());
  }

  @Test
  public void getHandAsString(){
    Player player1 = new Player("player1");
    player1.addToHand(new Card(Suit.CLUBS, Value.ACE));
    player1.addToHand(new Card(Suit.HEARTS, Value.TEN));

    assertEquals("CA, H10", player1.getHandAsString());
  }
}
