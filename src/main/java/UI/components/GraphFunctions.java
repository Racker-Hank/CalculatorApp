package UI.components;

import UI.Equation.GraphController;
import inputHandler.Expr;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class GraphFunctions extends VBox {
    List<Expr> functions = new ArrayList<>();
    Button addFunction;
    Button drawGraph;

    public GraphFunctions(GraphController graphController) {
        addFunction = new Button("Add Function");
        drawGraph = new Button("Draw Graph");
        this.getChildren().add(new HBox(addFunction, drawGraph));
        addFunction.setOnAction(event -> this.getChildren().add(new Function()));
        drawGraph.setOnAction(event -> graphController.drawGraph());
    }

    public List<Expr> getFunctions() {
        return functions;
    }

    private class Function extends HBox {
        TextField function = new TextField("sin(x)");
        Button removeFunction = new Button("-");
        Expr expr;
        Function() {
            super();
            Label label = new Label("f(x) =");
            label.setStyle("-fx-text-fill: white;");

            expr = new Expr(function.getText());
            function.textProperty().addListener((observable, oldValue, newValue) -> {
//                System.out.println("textfield changed from " + oldValue + " to " + newValue);
                Expr tmp = new Expr(newValue);
                functions.set(functions.indexOf(expr), tmp);
                expr = tmp;
            });
            functions.add(expr);

            removeFunction.setOnAction(event -> {
                functions.remove(expr);
                GraphFunctions.this.getChildren().remove(this);
            });

            this.getChildren().add(label);
            this.getChildren().add(function);
            this.getChildren().add(removeFunction);
            this.setAlignment(Pos.CENTER);
        }
    }
}

