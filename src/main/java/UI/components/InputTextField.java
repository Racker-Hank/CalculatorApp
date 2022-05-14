package UI.components;

import UI.UIConfig;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class InputTextField extends TextField {
    String textFieldStyle = "-fx-font-size: " + 14 + ";"
//            + "-fx-background-color:transparent;"
//            + "-fx-border-color: green;"
//            + "-fx-border-size: 1px;"
            ;

    public InputTextField() {
        this.setStyle(textFieldStyle);
        //        this.setFont(Font.font("Noto Sans Math", 14));
        this.setAlignment(Pos.CENTER);
        //        System.out.println(this.getStyle());
        setTextFieldWidth(this , 0);
    }

    public void setTextFieldWidth(TextField textField , double prefWidth) {
        textField.setPrefWidth(prefWidth > 0 ? prefWidth : Math.max(UIConfig.fontSize ,
                UIConfig.fontSize * (textField.getText().length()) + textField.getPadding().getLeft() + textField.getPadding().getRight() + 4d));
        textField.textProperty().addListener((ov , prevText , currText) -> {
            // Do this in a Platform.runLater because of Textfield has no padding at first time and so on
            Platform.runLater(() -> {
//                System.out.println(currText + "abcxyz");
                Text text = new Text(currText);
//                System.out.println(text.getText());
                text.setFont(textField.getFont()); // Set the same font, so the size is the same
                double width = text.getLayoutBounds().getWidth() // This big is the Text in the TextField
                        + textField.getPadding().getLeft() + textField.getPadding().getRight() // Add the padding of the
                        // TextField
                        + 4d; // Add some spacing
                textField.setPrefWidth(width); // Set the width
                // Set the width of parent
//                if (textField.getParent() != null) {
//                    ((InputPane) textField.getParent()).setPrefWidth(width);
//                }
//                if (prevText.isEmpty() || currText.isEmpty()) {
//                    textField.setPrefWidth(UIConfig.fontSize);
//                }
                textField.positionCaret(textField.getCaretPosition()); // If you remove this line, it flashes a little bit
            });
        });
        textField.setMinWidth(Region.USE_PREF_SIZE);
        textField.setMaxWidth(Region.USE_PREF_SIZE);
    }
}
