package operation;

import java.util.Stack;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Operation {

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea outputTextArea;

    public void initialize() {
        inputTextArea.setOnKeyTyped(event -> {
            outputTextArea.setText(inputTextArea.getText());
        });

    }

    public void calculate() {
        Stack <Operand> operands = new Stack <>();
        Stack <Operator> operators = new Stack <>();

    }
}
