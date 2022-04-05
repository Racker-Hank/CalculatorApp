import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private HashMap<TreeItem<String>, Pane> panes = new HashMap<>();
    private Pane visiblePane;
    @FXML
    private TreeView treeView;

    @FXML
    private AnchorPane standard;

    @FXML
    private AnchorPane equation;

    @FXML
    private AnchorPane variable;

    @FXML
    private AnchorPane graph;

    @FXML
    private AnchorPane matrix;

    @FXML
    private AnchorPane vector;

    @FXML
    private AnchorPane conversion;

    @FXML
    private AnchorPane financial;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> root = new TreeItem<>("Root");

        TreeItem<String> standard = new TreeItem<>("Standard");
        panes.put(standard, this.standard);
        visiblePane = this.standard;
        root.getChildren().add(standard);

        TreeItem<String> equation = new TreeItem<>("Equation");
        TreeItem<String> variable = new TreeItem<>("Variable");
        TreeItem<String> graph = new TreeItem<>("Graph");
        equation.getChildren().addAll(variable, graph);
        panes.put(equation, this.equation);
        panes.put(variable, this.variable);
        panes.put(graph, this.graph);
        root.getChildren().add(equation);

        TreeItem<String> matrix = new TreeItem<>("Matrix");
        panes.put(matrix, this.matrix);
        root.getChildren().add(matrix);

        TreeItem<String> vector = new TreeItem<>("Vector");
        panes.put(vector, this.vector);
        root.getChildren().add(vector);

        TreeItem<String> conversion = new TreeItem<>("Conversion");
        panes.put(conversion, this.conversion);
        root.getChildren().add(conversion);

        TreeItem<String> financial = new TreeItem<>("Financial");
        panes.put(financial, this.financial);
        root.getChildren().add(financial);

        treeView.setRoot(root);
        treeView.setShowRoot(false);
    }

    public void selectItem() {
        TreeItem<String> item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
        System.out.println(item.getValue());
        visiblePane.setVisible(false);
        visiblePane = panes.get(item);
        visiblePane.setVisible(true);
    }
}
