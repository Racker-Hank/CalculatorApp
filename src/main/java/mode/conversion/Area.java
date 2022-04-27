package mode.conversion;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Area {
//    public static final double squareMillimeters = 1;
//    public static final double squareCentimeters = Math.pow(10,2);
//    public static final double squareMeters = Math.pow(10,6);
//    public static final double squareKilometers = Math.pow(10,12);
//    public static final double squareInches = 645.16;
//    public static final double squareFeet = 92903.04;
//    public static final double squareYards = 836127.36;
//    public static final double squareMiles = 2589988 * Math.pow(10,6) + 110336;
//    public static final double hectares = Math.pow(10,10);
//    public static final double acres = 4046856422.4;

    public static final Unit squareMillimeters = new Unit("mm²", 1);
    public static final Unit squareCentimeters = new Unit("cm²", Math.pow(10,2));
    public static final Unit squareMeters = new Unit("m²", Math.pow(10,6));
    public static final Unit squareKilometers = new Unit("km²", Math.pow(10,12));
    public static final Unit squareInches = new Unit("in²", 645.16);
    public static final Unit squareFeet = new Unit("ft²", 92903.04);
    public static final Unit squareYards = new Unit("yd²", 836127.36);
    public static final Unit squareMiles = new Unit("mile²", 2589988 * Math.pow(10,6) + 110336);
    public static final Unit hectares = new Unit("ha", Math.pow(10,10));
    public static final Unit acres = new Unit("acre", 4046856422.4);

    public static final ArrayList<Unit> areaUnits = new ArrayList<Unit>(){
        {
            add(squareMillimeters);
            add(squareCentimeters);
            add(squareMeters);
            add(squareKilometers);
            add(squareInches);
            add(squareFeet);
            add(squareYards);
            add(squareMiles);
            add(hectares);
            add(acres);
        }
    };

    public static LinkedHashMap <String, Unit> unitsMap = new LinkedHashMap<String, Unit>(){
        {
            put("mm²", squareMillimeters);
            put("cm²", squareCentimeters);
            put("m²", squareMeters);
            put("km²", squareKilometers);
            put("in²", squareInches);
            put("ft²", squareFeet);
            put("yd²", squareYards);
            put("mile²", squareMiles);
            put("ha", hectares);
            put("acre", acres);
        }
    };

    public static double a = squareCentimeters.toSmallestUnit;
    public static double b = squareInches.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }


}
