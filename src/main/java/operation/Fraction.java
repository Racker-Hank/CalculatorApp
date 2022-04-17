package operation;

//import error.Error;

import UI.UIConfig;
import UI.components.InputPane;
import inputHandler.MathUtil;
import inputHandler.TextHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Fraction extends Operand implements Comparable<Fraction> {
    public String name = "Fraction";
    public double numerator;
    public double denominator;

    public Fraction(double numerator, double denominator) {
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
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction fraction) {
        double newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
        double newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction fraction) {
        double newNumerator = this.numerator * fraction.numerator;
        double newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction fraction) {
        double newNumerator = this.numerator * fraction.denominator;
        double newDenominator = this.denominator * fraction.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction simplify() {
        double gcd = gcd(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    public double gcd(double a, double b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Fraction root (Fraction n) {
        Fraction tmp = new Fraction(this);
        tmp.numerator = MathUtil.root(this.numerator, n.toDouble());
        tmp.denominator = MathUtil.root(this.denominator, n.toDouble());
        return tmp;
    }

    public Fraction pow(Fraction n) {
        Fraction tmp = new Fraction(this);
        tmp.numerator = MathUtil.power(this.numerator, n.toDouble());
        tmp.denominator = MathUtil.power(this.denominator, n.toDouble());
        return tmp;
    }

    public Fraction abs () {
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
    public VBox fractionContainer;

    @Override
    public void addToAnchorPane(Pane parentPane) {
        fractionContainer = new VBox(2);
        fractionContainer.setAlignment(Pos.CENTER);
        fractionContainer.setFillWidth(true);

        InputPane numeratorContainer = new InputPane();
//        String numeratorText = defaultTextField.getText().substring(0 , defaultTextField.getText().indexOf("/"));
//        numeratorContainer.defaultTextField.setText(numeratorText);
        numeratorContainer.defaultTextField.setText(TextHandler.numberFormatter(numerator) + "");

        AnchorPane fractionLine = new AnchorPane();
        fractionLine.setPrefWidth(1 * parentPane.getWidth());
        fractionLine.setPrefHeight(3);
        fractionLine.setStyle("-fx-background-color: " + UIConfig.colorYellow);

        InputPane denominatorContainer = new InputPane();
//        String denominatorText = defaultTextField.getText().substring(defaultTextField.getText().indexOf("/") + 1);
//        denominatorContainer.defaultTextField.setText(denominatorText);
        denominatorContainer.defaultTextField.setText(TextHandler.numberFormatter(denominator) + "");

//        this.getChildren().clear();

        fractionContainer.getChildren().add(numeratorContainer);
        fractionContainer.getChildren().add(fractionLine);
        fractionContainer.getChildren().add(denominatorContainer);

        AnchorPane.setTopAnchor(fractionContainer , 0.0);
        AnchorPane.setLeftAnchor(fractionContainer , 0.0);
        AnchorPane.setRightAnchor(fractionContainer , 0.0);
        AnchorPane.setBottomAnchor(fractionContainer , 0.0);
//        denominatorContainer.defaultTextField.requestFocus();
//        this.getChildren().add(fractionContainer);
        parentPane.getChildren().add(fractionContainer);
    }

    public static void main(String[] args) {
//        Fraction a = new Fraction(1, 2);
//        System.out.println(a.root(new Fraction(2)).toDouble());
//        System.out.println(a.pow(new Fraction(2)).toDouble());

        Fraction a = new Fraction(3, 4);
        System.out.println(a.root(new Fraction(2)).toDouble());
        System.out.println(a.pow(new Fraction(2)).toDouble());
        System.out.println(Math.pow((Math.sqrt(0.5)),2));
    }
}
