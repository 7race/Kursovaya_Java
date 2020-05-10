import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameWindow extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Duel game");
        VBox root = new VBox();

        StatusBar statusBar = new StatusBar();
        DifficultyController difficultyController = new DifficultyController();
        TurnController turnController = new TurnController(statusBar);
        GameController gameController = new GameController(statusBar, difficultyController, turnController);
        turnController.setGameController(gameController);

        root.getChildren().addAll(difficultyController, gameController, turnController, statusBar);

        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }
}