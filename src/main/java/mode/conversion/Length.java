package mode.conversion;

import javafx.scene.control.SplitPane;

import java.util.LinkedHashMap;

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

    public static final Unit inch = new Unit("in" , 0.0254 * Math.pow(10 , 9));
    public static final Unit yard = new Unit("yd" , 0.9144 * Math.pow(10 , 9));
    public static final Unit feet = new Unit("ft" , 0.3048 * Math.pow(10 , 9));
    public static final Unit mile = new Unit("mile" , 1609.344 * Math.pow(10 , 9));
    public static final Unit nauticalMile = new Unit("n mile" , 1852 * Math.pow(10 , 9));
    public static final Unit parsec = new Unit("pc" , 3.08567758 * Math.pow(10 , 16) * Math.pow(10 , 9));
    public static final Unit nanometer = new Unit("nm" , Math.pow(10 , 0));
    public static final Unit micrometer = new Unit("µm" , Math.pow(10 , 3));
    public static final Unit millimeter = new Unit("mm" , Math.pow(10 , 6));
    public static final Unit centimeter = new Unit("cm" , Math.pow(10 , 7));
    public static final Unit decimeter = new Unit("dm" , Math.pow(10 , 8));
    public static final Unit meter = new Unit("m" , Math.pow(10 , 9));
    public static final Unit decameter = new Unit("dam" , Math.pow(10 , 10));
    public static final Unit hectometer = new Unit("hm" , Math.pow(10 , 11));
    public static final Unit kilometer = new Unit("km" , Math.pow(10 , 12));

    //    public static final ArrayList<Unit> lengthUnits = new ArrayList<Unit>(){
    //        {
    //            add(inch);
    //            add(yard);
    //            add(feet);
    //            add(mile);
    //            add(nauticalMile);
    //            add(parsec);
    //            add(nanometer);
    //            add(micrometer);
    //            add(millimeter);
    //            add(centimeter);
    //            add(decimeter);
    //            add(meter);
    //            add(dekameter);
    //            add(hectometer);
    //            add(kilometer);
    //        }
    //    };

    public static LinkedHashMap <String, Unit> unitsMap = new LinkedHashMap <String, Unit>() {
        {
            put("in" , inch);
            put("yd" , yard);
            put("ft" , feet);
            put("mile" , mile);
            put("nm" , nanometer);
            put("µm" , micrometer);
            put("mm" , millimeter);
            put("cm" , centimeter);
            put("dm" , decimeter);
            put("m" , meter);
            put("dam" , decameter);
            put("hm" , hectometer);
            put("km" , kilometer);
            put("n mile" , nauticalMile);
            put("pc" , parsec);
        }
    };

    public static double a = feet.toSmallestUnit;
    public static double b = centimeter.toSmallestUnit;

    public static double result(double num) {
        return num * a * (1 / b);
    }

    public static double convert(Unit fromUnit , Unit toUnit , double n) {
        return n * fromUnit.toSmallestUnit * (1 / toUnit.toSmallestUnit);
    }

    public static void main(String[] args) {
        System.out.println(result(1));
    }

}
