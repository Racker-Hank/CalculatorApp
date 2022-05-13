package UI.Conversion;

import inputHandler.TextHandler;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import mode.conversion.Length;
import mode.conversion.Unit;
import operation.Operation;

import java.util.HashMap;

public class LengthConversionController {
    @FXML
    private TextArea fromUnitTextArea;

    @FXML
    private TextArea toUnitTextArea;

    @FXML
    private ChoiceBox <String> fromUnitChoiceBox = new ChoiceBox <String>();

    @FXML
    private ChoiceBox <String> toUnitChoiceBox = new ChoiceBox <String>();

    public HashMap <String, Unit> unitsMap;

    public void initialize() {
        //        fromUnit.getItems().addAll(Length.lengthUnits);
        unitsMap = Length.unitsMap;
        initTextArea();
        initChoiceBox();
    }

    public void initTextArea() {
        fromUnitTextArea.textProperty().addListener((obs , oldValue , newValue) -> {
            Platform.runLater(() -> {
                convert();
            });
        });
    }

    public void initChoiceBox() {
        ChangeListener choiceBoxListener = (obs , oldValue , newValue) -> {
            Platform.runLater(() -> {
                convert();
            });
        };

        for (String unitName : unitsMap.keySet()
        ) {
            fromUnitChoiceBox.getItems().add(unitName);
        }
        fromUnitChoiceBox.setTooltip(new Tooltip("Unit to convert from"));
        fromUnitChoiceBox.setValue("m");

        fromUnitChoiceBox.valueProperty().addListener(choiceBoxListener);

        //        toUnit.getItems().addAll(Length.lengthUnits);
        toUnitChoiceBox.getItems().addAll(unitsMap.keySet());
        toUnitChoiceBox.setTooltip(new Tooltip("Unit to convert to"));
        toUnitChoiceBox.setValue("km");
        toUnitChoiceBox.valueProperty().addListener(choiceBoxListener);
    }

    public void convert() {
        try {
//            double n = Double.parseDouble(fromUnitTextArea.getText());
            double n = Operation.calculate(fromUnitTextArea).toDouble();
            Unit fromUnit = unitsMap.get(fromUnitChoiceBox.getValue());
            Unit toUnit = unitsMap.get(toUnitChoiceBox.getValue());
            toUnitTextArea.setText(TextHandler.numberFormatter(Length.convert(fromUnit , toUnit , n)) + "");
        } catch (Exception e) {
            //                    e.printStackTrace();
        }
    }

}
