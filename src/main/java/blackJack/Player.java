package blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player implements Comparable<Player>{
  private String name;
  private int drawLimit;
  private int score;
  private List<Card> hand;


  public Player(String name){
    this.name = name;
    this.drawLimit = 21;
    this.score = 0;
    this.hand = new ArrayList<Card>();
  }

  public Player(String name, int drawLimit){
    this.name = name;
    this.drawLimit = drawLimit;
    this.score = 0;
    this.hand = new ArrayList<Card>();
  }

  public String getName(){
    return name;
  }

  public int getDrawLimit() {
    return drawLimit;
  }

  public int getScore() {
    return score;
  }

  public List<Card> getHand() {
    return hand;
  }

  public String getHandAsString() {
    return hand.stream()
            .map(Object::toString)
            .collect(Collectors.joining(", "));
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDrawLimit(int drawLimit) {
    this.drawLimit = drawLimit;
  }

  public void setScore(int score){
    this.score = score;
  }

  public void addToHand(Card card){
    hand.add(card);
    score += card.getCardValue();
  }

  public boolean hasBlackJack(){
    return getScore() == 21;
  }

  public boolean hasLost(){
    return score > 21;
  }

  @Override
  public int compareTo(Player player){
    return Integer.compare(this.score, player.getScore());
  }

}
