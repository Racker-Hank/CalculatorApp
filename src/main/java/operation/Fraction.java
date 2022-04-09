package operation;

//import error.Error;

import inputHandler.MathUtil;
import inputHandler.TextHandler;

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

    @Override
    public void display() {

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
