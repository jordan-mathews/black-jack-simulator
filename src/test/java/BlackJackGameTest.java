import blackJack.BlackJackGame;
import blackJack.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackJackGameTest {
  private BlackJackGame game;

  @BeforeEach
  public void setup(){
    game = new BlackJackGame();
  }

  @Test
  public void simulatePlay_BothPlayersHaveBlackJack(){
    game.getPlayerOne().setScore(21);
    game.getDealer().setScore(21);
    Player winner = game.simulatePlay();

    assertEquals(game.getPlayerOne(), winner);

  }

  @Test
  public void simulatePlay_DealerHasBlackJack(){
    game.getPlayerOne().setScore(10);
    game.getDealer().setScore(21);
    Player winner = game.simulatePlay();

    assertEquals(game.getDealer(), winner);
  }

  @Test
  public void simulatePlay_PlayerOneHasBlackJack(){
    game.getPlayerOne().setScore(21);
    game.getDealer().setScore(10);
    Player winner = game.simulatePlay();

    assertEquals(game.getPlayerOne(), winner);
  }

  @Test
  public void simulatePlay_PlayerOneBust(){
    game.getPlayerOne().setScore(25);
    game.getDealer().setScore(10);
    Player winner = game.simulatePlay();

    assertEquals(game.getDealer(), winner);
  }

  @Test
  public void simulatePlay_DealerBust(){
    game.getPlayerOne().setScore(18);
    game.getDealer().setScore(25);
    Player winner = game.simulatePlay();

    assertEquals(game.getPlayerOne(), winner);
  }


  @Test
  public void simulatePlay_BothPlayersBust(){
    game.getPlayerOne().setScore(22);
    game.getDealer().setScore(22);
    Player winner = game.simulatePlay();

    assertEquals(game.getDealer(), winner);
  }


  @Test
  public void simulatePlay_PlayersOneHighScore(){
    game.getPlayerOne().setScore(20);
    game.getDealer().setScore(19);
    Player winner = game.simulatePlay();

    assertEquals(game.getPlayerOne(), winner);
  }

  @Test
  public void simulatePlay_DealerHighScore(){
    game.getPlayerOne().setScore(19);
    game.getDealer().setScore(20);
    Player winner = game.simulatePlay();

    assertEquals(game.getDealer(), winner);
  }


  @Test
  public void continuousDraw_playerAtLimit(){
    Player playerOne = game.getPlayerOne();
    playerOne.setScore(playerOne.getDrawLimit());

    game.continuousDraw(playerOne, playerOne.getDrawLimit());

    assertEquals(0, game.getPlayerOne().getHand().size(), "Drew no cards, already hit limit");
  }

  @Test
  public void continuousDraw_playerBelowLimit(){
    Player playerOne = game.getPlayerOne();
    playerOne.setScore(playerOne.getDrawLimit() -1);

    game.continuousDraw(playerOne, playerOne.getDrawLimit());

    assertEquals(1, game.getPlayerOne().getHand().size(), "Drew one card, then hit limit.");
  }

  @Test
  public void dealCards_success(){
    Player playerOne = game.getPlayerOne();
    game.deal(playerOne);

    assertEquals(1, game.getPlayerOne().getHand().size());
  }

}
