package mode.standard.expressions;

import UI.UIConfig;
import UI.components.PrimaryButton;
import inputHandler.MathUtil;
import inputHandler.TextHandler;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import mode.Command;
import mode.Function2;

public class Sin extends Function2 {
    public Sin() {
        this.name = "sin(x)";
        this.description = "Calculate sin of x°";
        initButton();
        this.command = new Command(this);
    }

    public void initButton() {
        this.button = new PrimaryButton(this);
//        Tooltip tooltip = new Tooltip(description);
//        Tooltip.install(button , tooltip);
    }

    public void addToTextArea(TextArea inputTextArea) {
//        HBox functionContainer = new HBox();
//        functionContainer.setSpacing(2);
//        String textFieldStyle = "-fx-font-size: 14pt;-fx-font-fill: #FFFFFF;-fx-padding: 0;";
//        TextField functionName0 = new TextField("");
//        functionName0.setStyle(textFieldStyle );
//        //        functionName0.setPrefWidth(14*functionName0.getText().length()+4);
//        setTextFieldWidth(functionName0, 4);
//        functionContainer.getChildren().add(functionName0);
//        TextField functionName1 = new TextField("sin(");
//        functionName1.setEditable(false);
//        //        functionName1.setPrefWidth(14 * 2);
//        setTextFieldWidth(functionName1, -1);
//        //        functionName1.setStyle(textFieldStyle + "-fx-background-color: transparent;");
//        functionName1.setStyle(textFieldStyle + "-fx-background-color: transparent;");
//        functionContainer.getChildren().add(functionName1);
//        TextField functionName2 = new TextField();
//        functionName2.setStyle(textFieldStyle + "fx-padding: 0 2;");
//        //        functionName2.setPrefWidth(14*functionName2.getText().length()+4);
//        setTextFieldWidth(functionName2, -1);
//        functionContainer.getChildren().add(functionName2);
//        TextField functionName3 = new TextField(")");
//        functionName3.setStyle(textFieldStyle + "-fx-background-color: transparent;");
//        functionName3.setEditable(false);
//        //        functionName3.setPrefWidth(14 * 2);
//        setTextFieldWidth(functionName3, -1);
//        functionContainer.getChildren().add(functionName3);
//        //        InputPane inputPane = new InputPane();
//        //        functionContainer.getChildren().add(inputPane);
//        ((HBox) (parentPane)).getChildren().add(functionContainer);
//
//        parentPane.getParent().addEventHandler(MouseEvent.MOUSE_CLICKED , new EventHandler <MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if (event.getTarget() != functionContainer) {
//                    double y;
//                    double x;
//                    try {
//                        y = Double.parseDouble(functionName0.getText() == "" ? "1" : functionName0.getText());
//                        x = Double.parseDouble(functionName2.getText());
//                        if (!Double.isNaN(x)) {
//                            PrimaryButton.tempOutputTextArea.setText(TextHandler.numberFormatter(calculate(y,x)) +
//                                    "");
//                        }
//                    } catch (NumberFormatException e) {
//                        //                        e.printStackTrace();
//                    }
//                }
//            }
//        });
        inputTextArea.setText(inputTextArea.getText() + "sin(");
    }

//    public double calculate(Object... num) {
//        return (Double)num[0] * MathUtil.sinDegrees((Double) num[1]);
//    }
//
//    public void setTextFieldWidth(TextField textField, double prefWidth) {
//        //        textField.setPrefWidth(new Text(textField.getText()).getLayoutBounds().getWidth() + textField.getPadding().getLeft() + textField.getPadding().getRight() + 2d);
//        textField.setPrefWidth(prefWidth > 0 ? prefWidth : Math.max(UIConfig.fontSize ,
//                UIConfig.fontSize * (textField.getText().length() - 2) + textField.getPadding().getLeft() + textField.getPadding().getRight() + 4d));
//        textField.textProperty().addListener((ov , prevText , currText) -> {
//            // Do this in a Platform.runLater because of Textfield has no padding at first time and so on
//            Platform.runLater(() -> {
//                Text text = new Text(currText);
//                text.setFont(textField.getFont()); // Set the same font, so the size is the same
//                double width = text.getLayoutBounds().getWidth() // This big is the Text in the TextField
//                        + textField.getPadding().getLeft() + textField.getPadding().getRight() // Add the padding of the
//                        // TextField
//                        + 2d; // Add some spacing
//                textField.setPrefWidth(width); // Set the width
//                textField.positionCaret(textField.getCaretPosition()); // If you remove this line, it flashes a little bit
//            });
//        });
//        textField.setMinWidth(Region.USE_PREF_SIZE);
//        textField.setMaxWidth(Region.USE_PREF_SIZE);
//    }
}
