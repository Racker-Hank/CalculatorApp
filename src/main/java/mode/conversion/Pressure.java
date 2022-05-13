package mode.conversion;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Pressure {
//    public static final double Atmospheres = 1;
//    public static final double Bars = 0.986923;
//    public static final double pascals = 9.86923267 * Math.pow(10,6);
//    public static final double kilopascals = 9.86923267 * Math.pow(10,9);
//    public static final double milimetersOfMercury = 0.00131578947;

    public static final Unit Atmospheres = new Unit("atm", 1);
    public static final Unit Bars = new Unit("bar", 0.986923);
    public static final Unit pascals = new Unit("Pa", 9.86923267 * Math.pow(10,6));
    public static final Unit kilopascals = new Unit("kPa", 9.86923267 * Math.pow(10,9));
    public static final Unit milimetersOfMercury = new Unit("mmHg", 0.00131578947);

    public static final ArrayList<Unit> pressureUnits = new ArrayList<Unit>(){
        {
            add(Atmospheres);
            add(Bars);
            add(pascals);
            add(kilopascals);
            add(milimetersOfMercury);
        }
    };

    public static LinkedHashMap<String, Unit> unitsMap = new LinkedHashMap <String, Unit>() {
        {
            put("atm", Atmospheres);
            put("bar", Bars);
            put("Pa", pascals);
            put("kPa", kilopascals);
            put("mmHg", milimetersOfMercury);
        }
    };

    public static double convert(Unit fromUnit , Unit toUnit , double n) {
        return n * fromUnit.toSmallestUnit * (1 / toUnit.toSmallestUnit);
    }

    public static double a = Atmospheres.toSmallestUnit;
    public static double b = Bars.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }

    public static void main(String[] args) {
        System.out.println(result(10));
    }
}
