package Conversion;

public class Data {
    public static final double bits = 1;
    public static final double bytes = 8;
    public static final double kilobits = 1000;
    public static final double kibibits = 1024;
    public static final double kilobytes = 8 * kilobits;
    public static final double kibibytes = 8 * kibibits;
    public static final double megabits = 1000 * kilobits;
    public static final double mebibits = 1024 * kibibits;
    public static final double megabytes = 8 * megabits;
    public static final double mebibytes = 8 * mebibits;
    public static final double gigabits = 1000 * megabits;
    public static final double gibibits = 1024 * mebibits;
    public static final double gigabytes = 8 * gigabits;
    public static final double gibibytes = 8 * gibibits;
    public static final double terabits = 1000 * gibibits;
    public static final double tebibits = 1024 * gibibits;
    public static final double terabytes = 8 * terabits;
    public static final double tebibytes = 8 * tebibits;
    public static final double petabits = 1000 * terabits;
    public static final double pebibits = 1024 * tebibits;
    public static final double petabytes = 8 * petabits;
    public static final double pebibytes = 8 * pebibits;


    public static double a = kibibits;
    public static double b = mebibytes;

    public static double result (double num) {
        return num * a * (1 / b);
    }
}
