package blackJack;

import utils.InvalidDeckException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
  public static final int STANDARD_DECK_SIZE = 52;
  private final List<Card> cards;

  public Deck(){
    this.cards = initializeDeck();
  }

  public Deck(List<Card> cards){
    this.cards = cards;
  }

  public List<Card> getCards(){
    return cards;
  }

  public List<Card> initializeDeck(){
    List<Card> cards = new ArrayList<>();

    for(Value value : Value.values()){
      for(Suit suit : Suit.values()){
        cards.add(new Card(suit, value));
      }
    }
    return cards;
  }

  public Deck shuffle(){
    Collections.shuffle(this.cards);
    return this;
  }

  public Card draw(){
    Card nextCard = cards.get(cards.size() -1);
    cards.remove(cards.size() -1);

    return nextCard;
  }

  public static Deck fromString(String input) throws InvalidDeckException {
    List<Card> cards = Stream.of(input.split(","))
            .distinct()
            .map (elem -> Card.fromString(elem.trim()))
            .collect(Collectors.toList());

    if(cards.size() != STANDARD_DECK_SIZE){
      throw new InvalidDeckException("Invalid Deck. Input should contain a string of " +STANDARD_DECK_SIZE+ " comma separated unique and valid cards.");
    }

    return new Deck(cards);

  }

}
