import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest extends AbstractTest{
    @Test
    public void initialStateTest() {
        assertEquals(0, gameController.currentPlayer);
    }

    @Test
    public void startGameTest() {
        startGame();
        assertEquals(1, gameController.currentPlayer);
    }

}