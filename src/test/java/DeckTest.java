import blackJack.Card;
import blackJack.Deck;
import org.junit.jupiter.api.Test;
import utils.InvalidDeckException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

  @Test
  public void initializeDeck(){
    Deck deck = new Deck();

    assertThat(deck.getCards().size() == 52);
  }

  @Test
  public void shuffleDeck(){
    Deck deck = new Deck();
    List<Card> unShuffledCards = deck.getCards();
    deck.shuffle();
    List<Card> shuffledCards = deck.getCards();

    assertThat(unShuffledCards.get(0) != shuffledCards.get(0));
    assertThat(unShuffledCards.get(5) != shuffledCards.get(5));
  }

  @Test
  public void draw(){
    Deck deck = new Deck();
    Card nextCard = deck.getCards().get(0);

    assertThat(nextCard == deck.draw());
    assertThat(deck.getCards().size() == 51);
  }

  @Test
  public void fromString_success() throws InvalidDeckException {
    String deckAsString = "C2,D2,H2,S2,C3,D3,H3,S3,C4,D4,H4,S4,C5,D5,H5,S5,C6,D6,H6,S6,C7,D7,H7,S7,C8,D8,H8,S8,C9,D9,H9,S9,C10,D10,H10,S10,CJ,DJ,HJ,SJ,CQ,DQ,HQ,SQ,CK,DK,HK,SK,CA,DA,HA,SA";

    Deck deck = Deck.fromString(deckAsString);

    assertEquals(deck.getCards().size(), Deck.STANDARD_DECK_SIZE);
  }

  @Test
  public void fromStringMissingCards_error() {
    String deckAsStringMissingValues = "C2,D2";
    Exception exception = null;

    try{
      Deck deck = Deck.fromString(deckAsStringMissingValues);
    } catch (Exception e){
      exception = e;
    }
    assertEquals(InvalidDeckException.class, exception.getClass());
  }

  @Test
  public void fromStringDuplicates_error() {
    String deckAsStringWithDuplicates = "C2,C2,H2,S2,C3,D3,H3,S3,C4,D4,H4,S4,C5,D5,H5,S5,C6,D6,H6,S6,C7,D7,H7,S7,C8,D8,H8,S8,C9,D9,H9,S9,C10,D10,H10,S10,CJ,DJ,HJ,SJ,CQ,DQ,HQ,SQ,CK,DK,HK,SK,CA,DA,HA,SA";
    Exception exception = null;

    try{
      Deck deck = Deck.fromString(deckAsStringWithDuplicates);
    } catch (Exception e){
      exception = e;
    }

    assertEquals(InvalidDeckException.class, exception.getClass());
  }

}
