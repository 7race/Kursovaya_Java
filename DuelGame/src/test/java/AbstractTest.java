import javafx.embed.swing.JFXPanel;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    public GameController gameController;
    public DifficultyController difficultyController;
    public Output output = s -> {};
    public TurnController turnController;


 
    @BeforeClass
    public static void initToolkit()
            throws InterruptedException
    {
        final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> {
            new JFXPanel();
            latch.countDown();
        });

        if (!latch.await(5L, TimeUnit.SECONDS))
            throw new ExceptionInInitializerError();
    }

    @Before
    public void reset() {
        turnController = new TurnController(output);
        difficultyController = new DifficultyController();
        gameController = new GameController(output, difficultyController, turnController);
        turnController.setGameController(gameController);
    }

    public void startGame(){
        gameController.player1.setText("player1");
        gameController.player2.setText("player2");
        gameController.start.fire();
    }
}
