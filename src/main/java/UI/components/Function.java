package UI.components;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import inputHandler.Expr;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Function extends GridPane {
    TextArea function = new TextArea("sin(x)");
    Button removeButton = new Button();
    Expr expr;
    Color color;

    Function(GraphFunctions graphFunctions) {
        super();
        color = Color.color(Math.random(), Math.random(), Math.random());
        function.setMaxHeight(50);
        GridPane.setHgrow(function, Priority.ALWAYS);
        function.setWrapText(true);
//            function.setPrefWidth(100);
        Label label = new Label("f(x) =");
        label.setStyle("-fx-text-fill: white; -fx-font-size: 16");
        label.setMinWidth(40);

//            removeButton.getStyleClass().add("pin-button");

        Tooltip tooltip = new Tooltip("Remove Function");
        tooltip.setStyle("-fx-font-family: System;" + "-fx-font-weight: bold;" + "-fx-font-size: " + 12 + "px;");
        Tooltip.install(removeButton , tooltip);
        FontAwesomeIcon icon = new FontAwesomeIcon();
        icon.setIcon(FontAwesomeIcons.MINUS);
        icon.setFill(Paint.valueOf("white"));
        icon.setSize("2em");
//            icon.setRotate(45);
        removeButton.setGraphic(icon);
        setPrefWidth(Control.USE_COMPUTED_SIZE);
        setPrefHeight(Control.USE_COMPUTED_SIZE);
        removeButton.getStyleClass().add("pin-button");

        expr = new Expr(function.getText());
        function.textProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("textfield changed from " + oldValue + " to " + newValue);
            graphFunctions.functions.remove(this);
            expr = new Expr(newValue);
            if (!graphFunctions.functions.containsKey(this)) {
                graphFunctions.functions.put(this, color);
            }
//            System.out.println(graphFunctions.functions);
        });
        if (!graphFunctions.functions.containsKey(this)) {
            graphFunctions.functions.put(this, color);
        }

        removeButton.setOnAction(event -> {
            graphFunctions.functions.remove(this);
            graphFunctions.getChildren().remove(this);
        });

//            this.getChildren().add(label);
//            this.getChildren().add(function);
//            this.getChildren().add(removeButton);
//            this.setAlignment(Pos.CENTER);
        setAlignment(Pos.CENTER_LEFT);
        this.add(new Circle(10, color), 0, 0);
        this.add(label,1,0);
        this.add(function, 2, 0);
        this.add(removeButton, 3, 0);
        this.getRowConstraints().add(0, new RowConstraints(Control.USE_COMPUTED_SIZE));
        setVgrow(function, Priority.NEVER);
        setVgrow(label, Priority.NEVER);
        setHgap(4);
    }

    public String toString() {
        return "Function{" +
                "expr=" + expr +
                ", color=" + color +
                '}';
    }
}
