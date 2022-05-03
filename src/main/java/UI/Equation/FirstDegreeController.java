package UI.Equation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class FirstDegreeController {
    @FXML
    private Label degreeName;

    @FXML
    private HBox mainInputPane;

    @FXML
    private ChoiceBox<String> operatorChoiceBox;

    @FXML
    private TextArea solutionTextArea;

    @FXML
    private AnchorPane test;

    @FXML
    private TextArea textArea_A;

    @FXML
    private TextArea textArea_B;

    @FXML
    private Button solveButton;

    public void initialize() {

    }
}
