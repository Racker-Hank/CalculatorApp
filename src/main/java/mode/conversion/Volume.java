package mode.conversion;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Volume {

//    public static final double milliliters = 1;
//    public static final double cubicCentimeters = 1;
//    public static final double liters = Math.pow(10,3);
//    public static final double cubicMeters = Math.pow(10,6);
//    public static final double teaSpoonsUS = 4.92892159;
//    public static final double tableSpoonUS = 14.7867648;
//    public static final double fluidOuncesUS = 29.5735296;
//    public static final double cupsUS = 236.588237;
//    public static final double pintsUS = 473.176473;
//    public static final double quartsUS = 946.352946;
//    public static final double gallonsUS = 3785.41178;
//    public static final double cubicInches = 16.387064;
//    public static final double cubicFeet = 28316.8466;
//    public static final double cubicYards = 764554.858;

    public static final Unit milliliters = new Unit("m\uD835\uDC59", 1);
    public static final Unit cubicCentimeters = new Unit("cm³", 1);
    public static final Unit liters = new Unit("𝑙", Math.pow(10,3));
    public static final Unit cubicMeters = new Unit("m³", Math.pow(10,6));
    public static final Unit teaSpoonsUS = new Unit("tsp(US)", 4.92892159);
    public static final Unit tableSpoonUS = new Unit("tbsp(US)", 14.7867648);
    public static final Unit fluidOuncesUS = new Unit("fl oz(US)", 29.5735296);
    public static final Unit cupsUS = new Unit("c (US)", 236.588237);
    public static final Unit pintsUS = new Unit("pt(US)", 473.176473);
    public static final Unit quartsUS = new Unit("qt(US)", 946.352946);
    public static final Unit gallonsUS = new Unit("gal(US)", 3785.41178);
    public static final Unit cubicInches = new Unit("in³", 16.387064);
    public static final Unit cubicFeet = new Unit("ft³", 28316.8466);
    public static final Unit cubicYards = new Unit("yd³", 764554.858);

    public static final ArrayList<Unit> volumeUnits = new ArrayList<Unit>(){
        {
            add(milliliters);
            add(cubicCentimeters);
            add(liters);
            add(cubicMeters);
            add(teaSpoonsUS);
            add(tableSpoonUS);
            add(fluidOuncesUS);
            add(cupsUS);
            add(pintsUS);
            add(quartsUS);
            add(gallonsUS);
            add(cubicInches);
            add(cubicFeet);
            add(cubicYards);
        }
    };

    public static LinkedHashMap <String, Unit> unitsMap = new LinkedHashMap <String, Unit>() {
        {
            put("m\uD835\uDC59", milliliters);
            put("cm³", cubicCentimeters);
            put("𝑙", liters);
            put("m³", cubicMeters);
            put("tsp (US)", teaSpoonsUS);
            put("tbsp (US)", tableSpoonUS);
            put("fl oz (US)", fluidOuncesUS);
            put("c  (US)", cupsUS);
            put("pt (US)", pintsUS);
            put("qt (US)", quartsUS);
            put("gal (US)", gallonsUS);
            put("in³", cubicInches);
            put("ft³", cubicFeet);
            put("yd³", cubicYards);
        }
    };

    public static double a = liters.toSmallestUnit;
    public static double b = pintsUS.toSmallestUnit;

    public static double convert(Unit fromUnit , Unit toUnit , double n) {
        return n * fromUnit.toSmallestUnit * (1 / toUnit.toSmallestUnit);
    }

    public static double result (double num) {
        return num * a * (1 / b);
    }

}
