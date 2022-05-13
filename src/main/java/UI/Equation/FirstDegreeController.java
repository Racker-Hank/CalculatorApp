package UI.Equation;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import mode.equation.Degree;
import mode.equation.FirstDegree;
import operation.Fraction;
import operation.Operation;

public class FirstDegreeController {
    @FXML
    private Label degreeName;

    @FXML
    private HBox mainInputPane;

    @FXML
    private TextArea solutionTextArea;

    @FXML
    private TextArea textArea_A;

    @FXML
    private TextArea textArea_B;

    @FXML
    private ChoiceBox<String> operatorChoiceBox;

    @FXML
    private Button solveButton;

    public void initialize() {
        initChoiceBox();
//        initTextArea();
        initButton();
    }

    private void initButton() {
        solveButton.setOnMouseClicked(e -> {
            try {
                FirstDegree firstDegree = new FirstDegree();
                Fraction a = Operation.calculate(textArea_A);
                Fraction b = Operation.calculate(textArea_B);
                switch (operatorChoiceBox.getValue()) {
                    case "=":
                        firstDegree.equal(a,b);
//                        solutionTextArea.setText(firstDegree.solutions.get(0) + "");
                        solutionTextArea.setText(firstDegree.solutionString);
                        break;
                    case  ">":
                        firstDegree.greater(a,b);
                        solutionTextArea.setText(firstDegree.solutionString);
                        break;
                    case  "<":
                        firstDegree.smaller(a,b);
                        solutionTextArea.setText(firstDegree.solutionString);
                        break;
                    case  "≥":
                        firstDegree.notSmaller(a,b);
                        solutionTextArea.setText(firstDegree.solutionString);
                        break;
                    case  "≤":
                        firstDegree.notGreater(a,b);
                        solutionTextArea.setText(firstDegree.solutionString);
                        break;
                }
            } catch (Exception ex) {
//                ex.printStackTrace();
            }
        });
    }

    private void initTextArea() {

    }

    private void initChoiceBox() {
        operatorChoiceBox.getItems().addAll(Degree.operators);
        operatorChoiceBox.setValue("=");
        operatorChoiceBox.setTooltip(new Tooltip("Choose an operator"));
    }
}
