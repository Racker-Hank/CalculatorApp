package UI.Conversion;

import inputHandler.TextHandler;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import mode.conversion.Area;
import mode.conversion.Length;
import mode.conversion.Unit;
import mode.conversion.Volume;
import operation.Operation;

import java.util.HashMap;

public class VolumeConversionController {
    @FXML
    private TextArea fromUnitTextArea;

    @FXML
    private TextArea toUnitTextArea;

    @FXML
    private ChoiceBox <String> fromUnitChoiceBox = new ChoiceBox <String>();

    @FXML
    private ChoiceBox <String> toUnitChoiceBox = new ChoiceBox <String>();

    public HashMap <String, Unit> unitsMap;

    @FXML
    private Label conversionModeName;

    String conversionMode;

    ChangeListener choiceBoxListener = (obs , oldValue , newValue) -> {
        Platform.runLater(() -> {
            convert();
        });
    };

    public void initialize() {
        //        System.out.println(conversionModeName.getText().toLowerCase());
        unitsMap = Volume.unitsMap;
        //        initConversionMode();
        initTextArea();
        initChoiceBox();
    }

    //    public void initConversionMode() {
    //        conversionMode = conversionModeName.getText().toLowerCase();
    //        switch (conversionMode) {
    //            case "length":
    //                unitsMap = Length.unitsMap;
    //                break;
    //            case "area":
    //                unitsMap = Area.unitsMap;
    //                break;
    //            case "volume":
    //                unitsMap = Volume.unitsMap;
    //                break;
    //        }
    //    }

    public void initTextArea() {
        fromUnitTextArea.textProperty().addListener(choiceBoxListener);
    }

    public void initChoiceBox() {
        fromUnitChoiceBox.getItems().addAll(unitsMap.keySet());
        fromUnitChoiceBox.setTooltip(new Tooltip("Unit to convert from"));
        fromUnitChoiceBox.setValue("m³");
        //        fromUnitChoiceBox.setValue((String) unitsMap.keySet().toArray()[0]);
        fromUnitChoiceBox.valueProperty().addListener(choiceBoxListener);

        toUnitChoiceBox.getItems().addAll(unitsMap.keySet());
        toUnitChoiceBox.setTooltip(new Tooltip("Unit to convert to"));
        toUnitChoiceBox.setValue("\uD835\uDC59");
        //        toUnitChoiceBox.setValue((String) unitsMap.keySet().toArray()[1]);
        toUnitChoiceBox.valueProperty().addListener(choiceBoxListener);
    }

    public void convert() {
        try {
//            double n = Double.parseDouble(fromUnitTextArea.getText());
            double n = Operation.calculate(fromUnitTextArea).toDouble();
            Unit fromUnit = unitsMap.get(fromUnitChoiceBox.getValue());
            Unit toUnit = unitsMap.get(toUnitChoiceBox.getValue());
            Number result;
            //            switch (conversionMode) {
            //                case "length":
            //                    result = TextHandler.numberFormatter(Length.convert(fromUnit , toUnit , n));
            //                    break;
            //                case "area":
            //                    result = TextHandler.numberFormatter(Area.convert(fromUnit , toUnit , n));
            //                    break;
            //                case "volume":
            result = TextHandler.numberFormatter(Volume.convert(fromUnit , toUnit , n));
            //                    break;
            //                default:
            //                    result = TextHandler.numberFormatter(0);
            //            }
            toUnitTextArea.setText(result + "");
        } catch (Exception e) {
            //                    e.printStackTrace();
        }
    }

}
