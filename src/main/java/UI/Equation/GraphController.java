package UI.Equation;

import UI.components.GraphCanvas;
import UI.components.GraphFunctions;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;


public class GraphController {
    @FXML
    private AnchorPane graphPane;

    GraphCanvas graphCanvas;

    public static GraphFunctions graphFunctions;

    public static ScrollPane graphScrollPane;

    public void initialize() {
        graphFunctions = new GraphFunctions(this);
        graphScrollPane = new ScrollPane();
        graphScrollPane.setContent(graphFunctions);
        AnchorPane.setTopAnchor(graphScrollPane, 0.0);
        AnchorPane.setBottomAnchor(graphScrollPane, 0.0);
        AnchorPane.setLeftAnchor(graphScrollPane, 0.0);
        AnchorPane.setRightAnchor(graphScrollPane, 0.0);
        graphScrollPane.setPrefWidth(Control.USE_COMPUTED_SIZE);
        graphScrollPane.setPrefHeight(Control.USE_COMPUTED_SIZE);
        graphScrollPane.setStyle("-fx-background-color: #202020;-fx-background:#202020");
        graphFunctions.prefWidthProperty().bind(graphScrollPane.widthProperty());

        graphScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        graphCanvas = new GraphCanvas(graphFunctions.getFunctions());
        graphPane.getChildren().add(graphCanvas);
    }

    public void drawGraph() {
        graphCanvas.setFunctions(graphFunctions.getFunctions());
        System.out.println(graphFunctions.getFunctions().toString());
//        System.out.println(graphCanvas.getFunctions());

        graphCanvas.draw();
    }
}
