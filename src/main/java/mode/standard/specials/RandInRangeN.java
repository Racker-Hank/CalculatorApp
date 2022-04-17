package mode.standard.specials;

import UI.UIConfig;
import UI.components.InputPane;
import UI.components.PrimaryButton;
import inputHandler.MathUtil;
import inputHandler.TextHandler;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import mode.Command;
import mode.Function2;

public class RandInRangeN extends Function2 {
    public RandInRangeN() {
        this.name = "rand(n)";
        this.description = "Generates a random number between 0 and n";
        initButton();
        this.command = new Command(this);
    }

    public void initButton() {
        this.button = new PrimaryButton(this,UIConfig.colorPink);
    }

    public void addToAnchorPane(Pane parentPane) {
        HBox functionContainer = new HBox();
        functionContainer.setSpacing(2);
        functionContainer.setAlignment(Pos.CENTER_LEFT);
        functionContainer.setFillHeight(false);
        String textFieldStyle = "-fx-font-family: Noto Sans Math;-fx-font-size: 14pt;-fx-font-fill: #FFFFFF;" +
                "-fx-padding: " +
                "0;";
        InputPane functionName0Container = new InputPane();
        //TextField functionName0 = new TextField("");
        functionName0Container.defaultTextField.setText("");
//        functionName0.setStyle(textFieldStyle);
//        setTextFieldWidth(functionName0 , 8);
//        functionContainer.getChildren().add(functionName0);
        functionContainer.getChildren().add(functionName0Container);
        TextField functionName1 = new TextField("rand(");
        functionName1.setEditable(false);
        setTextFieldWidth(functionName1 , 44);
        functionName1.setStyle(textFieldStyle + "-fx-background-color: transparent;");
        functionContainer.getChildren().add(functionName1);

        TextField functionName2 = new TextField();
        functionName2.setStyle(textFieldStyle);
        setTextFieldWidth(functionName2 , -1);
        functionContainer.getChildren().add(functionName2);

        TextField functionName5 = new TextField(")");
        functionName5.setStyle(textFieldStyle + "-fx-background-color: transparent;");
        functionName5.setEditable(false);
        setTextFieldWidth(functionName5 , -1);
        functionContainer.getChildren().add(functionName5);

        InputPane inputPane = new InputPane();
        functionContainer.getChildren().add(inputPane);
        ((HBox) (parentPane)).getChildren().add(functionContainer);

        Parent traceNode = parentPane;
        while (traceNode != null) {
            addCheckMouseClickPosition(traceNode.getParent() , functionContainer);
            traceNode =  traceNode.getParent();
        }
    }

    public void addCheckMouseClickPosition(Node parent , Pane nodeToCheck) {
        if (parent != null && nodeToCheck != null) {
            parent.addEventHandler(MouseEvent.MOUSE_CLICKED , new EventHandler <MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getTarget() != nodeToCheck) {
                        double y;
                        double n;
                        TextField functionName0 = (TextField) nodeToCheck.getChildren().get(0);
                        TextField functionName2 = (TextField) nodeToCheck.getChildren().get(2);
                        try {
                            y = Double.parseDouble(functionName0.getText() == "" ? "1" : functionName0.getText());
                            n = Double.parseDouble(functionName2.getText());
                            if (!Double.isNaN(n)) {
                                if (PrimaryButton.tempOutputTextArea.getText().equals (TextHandler.numberFormatter(calculate(y , n)).toString())) {
                                    return;
                                }
                                ;
                                PrimaryButton.tempOutputTextArea.setText(TextHandler.numberFormatter(calculate(y , n
                                        )).toString());
                            }
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            });
        }
    }

    public double calculate(Object... num) {
        return (Double) num[0] * MathUtil.randInRange((Double) num[1]);
    }

    public void setTextFieldWidth(TextField textField , double prefWidth) {
        textField.setPrefWidth(prefWidth > 0 ? prefWidth : Math.max(UIConfig.fontSize ,
                UIConfig.fontSize * (textField.getText().length() - 2) + textField.getPadding().getLeft() + textField.getPadding().getRight() + 4d));
        textField.textProperty().addListener((ov , prevText , currText) -> {
            // Do this in a Platform.runLater because of Textfield has no padding at first time and so on
            Platform.runLater(() -> {
                Text text = new Text(currText);
                text.setFont(textField.getFont()); // Set the same font, so the size is the same
                double width = text.getLayoutBounds().getWidth() // This big is the Text in the TextField
                        + textField.getPadding().getLeft() + textField.getPadding().getRight() // Add the padding of the
                        // TextField
                        + 2d; // Add some spacing
                textField.setPrefWidth(width); // Set the width
                textField.positionCaret(textField.getCaretPosition()); // If you remove this line, it flashes a little bit
            });
        });
        textField.setMinWidth(Region.USE_PREF_SIZE);
        textField.setMaxWidth(Region.USE_PREF_SIZE);
    }
}
