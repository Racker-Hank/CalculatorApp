package mode.standard.specials;

import UI.UIConfig;
import UI.components.PrimaryButton;
import javafx.scene.control.TextArea;
import mode.Command;
import mode.Function2;

public class RandInRangeMN extends Function2 {
    public RandInRangeMN() {
        this.name = "rand(m,n)";
        this.description = "Generates a random number between m and n";
        initButton();
        this.command = new Command(this);
    }

    public void initButton() {
        this.button = new PrimaryButton(this , UIConfig.colorPink);
    }

    public void addToTextArea(TextArea inputTextArea) {
        //        HBox functionContainer = new HBox();
        //        functionContainer.setSpacing(2);
        //        String textFieldStyle = "-fx-font-size: 14pt;-fx-font-fill: #FFFFFF;-fx-padding: 0;";
        //        TextField functionName0 = new TextField("");
        //        functionName0.setStyle(textFieldStyle);
        //        setTextFieldWidth(functionName0 , 8);
        //        functionContainer.getChildren().add(functionName0);
        //
        //        TextField functionName1 = new TextField("rand(");
        //        functionName1.setEditable(false);
        //        setTextFieldWidth(functionName1 , -1);
        //        functionName1.setStyle(textFieldStyle + "-fx-background-color: transparent;");
        //        functionContainer.getChildren().add(functionName1);
        //
        //        TextField functionName2 = new TextField();
        //        functionName2.setStyle(textFieldStyle);
        //        setTextFieldWidth(functionName2 , -1);
        //        functionContainer.getChildren().add(functionName2);
        //
        //        TextField functionName3 = new TextField(",");
        //        functionName3.setEditable(false);
        //        setTextFieldWidth(functionName3 , -1);
        //        functionName3.setStyle(textFieldStyle + "-fx-background-color: transparent;");
        //        functionContainer.getChildren().add(functionName3);
        //
        //        TextField functionName4 = new TextField();
        //        functionName4.setStyle(textFieldStyle);
        //        setTextFieldWidth(functionName4 , -1);
        //        functionContainer.getChildren().add(functionName4);
        //
        //        TextField functionName5 = new TextField(")");
        //        functionName5.setStyle(textFieldStyle + "-fx-background-color: transparent;");
        //        functionName5.setEditable(false);
        //        setTextFieldWidth(functionName5 , -1);
        //        functionContainer.getChildren().add(functionName5);
        //
        //        ((HBox) (parentPane)).getChildren().add(functionContainer);
        //
        //        Parent traceNode = parentPane;
        //        while (traceNode != null) {
        //            addCheckMouseClickPosition(traceNode.getParent() , functionContainer);
        //            traceNode =  traceNode.getParent();
        inputTextArea.setText(inputTextArea.getText() + "rand(");
    }
}

//    public void addCheckMouseClickPosition(Node parent , Pane nodeToCheck) {
//        if (parent != null && nodeToCheck != null) {
//            parent.addEventHandler(MouseEvent.MOUSE_CLICKED , new EventHandler <MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    if (event.getTarget() != nodeToCheck) {
//                        double y;
//                        double n;
//                        double m;
//                        TextField functionName0 = (TextField) nodeToCheck.getChildren().get(0);
//                        TextField functionName2 = (TextField) nodeToCheck.getChildren().get(2);
//                        TextField functionName4 = (TextField) nodeToCheck.getChildren().get(4);
//                        try {
//                            y = Double.parseDouble(functionName0.getText() == "" ? "1" : functionName0.getText());
//                            n = Double.parseDouble(functionName2.getText());
//                            m = Double.parseDouble(functionName4.getText());
//                            if (!Double.isNaN(n)&&!Double.isNaN(m)) {
//                                if (PrimaryButton.tempOutputTextArea.getText().equals (TextHandler.numberFormatter(calculate(y , n, m)).toString())) {
//                                    return;
//                                }
//                                ;
//                                PrimaryButton.tempOutputTextArea.setText(TextHandler.numberFormatter(calculate(y , n, m
//                                        )).toString());
//                            }
//                        } catch (NumberFormatException e) {
//                        }
//                    }
//                }
//            });
//        }
//    }
//
//    public double calculate(Object... num) {
//        return (Double) num[0] * MathUtil.randInRange((Double) num[1], (Double) num[2], false);
//    }
//
//    public void setTextFieldWidth(TextField textField , double prefWidth) {
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
//}
