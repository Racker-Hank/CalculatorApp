package mode.conversion;

import java.util.ArrayList;

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

    public static final Unit milliliters = new Unit("ml", 1);
    public static final Unit cubicCentimeters = new Unit("cm³", 1);
    public static final Unit liters = new Unit("l", Math.pow(10,3));
    public static final Unit cubicMeters = new Unit("m³", Math.pow(10,6));
    public static final Unit teaSpoonsUS = new Unit("", 4.92892159);
    public static final Unit tableSpoonUS = new Unit("", 14.7867648);
    public static final Unit fluidOuncesUS = new Unit("", 29.5735296);
    public static final Unit cupsUS = new Unit("", 236.588237);
    public static final Unit pintsUS = new Unit("", 473.176473);
    public static final Unit quartsUS = new Unit("", 946.352946);
    public static final Unit gallonsUS = new Unit("", 3785.41178);
    public static final Unit cubicInches = new Unit("in³", 16.387064);
    public static final Unit cubicFeet = new Unit("ft³", 28316.8466);
    public static final Unit cubicYards = new Unit("yd³", 764554.858);

    public static final ArrayList<Unit> Units = new ArrayList<Unit>(){
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


    public static double a = liters.toSmallestUnit;
    public static double b = pintsUS.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }

}
