package Conversion;

public class Weight {
    public static final double carats = 200;
    public static final double milligrams = 1;
    public static final double centigrams = Math.pow(10,1);
    public static final double decigrams = Math.pow(10,2);
    public static final double grams = Math.pow(10,3);
    public static final double dekagrams = Math.pow(10,4);
    public static final double hectograms = Math.pow(10,5);
    public static final double kilograms = Math.pow(10,6);
    public static final double metricTonnes = Math.pow(10,9);
    public static final double ounces = 28349.5231;
    public static final double pounds = 453592.37;
    public static final double stone = 6350293.18;
    public static final double shortTonsUS = 907184740;
    public static final double longTonUS = 1.01604691 * Math.pow(10,9);

    public static double a = ounces;
    public static double b = grams;

    public static double result (double num) {
        return num * a * (1 / b);
    }
}
