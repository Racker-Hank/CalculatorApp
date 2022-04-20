package UI.components;

import UI.UIConfig;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import mode.Function2;

import java.lang.reflect.Method;

public class PrimaryButton extends Button {
    public String defaultStyle;
    public String hoverStyle;
    public String activeStyle;
    public String inactiveStyle;
    public boolean isActive;
    public static HBox mainInputPane;
    public static TextArea tempOutputTextArea;
    public static double tooltipDelay = 0.5;

    //    public String name;
    public Function2 function;
    public String color;
    public Method addToAnchorPane;
    public Tooltip tooltip;

    public void setStyleString() {
        setStyleString(0 , null);
    }

    public void setColor(String color) {
        defaultStyle = defaultStyle.replace("-fx-border-color: " + UIConfig.colorPrimaryGreen + ";" , "-fx-border-color: " + color + ";");
//        hoverStyle = hoverStyle.replace("-fx-text-fill: " + UIConfig.colorPrimaryGreen + ";" , "-fx-text-fill: " + color + ";");
//        System.out.println(hoverStyle.contains("-fx-text-fill: " + UIConfig.colorPrimaryGreen + ";"));
        hoverStyle = hoverStyle.replace("-fx-border-color: " + UIConfig.colorPrimaryGreen + ";" , "-fx-border-color: " + color + ";");
    }

    public void setStyleString(int fontSize , String borderColor) {
        fontSize = fontSize <= 0 ? UIConfig.fontSize : fontSize;
        color = borderColor == null ? UIConfig.colorPrimaryGreen : borderColor;
        defaultStyle = "-fx-background-color: #202020; " +
                "-fx-text-fill: white; " +
                "-fx-font-size:" + UIConfig.fontSize + "px; " +
                "-fx-font-weight: bold; " +
                "-fx-font-family:" + UIConfig.fontFamily + ";" +
                "-fx-cursor: hand; " +
                //                "-fx-padding: 4 16; " +
                "-fx-border-color: " + color + ";" +
                "-fx-border-width: 2px; " +
                "-fx-border-radius:" + UIConfig.borderRadius + "px;" +
                "-fx-background-insets:" + 1 + "px;" +
                "-fx-background-radius:" + (UIConfig.borderRadius + 8) + "px;";
        hoverStyle = "-fx-background-color: #202020; " +
                "-fx-text-fill:" + color + ";" +
                "-fx-font-size:" + UIConfig.fontSize + "px; " +
                "-fx-font-weight: bold; " +
                "-fx-font-family:" + UIConfig.fontFamily + ";" +
                "-fx-cursor: hand; " +
                //                "-fx-padding: 4 24; " +
                "-fx-border-color: " + color + ";" +
                "-fx-border-width: 2px; " +
                "-fx-border-radius:" + UIConfig.borderRadius + "px;" +
                "-fx-background-insets:" + 1 + "px;" +
                "-fx-background-radius:" + (UIConfig.borderRadius + 8) + "px;";
        activeStyle = defaultStyle.replace("-fx-background-color: #202020;" , "-fx-background-color:"+ color +";");
        inactiveStyle = defaultStyle.replace("-fx-text-fill: white; " , "-fx-text-fill: " + UIConfig.colorInactiveGrey +";");
    }

    public PrimaryButton() {
        setStyleString();
        this.setStyle(defaultStyle);
        initializeButtonListener();
    }

    public PrimaryButton(int fontSize , String borderColor) {
        setStyleString(fontSize , borderColor);
        this.setStyle(defaultStyle);
        initializeButtonListener();
    }

    public PrimaryButton(Function2 function) {
        super(function.name);
        this.function = function;
        tooltip = new Tooltip(function.description);
        this.setTooltip(tooltip);
        tooltip.setShowDelay(Duration.seconds(tooltipDelay));
        tooltip.setHideDelay(Duration.seconds(0));
        setStyleString();
        //        color = defaultStyle.
        this.setStyle(defaultStyle);
        initializeButtonListener();
    }

    public PrimaryButton(Function2 function , String color) {
        super(function.name);
        this.function = function;
        this.color = color;
        tooltip = new Tooltip(function.description);
        this.setTooltip(tooltip);
        tooltip.setShowDelay(Duration.seconds(tooltipDelay));
        tooltip.setHideDelay(Duration.seconds(0));
        setStyleString(0, color);
//        setColor(color);
        //        color = defaultStyle.
        this.setStyle(defaultStyle);
        initializeButtonListener();
    }

    public Button toPrimaryButton(Button button) {
        setStyleString();
        PrimaryButton primaryButton = (PrimaryButton) button;
        button.setStyle(defaultStyle);
        return primaryButton;
    }

    public Button toPrimaryButton(Button button , String borderColor) {
        return toPrimaryButton(button , 0 , borderColor);
    }

    public Button toPrimaryButton(Button button , int fontSize , String borderColor) {
        setStyleString(fontSize , borderColor);
        PrimaryButton primaryButton = (PrimaryButton) button;
        button.setStyle(defaultStyle);
        return primaryButton;
    }

    public void initializeButtonListener() {
        if (function != null) {
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
                    //                Tooltip tooltip = new Tooltip(function.description);
                    //                Tooltip.install(PrimaryButton.this, tooltip);
                    function.button.setStyle(hoverStyle);
                }

                ;
            });
            setOnMouseExited(new EventHandler <MouseEvent>() {
                public void handle(MouseEvent e) {
                    function.button.setStyle(defaultStyle);
                }

                ;
            });
        }
    }
}
