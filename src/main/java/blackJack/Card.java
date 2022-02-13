package blackJack;

public class Card {
  private final Suit suit;
  private final Value value;

  public Card(Suit suit, Value value) {
    this.suit = suit;
    this.value = value;
  }

  public Suit getSuit(){
    return suit;
  }

  public Value getValue(){
    return value;
  }

  public int getCardValue(){
    return value.getValue();
  }

  @Override
  public String toString(){
    return this.suit.toString() + this.value.toString();
  }

  public static Card fromString(String card){
    Suit suit = Suit.parse(card.substring(0, 1));
    Value value = Value.parse(card.substring(1));
    return new Card(suit, value);
  }

}
