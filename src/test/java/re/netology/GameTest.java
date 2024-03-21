package re.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void notFindPlayer() {
        Player player1 = new Player(4, "gonzo", 100);
        Player player2 = new Player(21, "pegas", 90);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("paul", "pegas");
        });

    }

    @Test
    public void playerOneWinner() {

        Player player1 = new Player(4, "gonzo", 100);
        Player player2 = new Player(21, "pegas", 90);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("gonzo", "pegas");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerTwoWinner() {

        Player gonzo = new Player(4, "gonzo", 100);
        Player pegas = new Player(21, "pegas", 120);
        Game game = new Game();

        game.register(gonzo);
        game.register(pegas);

        int actual = game.round("gonzo", "pegas");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundDraw() {

        Player gonzo = new Player(4, "gonzo", 100);
        Player pegas = new Player(21, "pegas", 100);
        Game game = new Game();

        game.register(gonzo);
        game.register(pegas);

        int actual = game.round("gonzo", "pegas");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}