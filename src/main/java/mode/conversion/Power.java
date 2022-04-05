package mode.conversion;

public class Power {
    public static final double watts = 1;
    public static final double kilowatts = Math.pow(10,3);
    public static final double housepower = 1 / 745.69987158227022;
    public static final double foot_poundsPerMinute = 0.0225969658;
    public static final double BTUsPerMinute = 17.5842642;

    public static double a = watts;
    public static double b = kilowatts;

    public static double result (double num) {
        return num * a * (1 / b);
    }

}
