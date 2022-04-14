package mode.standard.expressions;

import UI.Controller2;
import UI.components.InputPane;
import UI.components.PrimaryButton;
import inputHandler.MathUtil;
import inputHandler.TextHandler;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
    }

    public void addToAnchorPane(Parent parent) {
        HBox functionContainer = new HBox();
        functionContainer.setSpacing(0);
        TextField functionName1 = new TextField("sin(");
        functionName1.setPrefWidth(14 * functionName1.getText().length() + 4);
        functionName1.setStyle("-fx-font-size: 14pt;-fx-font-fill: #FFFFFF");
        functionContainer.getChildren().add(functionName1);
        TextField functionName2 = new TextField();
        functionName2.setStyle("-fx-font-size: 14pt;-fx-font-fill: #FFFFFF");
        //        functionName2.setPrefWidth(14*functionName2.getText().length()+4);
        functionName2.setPrefWidth(14); // Set the width
        functionName2.textProperty().addListener((ov , prevText , currText) -> {
            // Do this in a Platform.runLater because of Textfield has no padding at first time and so on
            Platform.runLater(() -> {
                Text text = new Text(currText);
                text.setFont(functionName2.getFont()); // Set the same font, so the size is the same
                double width = text.getLayoutBounds().getWidth() // This big is the Text in the TextField
                        + functionName2.getPadding().getLeft() + functionName2.getPadding().getRight() // Add the padding of the TextField
                        + 2d; // Add some spacing
                functionName2.setPrefWidth(width); // Set the width
                functionName2.positionCaret(functionName2.getCaretPosition()); // If you remove this line, it flashes a little bit
            });
        });
        functionName2.setMinWidth(Region.USE_PREF_SIZE);
        functionName2.setMaxWidth(Region.USE_PREF_SIZE);
        functionContainer.getChildren().add(functionName2);
        TextField functionName3 = new TextField(")");
        functionName3.setStyle("-fx-font-size: 14pt;-fx-font-fill: #FFFFFF");
        functionName3.setPrefWidth(14 * 2);
        functionContainer.getChildren().add(functionName3);
        HBox.setHgrow(functionName2 , Priority.NEVER);
        HBox.setHgrow(functionName1 , Priority.NEVER);
        HBox.setHgrow(functionName3 , Priority.NEVER);
        HBox.setHgrow(functionContainer , Priority.NEVER);
        //        InputPane inputPane = new InputPane();
        //        functionContainer.getChildren().add(inputPane);
        ((HBox) (parent)).getChildren().add(functionContainer);

        parent.getParent().addEventHandler(MouseEvent.MOUSE_CLICKED , new EventHandler <MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getTarget() != functionContainer) {
                    double x = 0;
                    try {
                        x = Double.parseDouble(functionName2.getText());
                        if (!Double.isNaN(x)) {
                            //                        System.out.println(MathUtil.sinDegrees(x));
                            PrimaryButton.tempOutputTextArea.setText(TextHandler.numberFormatter(MathUtil.sinDegrees(x)) +
                                    "");
                        }
                    } catch (NumberFormatException e) {
                        //                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
