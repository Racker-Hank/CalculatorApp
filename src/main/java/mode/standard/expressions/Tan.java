package mode.standard.expressions;

import UI.UIConfig;
import UI.components.PrimaryButton;
import inputHandler.MathUtil;
import inputHandler.TextHandler;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import mode.Command;
import mode.Function2;

import java.util.ArrayList;

public class Tan extends Function2 {
    public Tan() {
        this.name = "tan(x)";
        this.description = "Calculate tan of x°";
        initButton();
        this.command = new Command(this);
    }

    public void initButton() {
        this.button = new PrimaryButton(this);
    }

    public void addToTextArea(TextArea inputTextArea) {
//        HBox functionContainer = new HBox();
//        functionContainer.setSpacing(2);
//        String textFieldStyle = "-fx-font-size: 14pt;-fx-font-fill: #FFFFFF;-fx-padding: 0;";
//        TextField functionName0 = new TextField("");
//        functionName0.setStyle(textFieldStyle);
//        setTextFieldWidth(functionName0 , 8);
//        functionContainer.getChildren().add(functionName0);
//        TextField functionName1 = new TextField("tan(");
//        functionName1.setEditable(false);
//        setTextFieldWidth(functionName1 , -1);
//        functionName1.setStyle(textFieldStyle + "-fx-background-color: transparent;");
//        functionContainer.getChildren().add(functionName1);
//        TextField functionName2 = new TextField();
//        functionName2.setStyle(textFieldStyle);
//        setTextFieldWidth(functionName2 , -1);
//        functionContainer.getChildren().add(functionName2);
//        TextField functionName3 = new TextField(")");
//        functionName3.setStyle(textFieldStyle + "-fx-background-color: transparent;");
//        functionName3.setEditable(false);
//        setTextFieldWidth(functionName3 , -1);
//        functionContainer.getChildren().add(functionName3);
//        ((HBox) (parentPane)).getChildren().add(functionContainer);
//
//        Parent traceNode = parentPane;
//        while (traceNode != null) {
//            addCheckMouseClickPosition(traceNode.getParent() , functionContainer);
//            ArrayList<Node> allNodes = UIConfig.getAllNodes(traceNode);
//            for (Node node : allNodes) {
//                addCheckMouseClickPosition(traceNode , functionContainer);
//            }
//            traceNode =  traceNode.getParent();
//        }
        inputTextArea.setText(inputTextArea.getText() + "tan(");
    }

//    public void addCheckMouseClickPosition(Node parent , Pane nodeToCheck) {
//        if (parent != null && nodeToCheck != null) {
//            parent.addEventHandler(MouseEvent.MOUSE_CLICKED , new EventHandler <MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    if (event.getTarget() != nodeToCheck) {
//                        double y;
//                        double x;
//                        TextField functionName0 = (TextField) nodeToCheck.getChildren().get(0);
//                        TextField functionName2 = (TextField) nodeToCheck.getChildren().get(2);
//                        try {
//                            y = Double.parseDouble(functionName0.getText() == "" ? "1" : functionName0.getText());
//                            x = Double.parseDouble(functionName2.getText());
//                            if (!Double.isNaN(x)) {
//                                if (PrimaryButton.tempOutputTextArea.getText().equals (TextHandler.numberFormatter(calculate(y , x)).toString())) {
//                                    return;
//                                }
//                                ;
//                                PrimaryButton.tempOutputTextArea.setText(TextHandler.numberFormatter(calculate(y , x)).toString());
//                            }
//                        } catch (NumberFormatException e) {
//                        }
//                        System.out.println(event.getTarget());
//                    }
//                }
//            });
//        }
//    }
//
//    public double calculate(Object... num) {
//        return (Double) num[0] * MathUtil.tanDegrees((Double) num[1]);
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
}
