import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralTest extends AbstractTest {
    @Test
    public void missTest() throws InterruptedException {
        startGame();
        turnController.startTurn("A");
        turnController.head.fire();
        Thread.sleep(1000);
        turnController.fireButton.fire();
        assertEquals(2, gameController.currentPlayer);
    }

    @Test
    public void hitHeadTest() throws InterruptedException {
        startGame();
        turnController.startTurn("A");
        turnController.head.fire();
        Thread.sleep(8000);
        turnController.fireButton.fire();
        assertEquals(0, gameController.currentPlayer);
    }

    @Test
    public void hitBodyTest() throws InterruptedException {
        startGame();
        turnController.startTurn("A");
        turnController.body.fire();
        Thread.sleep(5000);
        turnController.fireButton.fire();
        assertEquals(0, gameController.currentPlayer);
    }

    @Test
    public void hitHeartTest() throws InterruptedException {
        startGame();
        turnController.startTurn("A");
        turnController.heart.fire();
        Thread.sleep(15000);
        turnController.fireButton.fire();
        assertEquals(0, gameController.currentPlayer);
    }
}