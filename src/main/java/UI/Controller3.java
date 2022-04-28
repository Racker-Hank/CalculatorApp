package UI;

import UI.components.PrimaryButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

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

    @FXML
    private SplitPane splitPane;

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
    private AnchorPane areaConversion;

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

    @FXML
    private Button resizeLeft;

    @FXML
    private Button resizeRight;

    @FXML
    private FontAwesomeIcon resizeLeftIcon;

    @FXML
    private FontAwesomeIcon resizeRightIcon;

    String treeItemStyle = "-fx-font-size:16px;  -fx-font-family: Noto Sans Math; " +
            "-fx-background-color: #000; -fx-text-fill: #fff;";


    @FXML
    void clickToResizeLeft(MouseEvent event) {
        double dividerPositions1 = splitPane.getDividerPositions()[0];
        if (dividerPositions1 < 0.004) {
                animatedSplitPane(0, 0.21);
                resizeLeftIcon.setGlyphName("ANGLE_DOUBLE_LEFT");
        }
        else {
            animatedSplitPane(0, 0);
            resizeLeftIcon.setGlyphName("ANGLE_DOUBLE_RIGHT");
        }
    }

    @FXML
    void clickToResizeRight(MouseEvent event) {
        double dividerPositions2 = splitPane.getDividerPositions()[1];
            if (dividerPositions2 > 0.99) {
                animatedSplitPane(1, 0.76);
                resizeRightIcon.setGlyphName("ANGLE_DOUBLE_RIGHT");
            }
            else {
                animatedSplitPane(1, 1);
                resizeRightIcon.setGlyphName("ANGLE_DOUBLE_LEFT");
            }
    }


    @Override
    public void initialize(URL location , ResourceBundle resources) {
        //        try {
        loadPanes();

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
        TreeItem <String> areaConversion = new TreeItem <>("Area Conversion");
        panes.put(conversion , this.conversion);
        panes.put(lengthConversion , this.lengthConversion);
        panes.put(areaConversion , this.areaConversion);
        conversion.getChildren().add(lengthConversion);
        conversion.getChildren().add(areaConversion);
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
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
    }

    public void loadPanes() {
        try {
            this.standard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Standard.fxml")));
            this.lengthConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion/LengthConversion.fxml")));
            this.areaConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/AreaConversion.fxml")));

            mainStackPane.getChildren().add(standard);
            mainStackPane.getChildren().add(lengthConversion);
            mainStackPane.getChildren().add(areaConversion);

            for (int i = 1; i < mainStackPane.getChildren().size(); i++) {
                mainStackPane.getChildren().get(i).setVisible(false);
            }
        } catch (IOException e) {
            //            e.printStackTrace();
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

    public void animatedSplitPane (int dividerPositions , double position) {
        KeyValue keyValue = new KeyValue(splitPane.getDividers().get(dividerPositions).positionProperty(), position);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), keyValue));
        timeline.play();
    }
}
