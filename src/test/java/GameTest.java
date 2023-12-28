import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();

    @Test
    public void testNotRegisterPlayer1() {
        Player ivan = new Player(1, "Ivan", 100);
        Player petya = new Player(2, "Petya", 50);

        game.register(ivan);
        game.register(petya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Roma", "Petya"));

    }

    @Test
    public void testNotRegisterPlayer2() {
        Player ivan = new Player(1, "Ivan", 100);
        Player petya = new Player(2, "Petya", 50);

        game.register(ivan);
        game.register(petya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Roma"));

    }

    @Test
    public void testWhenPlayer1Win() {
        Player ivan = new Player(1, "Ivan", 100);
        Player petya = new Player(2, "Petya", 50);

        game.register(ivan);
        game.register(petya);

        int expected = 1;
        int actual = game.round("Ivan", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayer2Win() {
        Player ivan = new Player(1, "Ivan", 100);
        Player petya = new Player(2, "Petya", 500);

        game.register(ivan);
        game.register(petya);

        int expected = 2;
        int actual = game.round("Ivan", "Petya");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenStrengthsEquals() {
        Player ivan = new Player(1, "Ivan", 500);
        Player petya = new Player(2, "Petya", 500);

        game.register(petya);
        game.register(ivan);


        int expected = 0;
        int actual = game.round("Ivan", "Petya");

        Assertions.assertEquals(expected, actual);

    }
}
