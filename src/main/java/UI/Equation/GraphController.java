package UI.Equation;

import UI.components.GraphCanvas;
import UI.components.GraphFunctions;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;


public class GraphController {
    @FXML
    private BorderPane graphPane;

    GraphCanvas graphCanvas;

    GraphFunctions graphFunctions;

    public void initialize() {
        graphFunctions = new GraphFunctions(this);
        graphCanvas = new GraphCanvas(graphFunctions.getFunctions());
        graphPane.setRight(graphFunctions);
        graphPane.setCenter(graphCanvas);
    }

    public void drawGraph() {
        graphCanvas.setFunctions(graphFunctions.getFunctions());
//        System.out.println(graphFunctions.getFunctions());
//        System.out.println(graphCanvas.getFunctions());

        graphCanvas.draw();
    }
}
