package Conversion;

public class Speed {
    public static final double centimeterPerSeconds = 1;
    public static final double metersPerSeconds = Math.pow(10,2);
    public static final double kilometersPerHour = (1 / 3.6) * metersPerSeconds;
    public static final double feetsPerSecond = 30.48;
    public static final double milesPerHour = 44.7;
    public static final double knots = 51.44;
    public static final double mach = 34030;

    public static double a = centimeterPerSeconds;
    public static double b = feetsPerSecond;

    public static double results (double num) {
        return num * a * (1 / b);
    }


}
