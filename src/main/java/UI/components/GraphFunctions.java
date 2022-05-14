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
    Map<Function, Color> functions = new HashMap<>();
    Button addFunction;
    Button drawGraph;

    public GraphFunctions(GraphController graphController) {
        super(8);
        addFunction = new Button("Add Function");
        drawGraph = new Button("Draw Graph");
        this.getChildren().add(new HBox(addFunction, drawGraph));
        addFunction.setOnAction(event -> this.getChildren().add(new Function(this)));
        drawGraph.setOnAction(event -> graphController.drawGraph());
        AnchorPane.setTopAnchor(this , 0d);
        AnchorPane.setRightAnchor(this , 0d);
        AnchorPane.setLeftAnchor(this , 0d);
    }

    public Map<Function, Color> getFunctions() {
        return functions;
    }
}

