package blackJack;

public class BlackJackGame {
  private Player playerOne;
  private Player dealer;
  private Deck deck;

  public BlackJackGame(){
    this.deck = new Deck().shuffle();
    this.dealer = new Player("Dealer");
    this.playerOne = new Player("Sam", 17);
  }

  public BlackJackGame(Deck deck){
    this.deck = deck.shuffle();
    this.dealer = new Player("Dealer");
    this.playerOne = new Player("Sam", 17);
  }

  public Player getDealer() {
    return dealer;
  }

  public Player getPlayerOne() {
    return playerOne;
  }

  public void start(){
    initialDeal();
    Player winner = simulatePlay();

    System.out.println(winner.getName());
    System.out.println(playerOne.getName()+ ": " + playerOne.getHandAsString());
    System.out.println(dealer.getName()+ ": " + dealer.getHandAsString());
  }


  public Player simulatePlay(){
    if(playerOne.hasBlackJack() && dealer.hasBlackJack()) {
      return playerOne;
    } else if(playerOne.hasBlackJack()) {
      return playerOne;
    } else if(dealer.hasBlackJack()){
      return dealer;
    } else if(playerOne.getScore() == 22 && dealer.getScore() == 22){
      return dealer;
    }

    continuousDraw(playerOne, playerOne.getDrawLimit());
    if(playerOne.hasLost()) return dealer;

    continuousDraw(dealer, playerOne.getScore() +1);
    if(dealer.hasLost()) return playerOne;

    return playerOne.compareTo(dealer) == 1 ? playerOne : dealer;
  }

  public void deal(Player player){
    if(!deck.getCards().isEmpty()) return;

    Card card = deck.draw();
    player.addToHand(card);
  }

  public void continuousDraw(Player player, int drawLimit){
    if(player.getScore() >= drawLimit) return;
    deal(player);
    continuousDraw(player, drawLimit);
  }

  private void initialDeal(){
    for(int i = 0; i < 2; i++){
      deal(playerOne);
      deal(dealer);
    }
  }


}
