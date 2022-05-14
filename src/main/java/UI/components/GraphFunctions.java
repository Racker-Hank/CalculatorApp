package UI.components;

import UI.Equation.GraphController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import inputHandler.Expr;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Map;

public class GraphFunctions extends VBox {
    Map<Expr, Color> functions = new HashMap<>();
    Button addFunction;
    Button drawGraph;

    public GraphFunctions(GraphController graphController) {
        super(8);
        addFunction = new Button("Add Function");
        drawGraph = new Button("Draw Graph");
        this.getChildren().add(new HBox(addFunction, drawGraph));
        addFunction.setOnAction(event -> this.getChildren().add(new Function()));
        drawGraph.setOnAction(event -> graphController.drawGraph());
        AnchorPane.setTopAnchor(this , 0d);
        AnchorPane.setRightAnchor(this , 0d);
        AnchorPane.setLeftAnchor(this , 0d);

    }

    public Map<Expr, Color> getFunctions() {
        return functions;
    }

    public void update() {

    }

    private class Function extends GridPane {
        TextArea function = new TextArea("sin(x)");
        Button removeButton = new Button();
        Expr expr;
        Color color;
        boolean hasDrawn = false;

        Function() {
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
//                System.out.println("textfield changed from " + oldValue + " to " + newValue);
                Expr tmp = new Expr(newValue);
                //delete old function
                functions.remove(oldValue);
                functions.put(tmp, color);
                expr = tmp;
            });
            functions.put(expr, color);

            removeButton.setOnAction(event -> {
                functions.remove(expr);
                GraphFunctions.this.getChildren().remove(this);
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
    }
}

