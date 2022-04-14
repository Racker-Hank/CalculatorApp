package UI;

import UI.components.PrimaryButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import mode.Function2;
import mode.standard.Expressions;

import java.net.URL;
import java.util.ResourceBundle;

//public class Controller2 implements Initializable {
public class Controller2 {

    @FXML
    private Button absButton;

    @FXML
    private Button combinationButton;

    @FXML
    private VBox functionButtonsWrapper;

    @FXML
    private Button permutationButton;

    @FXML
    private Button rootButton;

    @FXML
    private Button sqrtButton;

    @FXML
    private AnchorPane test;

    @FXML
    private HBox mainInputPane;

    @FXML
    private TextArea tempOutputTextArea;

//    public Controller2() {
//        PrimaryButton.mainInputPane = mainInputPane;
//        addFunctionButtons();
//    }
    public void initialize() {
        PrimaryButton.mainInputPane = mainInputPane;
        PrimaryButton.tempOutputTextArea = tempOutputTextArea;
        addFunctionButtons();
    }
    //    public void initialize(URL location, ResourceBundle resources) {
    //        PrimaryButton.mainInputPane = mainInputPane;
    //        addFunctionButtons();
    //    }

    public void addFunctionButtons() {
        Expressions expressions = new Expressions();
        for (Function2 f : Expressions.functions) {
            functionButtonsWrapper.getChildren().add(f.button);
        }
    }

//    public static void setTempOutputTextArea(String tempOutput) {
////        tempOutputTextArea.clear();
//        tempOutputTextArea.setText(tempOutput);
//    }

    public void killme() {
        System.out.println("hi");
        mainInputPane.getChildren().clear();
    }
}
