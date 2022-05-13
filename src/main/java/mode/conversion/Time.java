package mode.conversion;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Time {
//    public static final double microseconds = 1;
//    public static final double milliseconds = Math.pow(10,1);
//    public static final double seconds = Math.pow(10,2);
//    public static final double minutes = 60 * seconds;
//    public static final double hours = 60 * minutes;
//    public static final double days = 24 * hours;
//    public static final double weeks = 7 * days;

    public static final Unit microseconds = new Unit("µs", 1);
    public static final Unit milliseconds = new Unit("ms", Math.pow(10,1));
    public static final Unit seconds = new Unit("s", Math.pow(10,2));
    public static final Unit minutes = new Unit("min", 60 * seconds.toSmallestUnit);
    public static final Unit hours = new Unit("h", 60 * minutes.toSmallestUnit);
    public static final Unit days = new Unit("days", 24 * hours.toSmallestUnit);
    public static final Unit weeks = new Unit("weeks", 7 * days.toSmallestUnit);

    public static final ArrayList<Unit> timeUnits = new ArrayList<Unit>(){
        {
            add(microseconds);
            add(milliseconds);
            add(seconds);
            add(minutes);
            add(hours);
            add(days);
            add(weeks);
        }
    };

    public static LinkedHashMap<String, Unit> unitsMap = new LinkedHashMap <String, Unit>() {
        {
            put("µs", microseconds);
            put("ms", milliseconds);
            put("s", seconds);
            put("min", minutes);
            put("h", hours);
            put("days", days);
            put("weeks", weeks);
        }
    };

    public static double convert(Unit fromUnit , Unit toUnit , double n) {
        return n * fromUnit.toSmallestUnit * (1 / toUnit.toSmallestUnit);
    }

    public static double a = weeks.toSmallestUnit;
    public static double b = minutes.toSmallestUnit;

    public static double results (double num) {
        return num * a * (1 / b);
    }

}
