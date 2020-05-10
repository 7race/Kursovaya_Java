import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class DifficultyController extends VBox {
    public RadioButton easy = new RadioButton("Easy");
    public RadioButton medium = new RadioButton("Medium");
    public RadioButton hard = new RadioButton("Hard");

    private ToggleGroup difficultyLevels = new ToggleGroup();


    public DifficultyController() {
        easy.setToggleGroup(difficultyLevels);
        medium.setToggleGroup(difficultyLevels);
        hard.setToggleGroup(difficultyLevels);
        medium.fire();
        getChildren().addAll(easy, medium, hard);
    }


    public boolean checkHit(long mills){
        long accuracyThreshold = 0;
        if (easy.isSelected()) {
            accuracyThreshold = 300;
        } else if (medium.isSelected()) {
            accuracyThreshold = 200;
        } else if (hard.isSelected()) {
            accuracyThreshold = 100;
        } else {
            throw new RuntimeException("Difficulty not selected");
        }

        return mills <= accuracyThreshold;
    }

}
