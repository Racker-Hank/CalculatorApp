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

    public  Fraction calculate() {
        Fraction result = new Fraction();
        TextHandler.mathInputHandler(inputTextArea.getText() , result);
        try {
            outputTextArea.setText(String.valueOf(TextHandler.numberFormatter(result.toDouble())));
//            System.out.println(TextHandler.numberFormatter(result.toDouble()));
            return result;
        } catch (Exception e) {
            //            e.printStackTrace();
        }
        return null;
    }

    public static Fraction calculate(TextArea inputTextArea) {
        Fraction result = new Fraction();
        TextHandler.mathInputHandler(inputTextArea.getText() , result);
        try {
//            outputTextArea.setText(String.valueOf(TextHandler.numberFormatter(result.toDouble())));
//            System.out.println(TextHandler.numberFormatter(result.toDouble()));
            return result;
        } catch (Exception e) {
            //            e.printStackTrace();
        }
        return null;
    }

    public static Fraction calculate(TextArea inputTextArea, TextArea outputTextArea) {
        Fraction result = new Fraction();
        TextHandler.mathInputHandler(inputTextArea.getText() , result);
        try {
            outputTextArea.setText(String.valueOf(TextHandler.numberFormatter(result.toDouble())));
//            System.out.println(TextHandler.numberFormatter(result.toDouble()));
            return result;
        } catch (Exception e) {
            //            e.printStackTrace();
        }
        return null;
    }
}
