import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class TurnController extends VBox {
    private Output output;
    private GameController gameController;

    private String turnOfPlayer = null;
    private Label playerLabel = new Label();

    private long time;

    public Button fireButton = new Button("ОГОНЬ!");
    public Button heart = new Button("Сердце (15 сек)");
    public Button head = new Button("Голова (8 сек)");
    public Button body = new Button("Живот (5 сек)");

    public TurnController(Output output) {
        this.output = output;

        getChildren().addAll(playerLabel, heart, head, body, fireButton);

        startTurn(null);

        heart.setOnAction(event -> prepareToShoot(15000));
        head.setOnAction(event -> prepareToShoot(8000));
        body.setOnAction(event -> prepareToShoot(5000));

        fireButton.setOnAction(event -> shoot());
    }

    private void prepareToShoot(int millis) {
        heart.setDisable(true);
        head.setDisable(true);
        body.setDisable(true);
        fireButton.setDisable(false);
        output.printOutput("К БАРЬЕРУ!");
        time = System.currentTimeMillis() + millis;
    }

    private void shoot(){
        long miss = Math.abs(System.currentTimeMillis() - time);
        startTurn(null);
        gameController.shoot(miss);
    }

    public void startTurn(String ofPlayer){
        turnOfPlayer = ofPlayer;
        if (turnOfPlayer == null){
            playerLabel.setText("Ход игрока: ");
            fireButton.setDisable(true);
            heart.setDisable(true);
            head.setDisable(true);
            body.setDisable(true);
        } else {
            playerLabel.setText("Ход игрока: " + ofPlayer);
            fireButton.setDisable(false);
            heart.setDisable(false);
            head.setDisable(false);
            body.setDisable(false);
        }
        fireButton.setDisable(true);
    }


    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}
