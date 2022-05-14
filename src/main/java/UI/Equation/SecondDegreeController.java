package UI.Equation;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import mode.equation.Degree;
import mode.equation.FirstDegree;
import mode.equation.SecondDegree;
import operation.Fraction;
import operation.Operation;

public class SecondDegreeController {
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
    private TextArea textArea_C;

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
                SecondDegree secondDegree = new SecondDegree();
                Fraction a = Operation.calculate(textArea_A);
                Fraction b = Operation.calculate(textArea_B);
                Fraction c = Operation.calculate(textArea_C);
                switch (operatorChoiceBox.getValue()) {
                    case "=":
                        secondDegree.equal(a,b,c);
//                        solutionTextArea.setText(firstDegree.solutions.get(0) + "");
                        solutionTextArea.setText(secondDegree.solutionString);
                        break;
                    case  ">":
                        secondDegree.greater(a,b,c);
                        solutionTextArea.setText(secondDegree.solutionString);
                        break;
                    case  "<":
                        secondDegree.smaller(a,b,c);
                        solutionTextArea.setText(secondDegree.solutionString);
                        break;
                    case  "≥":
                        secondDegree.notSmaller(a,b,c);
                        solutionTextArea.setText(secondDegree.solutionString);
                        break;
                    case  "≤":
                        secondDegree.notGreater(a,b,c);
                        solutionTextArea.setText(secondDegree.solutionString);
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
