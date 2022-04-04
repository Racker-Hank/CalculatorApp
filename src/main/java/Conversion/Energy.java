package Conversion;

public class Energy {
    public static final double volts = 1;
    public static final double joules = 6.24150913 * Math.pow(10,18);
    public static final double kilojoules = joules * Math.pow(10,3);
    public static final double thermalCalories = 2.61144742 * Math.pow(10,19);
    public static final double foodCalories = thermalCalories * Math.pow(10,3);
    public static final double footPounds = 8.4623501 * Math.pow(10,18);
    public static final double britishThermalUnits = 6.58514073 * Math.pow(10,21);

    public static double a = footPounds;
    public static double b = kilojoules;

    public static double result (double num) {
        return num * a * (1 / b);
    }

    public static void main(String[] args) {
        System.out.println(result(1));
    }
}
