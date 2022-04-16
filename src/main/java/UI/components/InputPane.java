package UI.components;


import UI.UIConfig;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class InputPane extends AnchorPane {
    public InputTextField defaultTextField;

    public InputPane() {
        defaultTextField = new InputTextField();
        this.getChildren().add(defaultTextField);
        initKeyHandler();
    }

    public void initKeyHandler() {
        defaultTextField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCharacter().equals("/")) {
                    convertToFraction();
                }
            }
        });
    }

    private void convertToFraction() {
        VBox fractionContainer = new VBox(2);
        fractionContainer.setAlignment(Pos.CENTER);
        fractionContainer.setFillWidth(true);
        InputPane numeratorContainer = new InputPane();
        String numeratorText = defaultTextField.getText().substring(0, defaultTextField.getText().indexOf("/"));
        numeratorContainer.defaultTextField.setText(numeratorText);
        fractionContainer.getChildren().add(numeratorContainer);

        Rectangle rec = new Rectangle(1.5  * this.getWidth(), 2, Color.web(UIConfig.colorYellow));
        fractionContainer.getChildren().add(rec);

        InputPane denominatorContainer = new InputPane();
        fractionContainer.getChildren().add(denominatorContainer);

        this.getChildren().clear();
        this.setHeight(2.25 * defaultTextField.getHeight());
        this.setWidth(1.5 * defaultTextField.getWidth());
        this.getChildren().add(fractionContainer);
    }
}
