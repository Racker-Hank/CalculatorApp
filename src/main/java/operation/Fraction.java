package operation;

//import error.Error;

import UI.UIConfig;
import UI.components.InputPane;
import inputHandler.MathUtil;
import inputHandler.TextHandler;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class Fraction extends Operand implements Comparable <Fraction> {
    public String name = "Fraction";
    public double numerator;
    public double denominator;

    public Fraction(double numerator , double denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            //            throw new Error();
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        this.denominator = denominator;
    }

    public Fraction(double numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(String fraction) {
        String[] parts = fraction.split("/");
        this.numerator = Double.parseDouble(parts[0]);
        this.denominator = Double.parseDouble(parts[1]);
    }

    public Fraction(Fraction fraction) {
        this.numerator = fraction.numerator;
        this.denominator = fraction.denominator;
    }

    public Fraction add(Fraction fraction) {
        double newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
        double newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator , newDenominator);
    }

    public Fraction subtract(Fraction fraction) {
        double newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
        double newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator , newDenominator);
    }

    public Fraction multiply(Fraction fraction) {
        double newNumerator = this.numerator * fraction.numerator;
        double newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator , newDenominator);
    }

    public Fraction divide(Fraction fraction) {
        double newNumerator = this.numerator * fraction.denominator;
        double newDenominator = this.denominator * fraction.numerator;
        return new Fraction(newNumerator , newDenominator);
    }

    public Fraction simplify() {
        double gcd = gcd(numerator , denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    public double gcd(double a , double b) {
        if (b == 0) {
            return a;
        }
        return gcd(b , a % b);
    }

    public Fraction root(Fraction n) {
        Fraction tmp = new Fraction(this);
        tmp.numerator = MathUtil.root(this.numerator , n.toDouble());
        tmp.denominator = MathUtil.root(this.denominator , n.toDouble());
        return tmp;
    }

    public Fraction pow(Fraction n) {
        Fraction tmp = new Fraction(this);
        tmp.numerator = MathUtil.power(this.numerator , n.toDouble());
        tmp.denominator = MathUtil.power(this.denominator , n.toDouble());
        return tmp;
    }

    public Fraction abs() {
        Fraction tmp = new Fraction(this);
        tmp.numerator = Math.abs(this.numerator);
        tmp.denominator = Math.abs(this.denominator);
        return tmp;
    }

    public double getNumerator() {
        return numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    public void setNumerator(double numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(double denominator) {
        this.denominator = denominator;
    }

    public String toString() {
        return TextHandler.numberFormatter(numerator) + "/" + TextHandler.numberFormatter(denominator);
    }

    public boolean equals(Fraction fraction) {
        return this.numerator == fraction.numerator && this.denominator == fraction.denominator;
    }

    public double toDouble() {
        return numerator / denominator;
        //        missing handle denom = 0
    }

    public void setValue(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    public int compareTo(Fraction other) {
        if (this.subtract(other).toDouble() > 0) {
            return 1;
        } else if (this.subtract(other).toDouble() < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public int Level = 0;
    public Fraction children;
    public InputPane fractionWrapper;
    //    public VBox fractionContainer;
    public FractionVBox fractionContainer;

    public class FractionVBox extends VBox {
        public Fraction fraction;
        public Fraction parentFraction;
        public Fraction childFraction;
        public int level = 0;
        public InputPane numeratorContainer;
        public HBox numeratorWrapper;
        public AnchorPane fractionLine;
        public HBox denominatorWrapper;
        public InputPane denominatorContainer;
        public int regionWidth = 10;

        public FractionVBox() {
            super(4);
            this.setAlignment(Pos.CENTER);
            this.setFillWidth(true);

            /*numerator*/
            numeratorWrapper = new HBox();
            numeratorWrapper.setAlignment(Pos.CENTER);
            numeratorWrapper.setFillHeight(true);

            Region numeratorPaddingRegion1 = new Region();
            numeratorPaddingRegion1.setMinWidth(regionWidth);
            HBox.setHgrow(numeratorPaddingRegion1 , Priority.NEVER);
            numeratorWrapper.getChildren().add(numeratorPaddingRegion1);

            numeratorContainer = new InputPane();
            numeratorContainer.defaultTextField.setText(TextHandler.numberFormatter(numerator) + "");
            numeratorContainer.defaultTextField.textProperty().addListener((observable , oldValue , newValue) -> {
                Platform.runLater(() -> {
//                    fractionLine.prefWidthProperty().bind(this.widthProperty());
                    try {
                        numerator = TextHandler.numberFormatter(Double.parseDouble(newValue.toString())).doubleValue();
//                        numeratorWrapper.setPrefWidth(numeratorContainer.getWidth() + regionWidth*2);
                    } catch (NumberFormatException e) {
                        //                        e.printStackTrace();
                    }
                });
            });
            HBox.setHgrow(numeratorContainer , Priority.ALWAYS);
            numeratorWrapper.getChildren().add(numeratorContainer);

//            Text numeratorText = new Text(TextHandler.numberFormatter(numerator) + "abcxyz");
//            numeratorText.setStyle("-fx-font-size: 14;");
//            numeratorText.setOpacity(0);
//            numeratorText.setTranslateY(-14);
//            numeratorText.textProperty().bind(numeratorContainer.defaultTextField.textProperty());

            Region numeratorPaddingRegion2 = new Region();
            numeratorPaddingRegion2.setMinWidth(regionWidth);
            HBox.setHgrow(numeratorPaddingRegion2 , Priority.NEVER);
            numeratorWrapper.getChildren().add(numeratorPaddingRegion2);
            /*end numerator*/

            fractionLine = new AnchorPane();
            //            fractionLine.setPrefWidth(1 * parentPane.getWidth());
            fractionLine.setPrefHeight(4);
            fractionLine.setStyle("-fx-border-radius: 16px;-fx-background-radius: 16px;-fx-background-color: " + UIConfig.colorYellow);

            /*denominator*/
            denominatorWrapper = new HBox();
            denominatorWrapper.setAlignment(Pos.CENTER);
            denominatorWrapper.setFillHeight(true);

            Region denominatorPaddingRegion1 = new Region();
            denominatorPaddingRegion1.setMinWidth(regionWidth);
            denominatorWrapper.getChildren().add(denominatorPaddingRegion1);

            denominatorContainer = new InputPane();
            denominatorContainer.defaultTextField.setText(denominator == 1 ? "" : TextHandler.numberFormatter(denominator) +
                    "");
            denominatorContainer.defaultTextField.textProperty().addListener((observable , oldValue , newValue) -> {
//                fractionLine.prefWidthProperty().bind(this.widthProperty());
                Platform.runLater(() -> {
//                    System.out.println(this.getWidth());
                    try {
                        denominator = TextHandler.numberFormatter(Double.parseDouble(newValue.toString())).doubleValue();
                    } catch (NumberFormatException e) {
                        //                        e.printStackTrace();
                    }
                });
            });
            HBox.setHgrow(denominatorContainer , Priority.ALWAYS);
            denominatorWrapper.getChildren().add(denominatorContainer);

            Region denominatorPaddingRegion2 = new Region();
            denominatorPaddingRegion2.setMinWidth(regionWidth);
            denominatorWrapper.getChildren().add(denominatorPaddingRegion2);
            /*end denominator*/

//            this.getChildren().add(numeratorContainer);
//            this.getChildren().add(fractionLine);
//            this.getChildren().add(denominatorContainer);

            this.getChildren().add(numeratorWrapper);
//            this.getChildren().add(numeratorText);
            this.getChildren().add(fractionLine);
            this.getChildren().add(denominatorWrapper);

//            ChangeListener listener = (observable , oldValue , newValue) -> {
//                Platform.runLater(() -> {
////                    fractionLine.setPrefWidth(numeratorContainer.defaultTextField.getText().length() > denominatorContainer.defaultTextField.getText().length() ? numeratorContainer.defaultTextField.getPrefWidth() : denominatorContainer.defaultTextField.getPrefWidth() + 16);
//                });
//            };
//
//            numeratorContainer.defaultTextField.textProperty().addListener(listener);
//            numeratorContainer.defaultTextField.prefWidthProperty().addListener(listener);
//            denominatorContainer.defaultTextField.textProperty().addListener(listener);
//            denominatorContainer.defaultTextField.prefWidthProperty().addListener(listener);

            //            fractionLine.prefWidthProperty().bind(numeratorContainer.defaultTextField.getText().length() > denominatorContainer.defaultTextField.getText().length() ? numeratorContainer.defaultTextField.prefWidthProperty() : denominatorContainer.defaultTextField.prefWidthProperty());

            AnchorPane.setTopAnchor(this , 0.0);
            AnchorPane.setLeftAnchor(this , 0.0);
            AnchorPane.setRightAnchor(this , 0.0);
            AnchorPane.setBottomAnchor(this , 0.0);
//            this.autosize();
        }
    }

    @Override
    public void addToAnchorPane(Pane parentPane) {
        //        fractionContainer = new VBox(2);
        //        fractionContainer.setAlignment(Pos.CENTER);
        //        fractionContainer.setFillWidth(true);
        fractionContainer = new FractionVBox();
        //
        //        InputPane numeratorContainer = new InputPane();
        //        //        String numeratorText = defaultTextField.getText().substring(0 , defaultTextField.getText().indexOf("/"));
        //        //        numeratorContainer.defaultTextField.setText(numeratorText);
        //        numeratorContainer.defaultTextField.setText(TextHandler.numberFormatter(numerator) + "");
        //
        //        AnchorPane fractionLine = new AnchorPane();
        //        fractionLine.setPrefWidth(1 * parentPane.getWidth());
        //        fractionLine.setPrefHeight(4);
        //        //        fractionLine.getTransforms().add(new Scale(1.5,1, fractionLine.getPrefWidth() / 2, 0));
        ////        fractionLine.getTransforms().add(new Scale(1.05 , 1));
        //        fractionLine.setStyle("-fx-background-color: " + UIConfig.colorYellow);
        //
        //        InputPane denominatorContainer = new InputPane();
        //        //        String denominatorText = defaultTextField.getText().substring(defaultTextField.getText().indexOf("/") + 1);
        //        //        denominatorContainer.defaultTextField.setText(denominatorText);
        //        denominatorContainer.defaultTextField.setText(denominator == 1 ? "" : TextHandler.numberFormatter(denominator) +
        //                "");
        //
        //        //        this.getChildren().clear();
        //
        //        fractionContainer.getChildren().add(numeratorContainer);
        //        fractionContainer.getChildren().add(fractionLine);
        //        fractionContainer.getChildren().add(denominatorContainer);
        //
        //        AnchorPane.setTopAnchor(fractionContainer , 0.0);
        //        AnchorPane.setLeftAnchor(fractionContainer , 0.0);
        //        AnchorPane.setRightAnchor(fractionContainer , 0.0);
        //        AnchorPane.setBottomAnchor(fractionContainer , 0.0);
        //        denominatorContainer.defaultTextField.requestFocus();
        //        this.getChildren().add(fractionContainer);

        fractionContainer.fractionLine.setPrefWidth(1 * parentPane.getWidth() + fractionContainer.regionWidth*2);
//        System.out.println(fractionContainer.fractionLine.getPrefWidth());
        //        fractionContainer.fractionLine.setPrefWidth(fractionContainer.numeratorContainer.defaultTextField.getText().length() > fractionContainer.denominatorContainer.defaultTextField.getText().length() ? fractionContainer.numeratorContainer.defaultTextField.getPrefWidth() : fractionContainer.denominatorContainer.defaultTextField.getPrefWidth());
        //        fractionContainer.fractionLine.setPrefWidth(14);
        //        fractionContainer.fractionLine.prefWidthProperty().bind(fractionContainer.numeratorContainer.defaultTextField.getText().length() > fractionContainer.denominatorContainer.defaultTextField.getText().length() ? fractionContainer.numeratorContainer.defaultTextField.prefWidthProperty() : fractionContainer.denominatorContainer.defaultTextField.prefWidthProperty());
        //        numeratorContainer.defaultTextField.setOnKeyReleased(event -> {
        ////            System.out.println(numeratorContainer.getParent());
        //            if (numeratorContainer.getParent().getParent().getParent() instanceof VBox) {
        //                VBox fractionContainerNode = (VBox) numeratorContainer.getParent().getParent().getParent();
        //                System.out.println(((AnchorPane)(fractionContainerNode.getChildren().get(1))).getPrefWidth());
        //                ((AnchorPane)(fractionContainerNode.getChildren().get(1))).setPrefWidth(fractionContainerNode.getWidth() + 16);
        //                System.out.println(((AnchorPane)(fractionContainerNode.getChildren().get(1))).getPrefWidth());
        //            }
        //        });
        fractionContainer.fraction = this;
        if (parentPane.getParent().getParent() instanceof FractionVBox) {
            fractionContainer.parentFraction = ((FractionVBox) parentPane.getParent().getParent()).fraction;
            ((FractionVBox) parentPane.getParent().getParent()).childFraction = fractionContainer.fraction;
            System.out.println(fractionContainer.parentFraction.toString());
            System.out.println(fractionContainer.fraction.toString());
        }
        parentPane.getChildren().add(fractionContainer);
    }

    public static void main(String[] args) {
        //        Fraction a = new Fraction(1, 2);
        //        System.out.println(a.root(new Fraction(2)).toDouble());
        //        System.out.println(a.pow(new Fraction(2)).toDouble());

        Fraction a = new Fraction(3 , 4);
        System.out.println(a.root(new Fraction(2)).toDouble());
        System.out.println(a.pow(new Fraction(2)).toDouble());
        System.out.println(Math.pow((Math.sqrt(0.5)) , 2));
    }
}
