package operation;

import error.Error;

public class Fraction extends Operand {
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

    public void simplify() {
        double gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public double gcd(double a, double b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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
        return numerator + "/" + denominator;
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

    @Override
    public void display() {

    }

}
