package Conversion;

public class Time {
    public static final double microseconds = 1;
    public static final double milliseconds = Math.pow(10,1);
    public static final double seconds = Math.pow(10,2);
    public static final double minutes = 60 * seconds;
    public static final double hours = 60 * minutes;
    public static final double days = 24 * hours;
    public static final double weeks = 7 * days;

    public static double a = weeks;
    public static double b = minutes;

    public static double results (double num) {
        return num * a * (1 / b);
    }

}
