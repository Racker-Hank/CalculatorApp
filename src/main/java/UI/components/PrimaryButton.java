package UI.components;

import UI.UIConfig;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import mode.Function2;

import java.lang.reflect.Method;

public class PrimaryButton extends Button {
    public static String defaultStyle;
    public static String hoverStyle;
    public static HBox mainInputPane;
    public static TextArea tempOutputTextArea;

    //    public String name;
    public Function2 function;
    public Method addToAnchorPane;

    public static void setStyleString() {
        setStyleString(0 , null);
    }

    public static void setBorderColor(String color) {
        defaultStyle = defaultStyle.replace("-fx-border-color: " + UIConfig.colorLightGreen + ";" , "-fx-border-color: " + color + ";");
        hoverStyle = hoverStyle.replace("-fx-border-color: " + UIConfig.colorLightGreen + ";" , "-fx-border-color: " + color + ";");
    }

    public static void setStyleString(int fontSize , String borderColor) {
        fontSize = fontSize <= 0 ? UIConfig.fontSize : fontSize;
        borderColor = borderColor == null ? UIConfig.colorLightGreen : borderColor;
        defaultStyle = "-fx-background-color: #202020; " +
                "-fx-text-fill: white; " +
                "-fx-font-size:" + UIConfig.fontSize + "px; " +
                "-fx-font-weight: bold; " +
                "-fx-font-family:" + UIConfig.fontFamily + ";" +
                "-fx-cursor: hand; " +
                "-fx-border-color: " + borderColor + ";" +
                "-fx-border-width: 2px; " +
                "-fx-border-radius:" + UIConfig.borderRadius + "px;" +
                "-fx-background-radius:" + (UIConfig.borderRadius + 8) + "px;";
        hoverStyle = "-fx-background-color: #202020; " +
                "-fx-text-fill: white; " +
                "-fx-font-size:" + UIConfig.fontSize + "px; " +
                "-fx-font-weight: bold; " +
                "-fx-font-family:" + UIConfig.fontFamily + ";" +
                "-fx-cursor: hand; " +
                "-fx-border-color: " + borderColor + ";" +
                "-fx-border-width: 2px; " +
                "-fx-border-radius:" + UIConfig.borderRadius + "px;" +
                "-fx-background-radius:" + (UIConfig.borderRadius + 8) + "px;";
    }

    public PrimaryButton() {
        setStyleString();
        this.setStyle(defaultStyle);
        initializeButtonListener();
    }

    public PrimaryButton( int fontSize , String borderColor) {
        setStyleString(fontSize, borderColor);
        this.setStyle(defaultStyle);
        initializeButtonListener();
    }

    public PrimaryButton(Function2 function) {
        super(function.name);
        this.function = function;
        setStyleString();
        this.setStyle(defaultStyle);
//        this.function = function;
        initializeButtonListener();
    }

    public static Button toPrimaryButton(Button button) {
        setStyleString();
        button.setStyle(defaultStyle);
        return button;
    }

    public static Button toPrimaryButton(Button button , String borderColor) {
        return toPrimaryButton(button , 0 , borderColor);
    }

    public static Button toPrimaryButton(Button button , int fontSize , String borderColor) {
        setStyleString(fontSize , borderColor);
        button.setStyle(defaultStyle);
        return button;
    }

    public void initializeButtonListener() {
        setOnMousePressed(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent e) {
                if (e.getButton().equals(MouseButton.PRIMARY)) {
                    //                    setButtonPressedStyle();
                    function.addToAnchorPane(mainInputPane);
                }
            }

            ;
        });

        //        hover
        setOnMouseEntered(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent e) {
//                System.out.println(function.name);
            }

            ;
        });
    }
}
