package Conversion;

public class Length {
    public static final double inch = 0.0254 * Math.pow(10,9);
    public static final double yard = 0.9144 * Math.pow(10,9);
    public static final double feet = 0.3048 * Math.pow(10,9);
    public static final double mile = 1609.344 * Math.pow(10,9);
    public static final double nauticalMile = 1852 * Math.pow(10,9);
    public static final double parsec = 3.08567758 * Math.pow(10,16) * Math.pow(10,9);

    public static final double nanometer = Math.pow(10,0);
    public static final double micrometer = Math.pow(10,3);
    public static final double millimeter = Math.pow(10,6);
    public static final double centimeter = Math.pow(10,7);
    public static final double decimeter = Math.pow(10,8);
    public static final double meter = Math.pow(10,9);
    public static final double dekameter = Math.pow(10,10);
    public static final double hectometer = Math.pow(10,11);
    public static final double kilometer = Math.pow(10,12);

    public static double a = feet;
    public static double b = centimeter;

    public static double result (double num) {
        return num * a * (1 / b);
    }

    public static void main(String[] args) {
        System.out.println(result(1));
    }

}
