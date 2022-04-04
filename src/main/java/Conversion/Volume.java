package Conversion;

public class Volume {
    public static final double milliliters = 1;
    public static final double cubicCentimeters = 1;
    public static final double liters = Math.pow(10,3);
    public static final double cubicMeters = Math.pow(10,6);
    public static final double teaSpoonsUS = 4.92892159;
    public static final double tableSpoonUS = 14.7867648;
    public static final double fluidOuncesUS = 29.5735296;
    public static final double cupsUS = 236.588237;
    public static final double pintsUS = 473.176473;
    public static final double quartsUS = 946.352946;
    public static final double gallonsUS = 3785.41178;
    public static final double cubicInches = 16.387064;
    public static final double cubicFeet = 28316.8466;
    public static final double cubicYards = 764554.858;

    public static double a = liters;
    public static double b = pintsUS;

    public static double result (double num) {
        return num * a * (1 / b);
    }

}
