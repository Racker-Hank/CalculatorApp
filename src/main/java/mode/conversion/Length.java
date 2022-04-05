package mode.conversion;

import java.util.ArrayList;

public class Length {
//    public static final double inch = 0.0254 * Math.pow(10,9);
//    public static final double yard = 0.9144 * Math.pow(10,9);
//    public static final double feet = 0.3048 * Math.pow(10,9);
//    public static final double mile = 1609.344 * Math.pow(10,9);
//    public static final double nauticalMile = 1852 * Math.pow(10,9);
//    public static final double parsec = 3.08567758 * Math.pow(10,16) * Math.pow(10,9);
//    public static final double nanometer = Math.pow(10,0);
//    public static final double micrometer = Math.pow(10,3);
//    public static final double millimeter = Math.pow(10,6);
//    public static final double centimeter = Math.pow(10,7);
//    public static final double decimeter = Math.pow(10,8);
//    public static final double meter = Math.pow(10,9);
//    public static final double dekameter = Math.pow(10,10);
//    public static final double hectometer = Math.pow(10,11);
//    public static final double kilometer = Math.pow(10,12);

    public static final Unit inch = new Unit("in", 0.0254 * Math.pow(10,9));
    public static final Unit yard = new Unit("yd", 0.9144 * Math.pow(10,9));
    public static final Unit feet = new Unit("ft", 0.3048 * Math.pow(10,9));
    public static final Unit mile = new Unit("mile", 1609.344 * Math.pow(10,9));
    public static final Unit nauticalMile = new Unit("n mile", 1852 * Math.pow(10,9));
    public static final Unit parsec = new Unit("", 3.08567758 * Math.pow(10,16) * Math.pow(10,9));
    public static final Unit nanometer = new Unit("nm", Math.pow(10,0));
    public static final Unit micrometer = new Unit("µm", Math.pow(10,3));
    public static final Unit millimeter = new Unit("mm", Math.pow(10,6));
    public static final Unit centimeter = new Unit("cm", Math.pow(10,7));
    public static final Unit decimeter = new Unit("dcm", Math.pow(10,8));
    public static final Unit meter = new Unit("m", Math.pow(10,9));
    public static final Unit dekameter = new Unit("dkm", Math.pow(10,10));
    public static final Unit hectometer = new Unit("hm", Math.pow(10,11));
    public static final Unit kilometer = new Unit("km", Math.pow(10,12));

    public static final ArrayList<Unit> Units = new ArrayList<Unit>(){
        {
            add(inch);
            add(yard);
            add(feet);
            add(mile);
            add(nauticalMile);
            add(parsec);
            add(nanometer);
            add(micrometer);
            add(millimeter);
            add(centimeter);
            add(decimeter);
            add(meter);
            add(dekameter);
            add(hectometer);
            add(kilometer);
        }
    };


    public static double a = feet.toSmallestUnit;
    public static double b = centimeter.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }

    public static void main(String[] args) {
        System.out.println(result(1));
    }

}