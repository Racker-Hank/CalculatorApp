package UI.Equation;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import mode.equation.Degree;
import mode.equation.SecondDegree;
import mode.equation.ThirdDegree;
import operation.Fraction;
import operation.Operation;

public class ThirdDegreeController {
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
    private TextArea textArea_D;

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
                ThirdDegree thirdDegree = new ThirdDegree();
                Fraction a = Operation.calculate(textArea_A);
                Fraction b = Operation.calculate(textArea_B);
                Fraction c = Operation.calculate(textArea_C);
                Fraction d = Operation.calculate(textArea_D);
                switch (operatorChoiceBox.getValue()) {
                    case "=":
                        thirdDegree.equal(a,b,c,d);
//                        solutionTextArea.setText(firstDegree.solutions.get(0) + "");
                        solutionTextArea.setText(thirdDegree.solutionString);
                        break;
                    case  ">":
                        thirdDegree.greater(a,b,c,d);
                        solutionTextArea.setText(thirdDegree.solutionString);
                        break;
                    case  "<":
                        thirdDegree.smaller(a,b,c,d);
                        solutionTextArea.setText(thirdDegree.solutionString);
                        break;
                    case  "≥":
                        thirdDegree.notSmaller(a,b,c,d);
                        solutionTextArea.setText(thirdDegree.solutionString);
                        break;
                    case  "≤":
                        thirdDegree.notGreater(a,b,c,d);
                        solutionTextArea.setText(thirdDegree.solutionString);
                        break;
                }
            } catch (Exception ex) {
//                ex.printStackTrace();
                solutionTextArea.clear();
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
