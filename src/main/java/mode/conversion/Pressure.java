package mode.conversion;

import java.util.ArrayList;

public class Pressure {
//    public static final double Atmospheres = 1;
//    public static final double Bars = 0.986923;
//    public static final double pascals = 9.86923267 * Math.pow(10,6);
//    public static final double kilopascals = 9.86923267 * Math.pow(10,9);
//    public static final double milimetersOfMercury = 0.00131578947;

    public static final Unit Atmospheres = new Unit("", 1);
    public static final Unit Bars = new Unit("", 0.986923);
    public static final Unit pascals = new Unit("", 9.86923267 * Math.pow(10,6));
    public static final Unit kilopascals = new Unit("", 9.86923267 * Math.pow(10,9));
    public static final Unit milimetersOfMercury = new Unit("", 0.00131578947);

    public static final ArrayList<Unit> Units = new ArrayList<Unit>(){
        {
            add(Atmospheres);
            add(Bars);
            add(pascals);
            add(kilopascals);
            add(milimetersOfMercury);
        }
    };

    public static double a = Atmospheres.toSmallestUnit;
    public static double b = Bars.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }

    public static void main(String[] args) {
        System.out.println(result(10));
    }
}
