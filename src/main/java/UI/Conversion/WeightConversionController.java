package UI.Conversion;

import inputHandler.TextHandler;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import mode.conversion.Unit;
import mode.conversion.Weight;
import operation.Operation;

import java.util.HashMap;

public class WeightConversionController {
    @FXML
    private TextArea fromUnitTextArea;

    @FXML
    private TextArea toUnitTextArea;

    @FXML
    private ChoiceBox<String> fromUnitChoiceBox = new ChoiceBox <String>();

    @FXML
    private ChoiceBox <String> toUnitChoiceBox = new ChoiceBox <String>();

    public HashMap<String, Unit> unitsMap;

    ChangeListener choiceBoxListener = (obs , oldValue , newValue) -> {
        Platform.runLater(() -> {
            convert();
        });
    };

    public void initialize() {
        unitsMap = Weight.unitsMap;
        initTextArea();
        initChoiceBox();
    }

    public void initTextArea() {
        fromUnitTextArea.textProperty().addListener(choiceBoxListener);
    }

    public void initChoiceBox() {
        fromUnitChoiceBox.getItems().addAll(unitsMap.keySet());
        fromUnitChoiceBox.setTooltip(new Tooltip("Unit to convert from"));
        fromUnitChoiceBox.setValue("g");
        fromUnitChoiceBox.valueProperty().addListener(choiceBoxListener);

        toUnitChoiceBox.getItems().addAll(unitsMap.keySet());
        toUnitChoiceBox.setTooltip(new Tooltip("Unit to convert to"));
        toUnitChoiceBox.setValue("kg");
        toUnitChoiceBox.valueProperty().addListener(choiceBoxListener);
    }

    public void convert() {
        try {
//            double n = Double.parseDouble(fromUnitTextArea.getText());
            double n = Operation.calculate(fromUnitTextArea).toDouble();
            Unit fromUnit = unitsMap.get(fromUnitChoiceBox.getValue());
            Unit toUnit = unitsMap.get(toUnitChoiceBox.getValue());
            toUnitTextArea.setText(TextHandler.numberFormatter(Weight.convert(fromUnit , toUnit , n)) + "");
        } catch (Exception e) {
            //                    e.printStackTrace();
        }
    }

}
