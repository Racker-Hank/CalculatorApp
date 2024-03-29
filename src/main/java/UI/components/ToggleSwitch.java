package UI.components;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class ToggleSwitch extends HBox {

    private final Label label = new Label();
    private final Button button = new Button();

    private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty switchOnProperty() { return switchedOn; }
    String TRUESTRING = "DEG";
    String FALSESTRING = "RAD";

    private void init() {

        label.setText(FALSESTRING);

        getChildren().addAll(label, button);
        button.setOnAction((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        label.setOnMouseClicked((e) -> {
            switchedOn.set(!switchedOn.get());
        });
        setStyle();
        bindProperties();
    }

    private void setStyle() {
        //Default Width
        setWidth(80);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-background-color: red; -fx-text-fill:white;-fx-font-weight: bold; -fx-background-radius: " +
                "4;-fx-cursor: hand;");
        setAlignment(Pos.CENTER_LEFT);
        button.setStyle("-fx-background-color:white; -fx-cursor: hand;");
    }

    private void bindProperties() {
        label.prefWidthProperty().bind(widthProperty().divide(2));
        label.minWidthProperty().bind(widthProperty().divide(2));
        label.prefHeightProperty().bind(heightProperty());
        button.prefWidthProperty().bind(widthProperty().divide(2));
        button.minWidthProperty().bind(widthProperty().divide(2));
        button.prefHeightProperty().bind(heightProperty());
    }

    public ToggleSwitch() {
        init();
        switchedOn.addListener((a,b,c) -> {
            if (c) {
                label.setText(TRUESTRING);
                label.setStyle("-fx-background-color: green;-fx-text-fill: white;-fx-background-radius: 4;-fx-cursor:" +
                        " " +
                        "hand;-fx-font-weight: bold;");
                label.toFront();
            }
            else {
                label.setText(FALSESTRING);
                label.setStyle("-fx-background-color: red;-fx-text-fill: white;-fx-font-weight: bold; " +
                        "-fx-background-radius: 4;-fx-cursor: hand;");
                button.toFront();
            }
        });
    }
}
