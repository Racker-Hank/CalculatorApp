package UI.components;

import UI.UIConfig;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class InputTextField extends TextField {
    String textfieldStyle;

    public InputTextField() {
        setStyle(textfieldStyle);
        setTextFieldWidth(this, 0);
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
