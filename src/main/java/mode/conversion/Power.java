package mode.conversion;

import java.util.ArrayList;

public class Power {
//    public static final double watts = 1;
//    public static final double kilowatts = Math.pow(10,3);
//    public static final double housepower = 1 / 745.69987158227022;
//    public static final double foot_poundsPerMinute = 0.0225969658;
//    public static final double BTUsPerMinute = 17.5842642;

    public static final Unit watts = new Unit("W", 1);
    public static final Unit kilowatts = new Unit("kW", Math.pow(10,3));
    public static final Unit housepower = new Unit("hp", 1 / 745.69987158227022);
    public static final Unit foot_poundsPerMinute = new Unit("ft-lb/min", 0.0225969658);
    public static final Unit BTUsPerMinute = new Unit("Btu/min", 17.5842642);

    public static final ArrayList<Unit> powerUnits = new ArrayList<Unit>(){
        {
            add(watts);
            add(kilowatts);
            add(housepower);
            add(foot_poundsPerMinute);
            add(BTUsPerMinute);
        }
    };

    public static double a = watts.toSmallestUnit;
    public static double b = kilowatts.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }

}
