import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;


public class StatusBar extends StackPane implements Output {
    private Label label = new Label();


    public StatusBar() {
        getChildren().add(label);
    }

    @Override
    public void printOutput(String s) {
        label.setText(s);
    }
}
