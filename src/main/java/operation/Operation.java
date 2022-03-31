package operation;

import java.util.Stack;

import inputHandler.TextHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Operation {

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Button calculateBtn;

    public void initialize() {
        inputTextArea.setOnKeyTyped(event -> {
            try {
                calculate();
            } catch (Exception e) {
            }
        });
    }

    public Fraction calculate() {
        Fraction result = new Fraction();
        TextHandler.mathInputHandler(inputTextArea.getText() , result);
        try {
            outputTextArea.setText(Double.toString(result.toDouble()));
            return result;
        } catch (Exception e) {
            //            e.printStackTrace();
        }
        //        System.out.println(Math.round(Math.sqrt(2)*Math.pow(10,9)) / Math.pow(10,9));
        return null;
    }
}
