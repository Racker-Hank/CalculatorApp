package mode.conversion;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Speed {

    public static final Unit centimeterPerSeconds = new Unit("cm/s",1);
    public static final Unit metersPerSeconds = new Unit("m/s", Math.pow(10,2));
    public static final Unit kilometersPerHour = new Unit("km/h",(1 / 3.6) * metersPerSeconds.toSmallestUnit);
    public static final Unit feetsPerSecond = new Unit("f/s",30.48);
    public static final Unit milesPerHour = new Unit("mile/h",44.7);
    public static final Unit knots = new Unit("knots",51.44);
    public static final Unit mach = new Unit("mach",34030);

    public static final ArrayList<Unit> speedUnits = new ArrayList<Unit>(){
        {
            add(centimeterPerSeconds);
            add(metersPerSeconds);
            add(kilometersPerHour);
            add(feetsPerSecond);
            add(milesPerHour);
            add(knots);
            add(mach);
        }
    };

    public static LinkedHashMap <String, Unit> unitsMap = new LinkedHashMap <String, Unit>() {
        {
            put("cm/s", centimeterPerSeconds);
            put("m/s", metersPerSeconds);
            put("km/h", kilometersPerHour);
            put("f/s", feetsPerSecond);
            put("mile/h", milesPerHour);
            put("knots", knots);
            put("mach", mach);
        }
    };

    public static double convert(Unit fromUnit , Unit toUnit , double n) {
        return n * fromUnit.toSmallestUnit * (1 / toUnit.toSmallestUnit);
    }

    public static double a = feetsPerSecond.toSmallestUnit ;
    public static double b = centimeterPerSeconds.toSmallestUnit;

    public static double results (double num) {
        return num * a * (1 / b);
    }

    public static void main(String[] args) {
        System.out.println(results(1));
    }
}


