package mode.conversion;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Energy {
//    public static final double volts = 1;
//    public static final double joules = 6.24150913 * Math.pow(10,18);
//    public static final double kilojoules = joules * Math.pow(10,3);
//    public static final double thermalCalories = 2.61144742 * Math.pow(10,19);
//    public static final double foodCalories = thermalCalories * Math.pow(10,3);
//    public static final double footPounds = 8.4623501 * Math.pow(10,18);
//    public static final double britishThermalUnits = 6.58514073 * Math.pow(10,21);

    public static final Unit volts = new Unit("V", 1);
    public static final Unit joules = new Unit("J", 6.24150913 * Math.pow(10,18));
    public static final Unit kilojoules = new Unit("kJ", joules.toSmallestUnit * Math.pow(10,3));
    public static final Unit thermalCalories = new Unit("cal", 2.61144742 * Math.pow(10,19));
    public static final Unit foodCalories = new Unit("kcal", thermalCalories.toSmallestUnit * Math.pow(10,3));
    public static final Unit footPounds = new Unit("ft-lb", 8.4623501 * Math.pow(10,18));
    public static final Unit britishThermalUnits = new Unit("BTU", 6.58514073 * Math.pow(10,21));

    public static final ArrayList<Unit> energyUnits = new ArrayList<Unit>(){
        {
            add(volts);
            add(joules);
            add(kilojoules);
            add(thermalCalories);
            add(foodCalories);
            add(footPounds);
            add(britishThermalUnits);
        }
    };

    public static LinkedHashMap<String, Unit> unitsMap = new LinkedHashMap <String, Unit>() {
        {
            put("V", volts);
            put("J", joules);
            put("kJ", kilojoules);
            put("cal", thermalCalories);
            put("kcal", foodCalories);
            put("ft-lb", footPounds);
            put("BTU", britishThermalUnits);
        }
    };

    public static double convert(Unit fromUnit , Unit toUnit , double n) {
        return n * fromUnit.toSmallestUnit * (1 / toUnit.toSmallestUnit);
    }


    public static double a = footPounds.toSmallestUnit;
    public static double b = kilojoules.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }

    public static void main(String[] args) {
        System.out.println(result(1));
    }
}
