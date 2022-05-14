package mode.standard;

import UI.UIConfig;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import mode.Mode;

public class Standard extends Mode {
    public static ObservableList <String> historyCalculation = FXCollections.observableArrayList();
    public static ObservableList <String> pinnedCalculation = FXCollections.observableArrayList();
    public static StandardTopRightPane topRightPane = new StandardTopRightPane();

    public static class StandardTopRightPane extends AnchorPane {
        SimpleBooleanProperty history_pin = new SimpleBooleanProperty(true);
        public Button historyTabButton;
        public Button pinnedTabButton;
        GridPane tabsGridPane;
        public ScrollPane scrollPane;
        public VBox vBox;
        public VBox historyVBox;
        public VBox pinnedVBox;

        public StandardTopRightPane() {
            initButton();
            initGridPane();
            this.setPrefWidth(Control.USE_COMPUTED_SIZE);
            AnchorPane.setTopAnchor(this , 0d);
            AnchorPane.setRightAnchor(this , 0d);
            AnchorPane.setBottomAnchor(this , 0d);
            AnchorPane.setLeftAnchor(this , 0d);
            initBooleanProperty();
            initHistoryVBox();
            initPinnedVBox();
            initScrollPane();
            initVBox();
        }

        private void initVBox() {
            vBox = new VBox();
            vBox.setSpacing(4);
            vBox.getChildren().addAll(tabsGridPane , scrollPane);
            AnchorPane.setTopAnchor(vBox , 0d);
            AnchorPane.setRightAnchor(vBox , 0d);
            AnchorPane.setBottomAnchor(vBox , 0d);
            AnchorPane.setLeftAnchor(vBox , 0d);
            this.getChildren().add(vBox);
        }

        private void initHistoryVBox() {
            historyVBox = new VBox();
            //            historyVBox.setFillWidth(true);
            historyVBox.prefWidthProperty().bind(this.widthProperty());
            historyVBox.setPrefHeight(0);
            historyVBox.setSpacing(2);
            historyVBox.setStyle("-fx-background-color: transparent");
            //            for (String s : historyCalculation) {
            //                HistoryGridPane hBox = new HistoryGridPane(s);
            //                historyVBox.getChildren().add(hBox);
            //            }

            for (int i = historyCalculation.size() - 1; i >= 0; i--) {
                HistoryGridPane hBox = new HistoryGridPane(historyCalculation.get(i));
                historyVBox.getChildren().add(hBox);
            }
            //            historyVBox.setPrefWidth(Control.USE_COMPUTED_SIZE);
            //            historyVBox.setPrefHeight(Control.USE_COMPUTED_SIZE);
            AnchorPane.setTopAnchor(historyVBox , 0d);
            AnchorPane.setRightAnchor(historyVBox , 0d);
            AnchorPane.setLeftAnchor(historyVBox , 0d);

            historyCalculation.addListener((ListChangeListener.Change <? extends String> c) -> {
                historyVBox.getChildren().clear();
                //                for (String s : historyCalculation) {
                //                    HistoryGridPane hBox = new HistoryGridPane(s);
                //                    historyVBox.getChildren().add(hBox);
                //                }
                for (int i = historyCalculation.size() - 1; i >= 0; i--) {
                    HistoryGridPane hBox = new HistoryGridPane(historyCalculation.get(i));
                    historyVBox.getChildren().add(hBox);
                }
            });
        }

        private void initPinnedVBox() {
            pinnedVBox = new VBox();
            pinnedVBox.prefWidthProperty().bind(this.widthProperty());
            pinnedVBox.setPrefHeight(0);
            pinnedVBox.setSpacing(2);
            for (int i = pinnedCalculation.size() - 1; i >= 0; i--) {
                PinnedGridPane hBox = new PinnedGridPane(pinnedCalculation.get(i));
                pinnedVBox.getChildren().add(hBox);
            }
            AnchorPane.setTopAnchor(pinnedVBox , 0d);
            AnchorPane.setRightAnchor(pinnedVBox , 0d);
            AnchorPane.setLeftAnchor(pinnedVBox , 0d);

            pinnedCalculation.addListener((ListChangeListener.Change <? extends String> c) -> {
                pinnedVBox.getChildren().clear();
                for (int i = pinnedCalculation.size() - 1; i >= 0; i--) {
                    PinnedGridPane hBox = new PinnedGridPane(pinnedCalculation.get(i));
                    pinnedVBox.getChildren().add(hBox);
                }
            });
        }

        private void initScrollPane() {
            scrollPane = new ScrollPane();
            scrollPane.setPrefWidth(Control.USE_COMPUTED_SIZE);
            scrollPane.setPrefHeight(Control.USE_COMPUTED_SIZE);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setContent(null);
            scrollPane.setContent(new AnchorPane(historyVBox, pinnedVBox));
            historyVBox.setVisible(history_pin.get());
            pinnedVBox.setVisible(!history_pin.get());
            AnchorPane.setTopAnchor(scrollPane , 0d);
            AnchorPane.setRightAnchor(scrollPane , 0d);
            AnchorPane.setBottomAnchor(scrollPane , 0d);
            AnchorPane.setLeftAnchor(scrollPane , 0d);
            scrollPane.setStyle("-fx-background-color: #202020;-fx-background: #202020;");
        }

        private void initBooleanProperty() {
            history_pin.addListener((observable , oldValue , newValue) -> {
                ((FontAwesomeIcon) historyTabButton.getGraphic()).setFill(Paint.valueOf(history_pin.get() ?
                        UIConfig.colorWhite :
                        UIConfig.colorInactiveGrey));
                ((FontAwesomeIcon) pinnedTabButton.getGraphic()).setFill(Paint.valueOf(!history_pin.get() ? UIConfig.colorWhite :
                        UIConfig.colorInactiveGrey));
                historyVBox.setVisible(history_pin.get());
                pinnedVBox.setVisible(!history_pin.get());
            });
        }

        private void initButton() {
            historyTabButton = new Button();
            FontAwesomeIcon historyIcon = new FontAwesomeIcon();
            historyIcon.setIcon(FontAwesomeIcons.HISTORY);
            historyTabButton.setGraphic(historyIcon);
            historyIcon.setSize("2em");
            historyIcon.setFill(Paint.valueOf(history_pin.get() ? UIConfig.colorWhite : UIConfig.colorInactiveGrey));
            historyTabButton.setGraphic(historyIcon);
            historyTabButton.getStyleClass().add("pin-button");
            historyTabButton.setOnMouseClicked(event -> {
                history_pin.set(true);
            });

            pinnedTabButton = new Button();
            FontAwesomeIcon pinnedIcon = new FontAwesomeIcon();
            pinnedIcon.setIcon(FontAwesomeIcons.CLIPBOARD);
            pinnedTabButton.setGraphic(pinnedIcon);
            pinnedIcon.setSize("2em");
            pinnedIcon.setFill(Paint.valueOf(!history_pin.get() ? UIConfig.colorWhite : UIConfig.colorInactiveGrey));
            pinnedTabButton.setGraphic(pinnedIcon);
            pinnedTabButton.getStyleClass().add("pin-button");
            pinnedTabButton.setOnMouseClicked(event -> {
                history_pin.set(false);
            });
        }

        private void initGridPane() {
            tabsGridPane = new GridPane();
            GridPane.setHalignment(historyTabButton , HPos.CENTER);
            GridPane.setHgrow(historyTabButton , Priority.ALWAYS);
            Separator separator = new Separator(Orientation.VERTICAL);
            separator.setPrefHeight(Control.USE_COMPUTED_SIZE);
            GridPane.setHalignment(separator , HPos.CENTER);
            GridPane.setHgrow(separator , Priority.NEVER);
            GridPane.setHalignment(pinnedTabButton , HPos.CENTER);
            GridPane.setHgrow(pinnedTabButton , Priority.ALWAYS);
            tabsGridPane.add(historyTabButton , 0 , 0);
            tabsGridPane.add(separator , 1 , 0);
            tabsGridPane.add(pinnedTabButton , 2 , 0);
            AnchorPane.setTopAnchor(tabsGridPane , 0d);
            AnchorPane.setRightAnchor(tabsGridPane , 0d);
            AnchorPane.setLeftAnchor(tabsGridPane , 0d);
            tabsGridPane.setStyle("-fx-border-color: #28F984;-fx-border-width: 0 0 1 0;");
        }
    }

    public static class HistoryGridPane extends GridPane {
        public Label historyCalculationLabel;
        public CopyToClipboardButton copyToClipboardButton;
        public PinButton pinButton;

        public HistoryGridPane(String historyCalculationString) {
            super();
            setAlignment(Pos.CENTER_LEFT);
            setHgap(20);
            //            setFillHeight(false);
            this.historyCalculationLabel = new Label(historyCalculationString);
            //            this.historyCalculationLabel.setText(historyCalculationString);
            //            this.historyCalculation.setPrefHeight(Control.USE_COMPUTED_SIZE);
            //            this.historyCalculation.setPrefWidth(Control.USE_COMPUTED_SIZE);
            this.historyCalculationLabel.setStyle("-fx-font-size: 24;-fx-text-fill: white;-fx-background-color: transparent;    " +
                    "-fx-control-inner-background: transparent");
            //            this.historyCalculation.setMaxHeight(20);
            //            this.historyCalculationLabel.setPrefWidth(120);
            this.historyCalculationLabel.setWrapText(true);
            //            this.historyCalculation.setEditable(false);
            copyToClipboardButton = new CopyToClipboardButton();
            copyToClipboardButton.label.setText(this.historyCalculationLabel.getText());
            pinButton = new PinButton();
            pinButton.textArea = historyCalculationString;
            //            HBox.setHgrow(this.historyCalculationLabel , Priority.ALWAYS);
            //            HBox.setHgrow(copyToClipboardButton , Priority.NEVER);
            //            HBox.setHgrow(pinButton , Priority.NEVER);
            //            this.getChildren().addAll(this.historyCalculationLabel , copyToClipboardButton , pinButton);
            this.add(this.historyCalculationLabel , 0 , 0);
            this.add(copyToClipboardButton , 1 , 0);
            this.add(pinButton , 2 , 0);
            GridPane.setHgrow(this.historyCalculationLabel , Priority.ALWAYS);
            this.getRowConstraints().add(0, new RowConstraints(Control.USE_COMPUTED_SIZE));
            AnchorPane.setTopAnchor(this , 0d);
            AnchorPane.setRightAnchor(this , 0d);
            AnchorPane.setLeftAnchor(this , 0d);
//            setStyle("-fx-background-color:  black;");
        }
    }

    public static class PinnedGridPane extends GridPane {
        public Label pinnedCalculationLabel;
        public CopyToClipboardButton copyToClipboardButton;
        public UnpinButton unpinButton;

        public PinnedGridPane(String pinnedCalculationString) {
            super();
            setAlignment(Pos.CENTER_LEFT);
            setHgap(20);

            this.pinnedCalculationLabel = new Label(pinnedCalculationString);
            this.pinnedCalculationLabel.setStyle("-fx-font-size: 24;-fx-text-fill: white;");
            this.pinnedCalculationLabel.setWrapText(true);
            copyToClipboardButton = new CopyToClipboardButton();
            copyToClipboardButton.label.setText(this.pinnedCalculationLabel.getText());
            unpinButton = new UnpinButton();
            unpinButton.textArea = pinnedCalculationString;
            this.add(this.pinnedCalculationLabel , 0 , 0);
            this.add(copyToClipboardButton , 1 , 0);
            this.add(unpinButton , 2 , 0);
            GridPane.setHgrow(this.pinnedCalculationLabel , Priority.ALWAYS);
            this.getRowConstraints().add(0, new RowConstraints(Control.USE_COMPUTED_SIZE));
            AnchorPane.setTopAnchor(this , 0d);
            AnchorPane.setRightAnchor(this , 0d);
            AnchorPane.setLeftAnchor(this , 0d);
//            setStyle("-fx-background-color:  black;");
        }
    }

    public static class CopyToClipboardButton extends Button {
        public Label label;

        public CopyToClipboardButton() {
            Tooltip tooltip = new Tooltip("Copy answer to Clipboard");
            tooltip.setStyle("-fx-font-family: System;" + "-fx-font-weight: bold;" + "-fx-font-size: " + 12 + "px;");
            Tooltip.install(this , tooltip);
            FontAwesomeIcon icon = new FontAwesomeIcon();
            icon.setIcon(FontAwesomeIcons.COPY);
            icon.setFill(Paint.valueOf("white"));
            icon.setSize("2em");
            this.setGraphic(icon);
            setPrefWidth(Control.USE_COMPUTED_SIZE);
            setPrefHeight(Control.USE_COMPUTED_SIZE);
            label = new Label();
            this.getStyleClass().add("copy-to-clipboard-button");
            //            this.setText(FontAwesomeIcons.COPY.characterToString());
            //            this.setStyle("-fx-font-size: 1.5em; -fx-");
            this.setOnAction(event -> {
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();
                content.putString(label.getText().split("=")[1].trim());
                clipboard.setContent(content);
            });
        }
    }

    public static class PinButton extends Button {
        public String textArea;

        public PinButton() {
            Tooltip tooltip = new Tooltip("Pin Calculation");
            tooltip.setStyle("-fx-font-family: System;" + "-fx-font-weight: bold;" + "-fx-font-size: " + 12 + "px;");
            Tooltip.install(this , tooltip);
            FontAwesomeIcon icon = new FontAwesomeIcon();
            icon.setIcon(FontAwesomeIcons.THUMB_TACK);
            icon.setFill(Paint.valueOf("white"));
            icon.setSize("2em");
            icon.setRotate(45);

            this.setGraphic(icon);
            setPrefWidth(Control.USE_COMPUTED_SIZE);
            setPrefHeight(Control.USE_COMPUTED_SIZE);
            this.getStyleClass().add("pin-button");
            this.setOnAction(event -> {
                //                if (!pinnedCalculation.contains(textArea.getText())) {
                pinnedCalculation.add(textArea);
                //                }
            });
        }
    }

    public static class UnpinButton extends Button {
        public String textArea;

        public UnpinButton() {
            Tooltip tooltip = new Tooltip("Unpin Calculation");
            tooltip.setStyle("-fx-font-family: System;" + "-fx-font-weight: bold;" + "-fx-font-size: " + 12 + "px;");
            Tooltip.install(this , tooltip);
            FontAwesomeIcon icon = new FontAwesomeIcon();
            icon.setIcon(FontAwesomeIcons.TRASH_ALT);
            icon.setFill(Paint.valueOf("white"));
            icon.setSize("2em");
//            icon.setRotate(45);
            this.setGraphic(icon);
            setPrefWidth(Control.USE_COMPUTED_SIZE);
            setPrefHeight(Control.USE_COMPUTED_SIZE);
            this.getStyleClass().add("pin-button");
            this.setOnAction(event -> {
                //                if (pinnedCalculation.contains(textArea.getText())) {
                pinnedCalculation.remove(textArea);
                //                }
            });
        }
    }
}
