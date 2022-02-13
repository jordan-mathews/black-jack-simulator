package blackJack;

public enum Suit {
  CLUBS("C"),
  DIAMONDS("D"),
  HEARTS("H"),
  SPADES("S");

  private final String label;

  Suit(String label){
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  @Override
  public String toString(){
    return this.label;
  }

  public static Suit parse(String input) {
    for(Suit value :Suit.values()){
      if(value.getLabel().equals(input)) return value;
    }

    throw new IllegalArgumentException("Invalid suit provided: " + input);
  }

}
