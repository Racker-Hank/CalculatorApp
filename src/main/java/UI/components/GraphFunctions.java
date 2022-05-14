package UI.components;

import UI.Equation.GraphController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;
import java.util.Map;

public class GraphFunctions extends VBox {
    Map<Function, Color> functions = new HashMap<>();
    Button addButton;
    Button drawGraph;

    public GraphFunctions(GraphController graphController) {
        super(8);

        addButton = new Button();
        Tooltip tooltip = new Tooltip("Add Function");
        tooltip.setStyle("-fx-font-family: System;" + "-fx-font-weight: bold;" + "-fx-font-size: " + 12 + "px;");
        Tooltip.install(addButton , tooltip);
        FontAwesomeIcon icon = new FontAwesomeIcon();
        icon.setIcon(FontAwesomeIcons.PLUS);
        icon.setFill(Paint.valueOf("white"));
        icon.setSize("2em");
        addButton.setGraphic(icon);
        setPrefWidth(Control.USE_COMPUTED_SIZE);
        setPrefHeight(Control.USE_COMPUTED_SIZE);
        addButton.getStyleClass().add("pin-button");


        drawGraph = new Button();
        Tooltip tooltip2 = new Tooltip("Draw Graph");
        tooltip2.setStyle("-fx-font-family: System;" + "-fx-font-weight: bold;" + "-fx-font-size: " + 12 + "px;");
        Tooltip.install(drawGraph , tooltip2);
        FontAwesomeIcon icon2 = new FontAwesomeIcon();
        icon2.setIcon(FontAwesomeIcons.PENCIL);
        icon2.setFill(Paint.valueOf("white"));
        icon2.setSize("2em");
        drawGraph.setGraphic(icon2);
        setPrefWidth(Control.USE_COMPUTED_SIZE);
        setPrefHeight(Control.USE_COMPUTED_SIZE);
        drawGraph.getStyleClass().add("pin-button");

        this.getChildren().add(new HBox(addButton, drawGraph));
        addButton.setOnAction(event -> this.getChildren().add(new Function(this)));
        drawGraph.setOnAction(event -> graphController.drawGraph());
        AnchorPane.setTopAnchor(this , 0d);
        AnchorPane.setRightAnchor(this , 0d);
        AnchorPane.setLeftAnchor(this , 0d);
    }

    public Map<Function, Color> getFunctions() {
        return functions;
    }
}

