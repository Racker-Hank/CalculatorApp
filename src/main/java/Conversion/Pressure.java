package Conversion;

public class Pressure {
    public static final double Atmospheres = 1;
    public static final double Bars = 0.986923;
    public static final double pascals = 9.86923267 * Math.pow(10,6);
    public static final double kilopascals = 9.86923267 * Math.pow(10,9);
    public static final double milimetersOfMercury = 0.00131578947;

    public static double a = Atmospheres;
    public static double b = Bars;

    public static double result (double num) {
        return num * a * (1 / b);
    }

    public static void main(String[] args) {
        System.out.println(result(10));
    }
}
