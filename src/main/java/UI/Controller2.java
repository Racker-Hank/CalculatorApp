package UI;

import UI.components.InputPane;
import UI.components.PrimaryButton;
import UI.components.ToggleSwitch;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import mode.standard.Expressions;
import mode.standard.Specials;

import java.util.ArrayList;
import java.util.HashMap;

//public class Controller2 implements Initializable {
public class Controller2 {

    @FXML
    private Button absButton;

    @FXML
    private Button combinationButton;

    @FXML
    private GridPane functionButtonsWrapper;

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

    @FXML
    private HBox tabsButtonContainer;

    Expressions expressions;
    Specials specials;
    HashMap <String, VBox> functionButtonsWrappers = new HashMap <>();
    VBox visibleFunctionButtonsWrapper;
    ToggleSwitch toggleSwitch;

    //    public Controller2() {
    //        PrimaryButton.mainInputPane = mainInputPane;
    //        addFunctionButtons();
    //    }
    public void initialize() {
        PrimaryButton.mainInputPane = mainInputPane;
        InputPane test = new InputPane();
        mainInputPane.getChildren().add(test);


        //        LatexView latex = new LatexView();
        //        latex.setFormula("1");
        //        latex.setSize(30);
        //        mainInputPane.getChildren().add(latex);

        PrimaryButton.tempOutputTextArea = tempOutputTextArea;
        //        (Button) tabsButtonContainer.getChildren().get(0) =
        //        tabsButtonContainer.getChildren().add(PrimaryButton.toPrimaryButton((Button) tabsButtonContainer.getChildren().get(0) , 14,
        //                        UIConfig.colorWhite));
        //        tabsButtonContainer.getChildren().add(PrimaryButton.toPrimaryButton((Button) tabsButtonContainer.getChildren().get(1) , 14, UIConfig.colorPrimaryGreen));
        //        tabsButtonContainer.getChildren().add(PrimaryButton.toPrimaryButton((Button) tabsButtonContainer.getChildren().get(2) , 14, UIConfig.colorPink));
        //        tabsButtonContainer.getChildren().add(PrimaryButton.toPrimaryButton((Button) tabsButtonContainer.getChildren().get(3) , 14, UIConfig.colorYellow));
        initTabsButtons();
        expressions = new Expressions();
        specials = new Specials();
        addFunctionButtons();
    }

    private void initTabsButtons() {
        //        tabsButtonContainer.getChildren().set(0 ,
        //                new PrimaryButton().toPrimaryButton((Button) tabsButtonContainer.getChildren().get(0) , 14 ,
        //                        UIConfig.colorWhite));
        //        tabsButtonContainer.getChildren().set(1 ,
        //                new PrimaryButton().toPrimaryButton((Button) tabsButtonContainer.getChildren().get(1) , 14 ,
        //                        UIConfig.colorPrimaryGreen));
        //        tabsButtonContainer.getChildren().set(2 ,
        //                new PrimaryButton().toPrimaryButton((Button) tabsButtonContainer.getChildren().get(2) , 14 ,
        //                        UIConfig.colorPink));
        //        tabsButtonContainer.getChildren().set(3 ,
        //                new PrimaryButton().toPrimaryButton((Button) tabsButtonContainer.getChildren().get(3) , 14 ,
        //                        UIConfig.colorYellow));
        tabsButtonContainer.getChildren().add(new PrimaryButton(0 , UIConfig.colorWhite));
        ((PrimaryButton) tabsButtonContainer.getChildren().get(0)).setText("Refactor Result");
        tabsButtonContainer.getChildren().add(new PrimaryButton(1 , UIConfig.colorPrimaryGreen));
        ((PrimaryButton) tabsButtonContainer.getChildren().get(1)).setText("Expressions");
        tabsButtonContainer.getChildren().add(new PrimaryButton(2 , UIConfig.colorPink));
        ((PrimaryButton) tabsButtonContainer.getChildren().get(2)).setText("Specials");
        tabsButtonContainer.getChildren().add(new PrimaryButton(3 , UIConfig.colorYellow));
        ((PrimaryButton) tabsButtonContainer.getChildren().get(3)).setText("Constants");
        (tabsButtonContainer.getChildren().get(3)).addEventHandler(MouseEvent.MOUSE_CLICKED , event -> {
            ((PrimaryButton) tabsButtonContainer.getChildren().get(3)).isActive = !((PrimaryButton) tabsButtonContainer.getChildren().get(3)).isActive;
            if (((PrimaryButton) tabsButtonContainer.getChildren().get(3)).isActive) {
                (tabsButtonContainer.getChildren().get(3)).setStyle(((PrimaryButton) tabsButtonContainer.getChildren().get(3)).activeStyle);
            } else {
                (tabsButtonContainer.getChildren().get(3)).setStyle(((PrimaryButton) tabsButtonContainer.getChildren().get(3)).inactiveStyle);
            }
        });

        for (int i = 0; i < tabsButtonContainer.getChildren().size(); i++) {
            PrimaryButton button = (PrimaryButton) tabsButtonContainer.getChildren().get(i);
            button.setId("tabButton " + i);
            if (i == 3) {
                button.isActive = false;
                button.setStyle(button.inactiveStyle);
            }
            button.addEventHandler(MouseEvent.MOUSE_CLICKED , event -> {
                //                for (Node pb: tabsButtonContainer.getChildren()) {
                //                    ((PrimaryButton) pb).isActive = false;
                //                    pb.setStyle(((PrimaryButton) pb).inactiveStyle);
                //                }
                selectFunctionButtonsWrapper(Integer.parseInt(button.getId().charAt(button.getId().length() - 1) + ""));
                //                button.isActive = !button.isActive;
                //                if (button.isActive) {
                //                    button.setStyle(button.activeStyle);
                //                } else {
                //                    button.setStyle(button.inactiveStyle);
                //                }
            });
        }
        //        ((PrimaryButton) tabsButtonContainer.getChildren().get(1)).isActive = true;
        //        ((PrimaryButton) tabsButtonContainer.getChildren().get(1)).setStyle(((PrimaryButton) tabsButtonContainer.getChildren().get(1)).activeStyle);
    }

    private void selectFunctionButtonsWrapper(int id) {
        visibleFunctionButtonsWrapper.setVisible(false);
        if (id == 1) visibleFunctionButtonsWrapper = functionButtonsWrappers.get("expression");
        if (id == 2) {
            visibleFunctionButtonsWrapper = functionButtonsWrappers.get(
                    "special");
        }
        visibleFunctionButtonsWrapper.setVisible(true);
    }

    public void addFunctionButtons() {
        int buttonPerRow = 6;
        //        if (tabTracker[1]) {
        VBox expressionButtonsContainer = new VBox(8);
        for (int i = 0; i < Expressions.functions.size() / buttonPerRow + 1; i++) {
            HBox hBox = new HBox();
            hBox.setSpacing(8);
            hBox.setAlignment(javafx.geometry.Pos.CENTER);
            for (int j = 0; j < Math.min(buttonPerRow , Expressions.functions.size() - i * buttonPerRow); j++) {
                hBox.getChildren().add(Expressions.functions.get(i * buttonPerRow + j).button);
            }
            expressionButtonsContainer.getChildren().add(hBox);

        }
        visibleFunctionButtonsWrapper = expressionButtonsContainer;
        //            functionButtonsWrapper.getChildren().clear();
        //            functionButtonsWrapper.getChildren().add(expressionButtonsContainer);
        //        }
        //        if (tabTracker[2]) {
        VBox specialButtonsContainer = new VBox(8);
        for (int i = 0; i < Specials.functions.size() / buttonPerRow + 1; i++) {
            HBox hBox = new HBox();
            hBox.setSpacing(8);
            hBox.setAlignment(javafx.geometry.Pos.CENTER);
            for (int j = 0; j < Math.min(buttonPerRow , Specials.functions.size() - i * buttonPerRow); j++) {
                hBox.getChildren().add(Specials.functions.get(i * buttonPerRow + j).button);
            }
            //                functionButtonsWrapper.getChildren().clear();
            specialButtonsContainer.getChildren().add(hBox);
            specialButtonsContainer.setVisible(false);
        }
        functionButtonsWrappers.put("expression" , expressionButtonsContainer);
        functionButtonsWrappers.put("special" , specialButtonsContainer);
        functionButtonsWrapper.getChildren().add(expressionButtonsContainer);
        functionButtonsWrapper.getChildren().add(specialButtonsContainer);
        //            functionButtonsWrapper.getChildren().clear();
        //            functionButtonsWrapper.getChildren().add(expressionButtonsContainer);
        //        }
        toggleSwitch = new ToggleSwitch();
        HBox toggleSwitchContainer = new HBox(toggleSwitch);
        toggleSwitchContainer.setAlignment(Pos.CENTER);
        functionButtonsWrapper.addRow(1 , toggleSwitchContainer);
    }

    //    public static void setTempOutputTextArea(String tempOutput) {
    ////        tempOutputTextArea.clear();
    //        tempOutputTextArea.setText(tempOutput);
    //    }

    public void killme() {
        //        System.out.println("hi");
        for (Node node : mainInputPane.getChildren()) {
            node = null;
        }
        mainInputPane.getChildren().clear();
        tempOutputTextArea.clear();
        InputPane test = new InputPane();
        mainInputPane.getChildren().add(test);
    }
}
