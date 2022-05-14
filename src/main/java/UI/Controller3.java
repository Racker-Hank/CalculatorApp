package UI;

import UI.Equation.GraphController;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;
import mode.standard.Standard;

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

    @FXML
    private AnchorPane topRightPane;

    //    @FXML
    private AnchorPane standard;

    @FXML
    private AnchorPane equation;
    private AnchorPane firstDegree;
    private AnchorPane secondDegree;
    private AnchorPane graph;

    @FXML
    private AnchorPane variable;

    @FXML
    private AnchorPane matrix;

    @FXML
    private AnchorPane vector;

    //    @FXML
    private AnchorPane conversion;
    private AnchorPane lengthConversion;
    private AnchorPane areaConversion;
    private AnchorPane volumeConversion;
    private AnchorPane speedConversion;
    private AnchorPane dataConversion;
    private AnchorPane energyConversion;
    private AnchorPane powerConversion;
    private AnchorPane pressureConversion;
    private AnchorPane timeConversion;
    private AnchorPane weightConversion;

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

    @Override
    public void initialize(URL location , ResourceBundle resources) {
        //        try {
        loadPanes();
        loadTreeView();
        splitPaneListener();
        initTopRightPane();

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
        //        StandardController controller2 = new StandardController(mainStackPane);
        //        addFunctionButtons();
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
    }

    public void loadPanes() {
        try {
            this.standard = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Standard.fxml")));

            //            Equation
            this.firstDegree = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Equation/FirstDegreeEquation.fxml")));
            this.secondDegree = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Equation" +
                    "/SecondDegreeEquation.fxml")));
            this.graph = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Equation/Graph.fxml")));

            //            Conversion
            this.lengthConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion/LengthConversion.fxml")));
            this.areaConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion/AreaConversion.fxml")));
            this.volumeConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/VolumeConversion.fxml")));
            this.speedConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/SpeedConversion.fxml")));
            this.dataConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/DataConversion.fxml")));
            this.energyConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/EnergyConversion.fxml")));
            this.powerConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/PowerConversion.fxml")));
            this.pressureConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/PressureConversion.fxml")));
            this.timeConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/TimeConversion.fxml")));
            this.weightConversion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Conversion" +
                    "/WeightConversion.fxml")));

            mainStackPane.getChildren().add(standard);

            mainStackPane.getChildren().add(firstDegree);
            mainStackPane.getChildren().add(secondDegree);
            mainStackPane.getChildren().add(graph);

            mainStackPane.getChildren().add(lengthConversion);
            mainStackPane.getChildren().add(areaConversion);
            mainStackPane.getChildren().add(volumeConversion);
            mainStackPane.getChildren().add(speedConversion);
            mainStackPane.getChildren().add(dataConversion);
            mainStackPane.getChildren().add(energyConversion);
            mainStackPane.getChildren().add(powerConversion);
            mainStackPane.getChildren().add(pressureConversion);
            mainStackPane.getChildren().add(timeConversion);
            mainStackPane.getChildren().add(weightConversion);

            for (int i = 1; i < mainStackPane.getChildren().size(); i++) {
                mainStackPane.getChildren().get(i).setVisible(false);
            }
        } catch (IOException e) {
            //            e.printStackTrace();
        }
    }

    public void loadTreeView() {
        treeView.setStyle(treeItemStyle);
        treeView.getStyleClass().add("tree-view");
        TreeItem <String> root = new TreeItem <>("Root");

        TreeItem <String> standard = new TreeItem <>("Standard");
        //            System.out.println(this.standard.getId());
        panes.put(standard , this.standard);
        this.visiblePane = this.standard;
        root.getChildren().add(standard);

        TreeItem <String> equation = new TreeItem <>("Equation");
        TreeItem <String> firstDegree = new TreeItem <>("First Degree");
        TreeItem <String> secondDegree = new TreeItem <>("Second Degree");
        TreeItem <String> graph = new TreeItem <>("Graph");
        panes.put(firstDegree , this.firstDegree);
        panes.put(secondDegree , this.secondDegree);
        panes.put(graph , this.graph);
        equation.getChildren().add(firstDegree);
        equation.getChildren().add(secondDegree);
        equation.getChildren().add(graph);
        //        panes.put(equation , this.equation);
        //        TreeItem <String> variable = new TreeItem <>("Variable");
        //        TreeItem <String> graph = new TreeItem <>("Graph");
        //        equation.getChildren().addAll(variable , graph);
        //        panes.put(variable , this.variable);
        //        panes.put(graph , this.graph);
        root.getChildren().add(equation);

        TreeItem <String> matrix = new TreeItem <>("Matrix");
        panes.put(matrix , this.matrix);
        //            root.getChildren().add(matrix);

        TreeItem <String> vector = new TreeItem <>("Vector");
        panes.put(vector , this.vector);
        //            root.getChildren().add(vector);

        TreeItem <String> conversion = new TreeItem <>("Conversion");
        TreeItem <String> lengthConversion = new TreeItem <>("Length Conversion");
        TreeItem <String> areaConversion = new TreeItem <>("Area Conversion");
        TreeItem <String> volumeConversion = new TreeItem <>("Volume Conversion");
        TreeItem <String> speedConversion = new TreeItem <>("Speed Conversion");
        TreeItem <String> dataConversion = new TreeItem <>("Data Conversion");
        TreeItem <String> energyConversion = new TreeItem <>("Energy Conversion");
        TreeItem <String> powerConversion = new TreeItem <>("Power Conversion");
        TreeItem <String> pressureConversion = new TreeItem <>("Pressure Conversion");
        TreeItem <String> timeConversion = new TreeItem <>("Time Conversion");
        TreeItem <String> weightConversion = new TreeItem <>("Weight Conversion");

        panes.put(conversion , this.conversion);
        panes.put(lengthConversion , this.lengthConversion);
        panes.put(areaConversion , this.areaConversion);
        panes.put(volumeConversion , this.volumeConversion);
        panes.put(speedConversion , this.speedConversion);
        panes.put(dataConversion, this.dataConversion);
        panes.put(energyConversion, this.energyConversion);
        panes.put(powerConversion, this.powerConversion);
        panes.put(pressureConversion, this.pressureConversion);
        panes.put(timeConversion, this.timeConversion);
        panes.put(weightConversion, this.weightConversion);

        conversion.getChildren().add(lengthConversion);
        conversion.getChildren().add(areaConversion);
        conversion.getChildren().add(volumeConversion);
        conversion.getChildren().add(speedConversion);
        conversion.getChildren().add(dataConversion);
        conversion.getChildren().add(energyConversion);
        conversion.getChildren().add(powerConversion);
        conversion.getChildren().add(pressureConversion);
        conversion.getChildren().add(timeConversion);
        conversion.getChildren().add(weightConversion);

        root.getChildren().add(conversion);

        TreeItem <String> financial = new TreeItem <>("Financial");
        panes.put(financial , this.financial);
        //            root.getChildren().add(financial);

        treeView.setRoot(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().select(standard);
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

    public void initTopRightPane() {
        topRightPane.getChildren().add(Standard.topRightPane);

        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED , event -> {
            if (treeView.getSelectionModel().getSelectedItem() != null) {
                TreeItem <String> item = (TreeItem <String>) treeView.getSelectionModel().getSelectedItem();
                try {
                    if (panes.get(item) != null) {
                        switch (item.getValue()) {
                            case "Standard":
                                topRightPane.getChildren().clear();
                                //                            VBox vBox = new VBox();
                                //                            vBox.setSpacing(4);
                                topRightPane.getChildren().add(Standard.topRightPane);
                                break;
                            case "Graph":
                                topRightPane.getChildren().clear();
                                topRightPane.getChildren().add(GraphController.graphScrollPane);
                                break;
                            default:
                                topRightPane.getChildren().clear();
                        }
                    }
                } catch (Exception e) {
                    //                e.printStackTrace();
                }
            }
        });
    }

    @FXML
    void clickToResizeLeft(MouseEvent event) {
        double dividerPositions1 = splitPane.getDividerPositions()[0];
        if (dividerPositions1 < 0.004) {
            animatedSplitPane(0 , 0.18);
            //                resizeLeftIcon.setGlyphName("ANGLE_DOUBLE_LEFT");
        } else {
            animatedSplitPane(0 , 0);
            //            resizeLeftIcon.setGlyphName("ANGLE_DOUBLE_RIGHT");
        }
    }

    @FXML
    void clickToResizeRight(MouseEvent event) {
        double dividerPositions2 = splitPane.getDividerPositions()[1];
        if (dividerPositions2 > 0.99) {
            animatedSplitPane(1 , 0.8);
            //                resizeRightIcon.setGlyphName("ANGLE_DOUBLE_RIGHT");
        } else {
            animatedSplitPane(1 , 1);
            //                resizeRightIcon.setGlyphName("ANGLE_DOUBLE_LEFT");
        }
    }

    public void animatedSplitPane(int dividerPositions , double position) {
        KeyValue keyValue = new KeyValue(splitPane.getDividers().get(dividerPositions).positionProperty() , position);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(175) , keyValue));
        timeline.play();
    }

    public void splitPaneListener() {
        splitPane.getDividers().get(0).positionProperty().addListener((obs , oldVal , newVal) -> {
            if (newVal.doubleValue() < 0.004) {
                resizeLeftIcon.setGlyphName("ANGLE_DOUBLE_RIGHT");
            } else {
                resizeLeftIcon.setGlyphName("ANGLE_DOUBLE_LEFT");
            }
        });

        splitPane.getDividers().get(1).positionProperty().addListener((obs , oldVal , newVal) -> {
            if (newVal.doubleValue() > 0.99) {
                resizeRightIcon.setGlyphName("ANGLE_DOUBLE_LEFT");
            } else {
                resizeRightIcon.setGlyphName("ANGLE_DOUBLE_RIGHT");
            }
        });
    }
}
