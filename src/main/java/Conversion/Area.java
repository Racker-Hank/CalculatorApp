package Conversion;

public class Area {
    public static final double squareMillimeters = 1;
    public static final double squareCentimeters = Math.pow(10,2);
    public static final double squareMeters = Math.pow(10,6);
    public static final double squareKilometers = Math.pow(10,12);
    public static final double squareInches = 645.16;
    public static final double squareFeet = 92903.04;
    public static final double squareYards = 836127.36;
    public static final double squareMiles = 2589988 * Math.pow(10,6) + 110336;
    public static final double hectares = Math.pow(10,10);
    public static final double acres = 4046856422.4;

    public static double a = squareCentimeters;
    public static double b = squareInches;

    public static double result (double num) {
        return num * a * (1 / b);
    }
}
