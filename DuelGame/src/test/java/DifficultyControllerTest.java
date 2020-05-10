import org.junit.Test;

import static org.junit.Assert.*;

public class DifficultyControllerTest extends AbstractTest {
    @Test
    public void easyTest() throws InterruptedException {
        difficultyController.easy.fire();
        assertTrue(difficultyController.checkHit(299));
        assertFalse(difficultyController.checkHit(301));
    }

    @Test
    public void mediumTest() throws InterruptedException {
        difficultyController.medium.fire();
        assertTrue(difficultyController.checkHit(199));
        assertFalse(difficultyController.checkHit(201));
    }

    @Test
    public void hardTest() throws InterruptedException {
        difficultyController.hard.fire();
        assertTrue(difficultyController.checkHit(99));
        assertFalse(difficultyController.checkHit(101));
    }
}