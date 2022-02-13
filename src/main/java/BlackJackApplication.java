import blackJack.BlackJackGame;
import blackJack.Deck;
import utils.FileUtility;

public class BlackJackApplication {

  public static void main(String[] args){
    try {
      BlackJackGame game;

      if(args.length > 0){
        String fileContents = new FileUtility().readFromFile(args[0]);
        game = new BlackJackGame(Deck.fromString(fileContents));
      } else {
        game = new BlackJackGame();
      }

      game.start();
    } catch(Exception e){
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }

}
