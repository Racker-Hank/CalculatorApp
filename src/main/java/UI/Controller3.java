package UI;

import UI.components.PrimaryButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller3 implements Initializable {
    private HashMap <TreeItem <String>, Pane> panes = new HashMap <>();
    private Pane visiblePane;

    @FXML
    private Label modeName;

    @FXML
    private TreeView treeView;

    @FXML
    private StackPane mainStackPane;

    //    @FXML
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

    //    @FXML
    private AnchorPane conversion;
    private AnchorPane lengthConversion;

    @FXML
    private AnchorPane financial;

    //    function buttons
    @FXML
    private VBox functionButtonsWrapper;

    @FXML
    private Button absButton;

    @FXML
    private Button combinationButton;

    @FXML
    private Button permutationButton;

    @FXML
    private Button rootButton;

    @FXML
    private Button sqrtButton;

    String treeItemStyle = "-fx-font-size:16px;  -fx-font-family: Noto Sans Math; " +
            "-fx-background-color: #000; -fx-text-fill: #fff;";

    @Override
    public void initialize(URL location , ResourceBundle resources) {
        try {
            this.standard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Standard.fxml")));
            this.lengthConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                    "/fxml/Conversion.fxml")));
            lengthConversion.setVisible(false);
            mainStackPane.getChildren().add(standard);
            mainStackPane.getChildren().add(lengthConversion);
            treeView.setStyle(treeItemStyle);
            treeView.getStyleClass().add("tree-view");
            TreeItem <String> root = new TreeItem <>("Root");

            TreeItem <String> standard = new TreeItem <>("Standard");
            //            System.out.println(this.standard.getId());
            panes.put(standard , this.standard);
            this.visiblePane = this.standard;
            root.getChildren().add(standard);

            TreeItem <String> equation = new TreeItem <>("Equation");
            TreeItem <String> variable = new TreeItem <>("Variable");
            TreeItem <String> graph = new TreeItem <>("Graph");
            equation.getChildren().addAll(variable , graph);
            panes.put(equation , this.equation);
            panes.put(variable , this.variable);
            panes.put(graph , this.graph);
            //            root.getChildren().add(equation);

            TreeItem <String> matrix = new TreeItem <>("Matrix");
            panes.put(matrix , this.matrix);
            //            root.getChildren().add(matrix);

            TreeItem <String> vector = new TreeItem <>("Vector");
            panes.put(vector , this.vector);
            //            root.getChildren().add(vector);

            TreeItem <String> conversion = new TreeItem <>("Conversion");
            TreeItem <String> lengthConversion = new TreeItem <>("Length Conversion");
            panes.put(conversion , this.conversion);
            panes.put(lengthConversion , this.lengthConversion);
            conversion.getChildren().add(lengthConversion);
            root.getChildren().add(conversion);

            TreeItem <String> financial = new TreeItem <>("Financial");
            panes.put(financial , this.financial);
            //            root.getChildren().add(financial);

            treeView.setRoot(root);
            treeView.setShowRoot(false);
            treeView.getSelectionModel().select(standard);

            //            try {
            //                AnchorPane test = (AnchorPane) FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Standard" +
            //                        ".fxml")));
            //                AnchorPane conversionPane = (AnchorPane) FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
            //                        "/fxml" +
            //                                "/Conversion" +
            //                                ".fxml")));
            //                //            mainStackPane.getChildren().add(test);
            //                //            test.setVisible(false);
            //                //            mainStackPane.getChildren().add(conversionPane);
            //                //            System.out.println(test.getId());
            //                //            System.out.println(test.getParent());
            //            } catch (IOException e) {
            //                e.printStackTrace();
            //            }
            //        Controller2 controller2 = new Controller2(mainStackPane);
            //        addFunctionButtons();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectItem() {
        if (treeView.getSelectionModel().getSelectedItem() != null) {
            TreeItem <String> item = (TreeItem <String>) treeView.getSelectionModel().getSelectedItem();
            try {
                if (panes.get(item) != null) {
                    visiblePane.setVisible(false);
                    visiblePane = panes.get(item);
                    visiblePane.setVisible(true);
                    modeName.setText(item.getValue());
                }
                //            mainStackPane.getChildren().clear();
                //                mainStackPane.getChildren().add(visiblePane);
                //            System.out.println(item.getValue());
            } catch (Exception e) {
                //                e.printStackTrace();
            }
        }
    }

    public void addFunctionButtons() {
        //        HBox functionButtonsContainer = new HBox();
        //        functionButtonsContainer.setSpacing(8);
        //        functionButtonsContainer.setAlignment(Pos.CENTER);
        ////        PrimaryButton sin = new PrimaryButton(Expressions.Sin);
        //        PrimaryButton cos = new PrimaryButton();
        //        cos.setText("cos");
        //        functionButtonsContainer.getChildren().add(cos);
        ////        functionButtonsContainer.getChildren().add(cos);
        //        functionButtonsWrapper.getChildren().add(functionButtonsContainer);

        for (Node hBox : functionButtonsWrapper.getChildren()) {
            //            for (Node button : ((HBox) hBox).getChildren()) {
            for (int i = 0; i < ((HBox) hBox).getChildren().size(); i++) {
                Button button = (Button) (((HBox) hBox).getChildren().get(i));
                //                button.setStyle(PrimaryButton.style);
                button = new PrimaryButton().toPrimaryButton(button);
            }
        }
    }
}
