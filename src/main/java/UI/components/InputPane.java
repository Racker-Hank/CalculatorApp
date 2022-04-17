package UI.components;


import UI.UIConfig;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import operation.Fraction;

public class InputPane extends AnchorPane {
    public InputTextField defaultTextField;

    public InputPane() {
        defaultTextField = new InputTextField();
        AnchorPane.setTopAnchor(defaultTextField , 0.0);
        AnchorPane.setLeftAnchor(defaultTextField , 0.0);
        AnchorPane.setRightAnchor(defaultTextField , 0.0);
        AnchorPane.setBottomAnchor(defaultTextField , 0.0);
        this.getChildren().add(defaultTextField);
        initKeyHandler();
    }

    public void initKeyHandler() {
        defaultTextField.setOnKeyTyped(new EventHandler <KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCharacter().equals("/")) {
                    convertToFraction();
                }
            }
        });
    }

    private void convertToFraction() {
//        VBox fractionContainer = new VBox(2);
//        fractionContainer.setAlignment(Pos.CENTER);
//        fractionContainer.setFillWidth(true);
//
//        InputPane numeratorContainer = new InputPane();
//        String numeratorText = defaultTextField.getText().substring(0 , defaultTextField.getText().indexOf("/"));
//        numeratorContainer.defaultTextField.setText(numeratorText);
////        numeratorContainer.defaultTextField.setPrefWidth(1 * this.defaultTextField.getWidth());
//
//        //        Rectangle rec = new Rectangle(1.5  * this.getWidth(), 2, Color.web(UIConfig.colorYellow));
//        //        fractionContainer.getChildren().add(rec);
//        AnchorPane fractionLine = new AnchorPane();
//        fractionLine.setPrefWidth(1 * this.getWidth());
////        fractionLine.setPrefWidth(14);
//        fractionLine.setPrefHeight(3);
//        fractionLine.setStyle("-fx-background-color: " + UIConfig.colorYellow);
//
//        InputPane denominatorContainer = new InputPane();
//        String denominatorText = defaultTextField.getText().substring(defaultTextField.getText().indexOf("/") + 1);
//        denominatorContainer.defaultTextField.setText(denominatorText);
//
//        this.getChildren().clear();
////        this.setHeight(2.25 * defaultTextField.getHeight());
//        //        this.setWidth(1.5 * defaultTextField.getWidth());
////        fractionLine.setMaxWidth(1 * Math.max(numeratorContainer.defaultTextField.getPrefWidth() ,
////                denominatorContainer.defaultTextField.getPrefWidth()));
//        fractionContainer.getChildren().add(numeratorContainer);
//        fractionContainer.getChildren().add(fractionLine);
//        fractionContainer.getChildren().add(denominatorContainer);
//        AnchorPane.setTopAnchor(fractionContainer , 0.0);
//        AnchorPane.setLeftAnchor(fractionContainer , 0.0);
//        AnchorPane.setRightAnchor(fractionContainer , 0.0);
//        AnchorPane.setBottomAnchor(fractionContainer , 0.0);
//        this.getChildren().add(fractionContainer);
//        denominatorContainer.defaultTextField.requestFocus();
////        fractionContainer.setOn(new EventHandler <KeyEvent>() {
////            @Override
////            public void handle(KeyEvent keyEvent) {
//////                System.out.println("hi");
////                System.out.println(numeratorContainer.getWidth());
//////                fractionLine.setPrefWidth(1 * Math.max(numeratorContainer.defaultTextField.getPrefWidth() , denominatorContainer.defaultTextField.getPrefWidth()));
////            }
////        });
//
////        System.out.println(this.getWidth());
////        System.out.println(numeratorContainer.defaultTextField.getPrefWidth());
//
//        //        GridPane fractionContainer = new GridPane();
//        //        fractionContainer.setAlignment(Pos.CENTER);
//        //        fractionContainer.setVgap(2);
//        //        fractionContainer.add();
////        int i = 0;
////        InputPane run = (InputPane) this.getParent().getParent();
////        while(run.getChildren().get(0) instanceof VBox) {
////            AnchorPane fractionLineNode = (AnchorPane) ((VBox) this.getChildren().get(0)).getChildren().get(1);
////            fractionLineNode.setPrefWidth(fractionLineNode.getPrefWidth() + i);
////            i-=2;
////            run = (InputPane) ((VBox) this.getChildren().get(0)).getChildren().get(0);
////        }

        try {
            double numerator = Double.parseDouble(defaultTextField.getText().substring(0 ,
                    defaultTextField.getText().indexOf("/")));
            Fraction fraction;
            if (defaultTextField.getText().substring(defaultTextField.getText().indexOf("/") + 1).equals("")){
                fraction = new Fraction(numerator);
            } else {
                double denominator = Double.parseDouble(defaultTextField.getText().substring(defaultTextField.getText().indexOf("/") + 1));
                fraction = new Fraction(numerator, denominator);
            }
//            fraction.parent =
            this.getChildren().clear();
            fraction.addToAnchorPane(this);
            ((InputPane) fraction.fractionContainer.getChildren().get(2)).defaultTextField.requestFocus();
            ((InputPane) fraction.fractionContainer.getChildren().get(2)).defaultTextField.positionCaret(Integer.MAX_VALUE);
//            this = fraction.fractionWrapper;
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
