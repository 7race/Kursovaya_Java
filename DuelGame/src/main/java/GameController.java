import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class GameController extends HBox {
    private final Output output;
    private final DifficultyController difficultyController;
    private final TurnController turnController;

    public int currentPlayer;

    public Button start = new Button("Начать игру!");
    public Button newGame = new Button("Новая игра!");
    public TextField player1 = new TextField();
    public TextField player2 = new TextField();

    public GameController(Output output, DifficultyController difficultyController, TurnController turnController) {
        this.output = output;
        this.difficultyController = difficultyController;
        this.turnController = turnController;

        setCurrentPlayer(0);
        getChildren().addAll(player1, player2);

        start.setOnAction(event -> {
            if (player1.getText().isEmpty())
                output.printOutput("Не задано имя первого игрока");
            else if (player2.getText().isEmpty())
                output.printOutput("Не задано имя второго игрока");
            else if (player2.getText().equals(player1.getText()))
                output.printOutput("Имена игроков совпадают");
            else {
                setCurrentPlayer(1);
                output.printOutput(player1.getText() + " готовится!");
            }
        });

        newGame.setOnAction(event -> {
            output.printOutput("Введите имена игроков");
            setCurrentPlayer(0);
        });

        newGame.fire();

    }

    private void setCurrentPlayer(int p){
        currentPlayer = p;
        getChildren().remove(start);
        getChildren().remove(newGame);
        if (p != 0) {
            getChildren().add(newGame);
            player1.setEditable(false);
            player2.setEditable(false);
            difficultyController.setDisable(true);
        } else {
            getChildren().add(start);
            player1.setEditable(true);
            player2.setEditable(true);
            difficultyController.setDisable(false);
        }
        if (p == 0) turnController.startTurn(null);
        if (p == 1) turnController.startTurn(player1.getText());
        if (p == 2) turnController.startTurn(player2.getText());
    }

    public void shoot(long miss){
        boolean hit = difficultyController.checkHit(miss);
        String currentPlayerName;
        String nextPlayerName;
        if (currentPlayer == 1) {
            currentPlayerName = player1.getText();
            nextPlayerName = player2.getText();
        } else {
            currentPlayerName = player2.getText();
            nextPlayerName = player1.getText();
        }
        if (hit) {
            output.printOutput("Смертельное попадание! " + currentPlayerName + " победил!");
            setCurrentPlayer(0);
        } else {
            output.printOutput(currentPlayerName + " промахнулся! " + nextPlayerName + " готовится!");
            if (currentPlayer == 1)
                setCurrentPlayer(2);
            else
                setCurrentPlayer(1);
        }
    }
}
