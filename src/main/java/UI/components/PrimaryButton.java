package UI.components;

import UI.UIConfig;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import mode.Function;

public class PrimaryButton extends Button {
    public static String style =
            "-fx-background-color: #202020; " +
                    "-fx-text-fill: white; " +
                    "-fx-font-size:" + UIConfig.fontSize + "px; " +
                    "-fx-font-weight: bold; " +
                    "-fx-font-family:" + UIConfig.fontFamily + ";" +
                    "-fx-border-color: "+ UIConfig.colorLightGreen + ";" +
                    "-fx-border-width: 2px; " +
                    "-fx-border-radius:" + UIConfig.borderRadius + "px;"+
                    "-fx-background-radius:" + (UIConfig.borderRadius + 8) + "px;";
//    public String name;
    public Function function;

    public PrimaryButton() {
        this.setStyle(style);
    }

    public static Button toPrimaryButton(Button button) {
        button.setStyle(style);
        return button;
    }

    public PrimaryButton(Function function) {
        super(function.name);
        this.setStyle(style);
        this.function = function;
        initializeButtonListener();
    }

    public void initializeButtonListener() {
        setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                if (e.getButton().equals(MouseButton.PRIMARY)) {
//                    setButtonPressedStyle();
                }
            };
        });

//        hover
        setOnMouseEntered(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent e) {
                System.out.println(function.name);
            };
        });
    }
}
