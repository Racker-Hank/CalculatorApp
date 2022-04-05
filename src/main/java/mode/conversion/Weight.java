package mode.conversion;

import java.util.ArrayList;

public class Weight {
//    public static final double carats = 200;
//    public static final double milligrams = 1;
//    public static final double centigrams = Math.pow(10,1);
//    public static final double decigrams = Math.pow(10,2);
//    public static final double grams = Math.pow(10,3);
//    public static final double dekagrams = Math.pow(10,4);
//    public static final double hectograms = Math.pow(10,5);
//    public static final double kilograms = Math.pow(10,6);
//    public static final double metricTonnes = Math.pow(10,9);
//    public static final double ounces = 28349.5231;
//    public static final double pounds = 453592.37;
//    public static final double stone = 6350293.18;
//    public static final double shortTonsUS = 907184740;
//    public static final double longTonUS = 1.01604691 * Math.pow(10,9);

    public static final Unit carats = new Unit("", 200);
    public static final Unit milligrams = new Unit("mg", 1);
    public static final Unit centigrams = new Unit("cg", Math.pow(10,1));
    public static final Unit decigrams = new Unit("dcg", Math.pow(10,2));
    public static final Unit grams = new Unit("g", Math.pow(10,3));
    public static final Unit dekagrams = new Unit("dkg", Math.pow(10,4));
    public static final Unit hectograms = new Unit("hg", Math.pow(10,5));
    public static final Unit kilograms = new Unit("kg", Math.pow(10,6));
    public static final Unit metricTonnes = new Unit("", Math.pow(10,9));
    public static final Unit ounces = new Unit("oz", 28349.5231);
    public static final Unit pounds = new Unit("lb", 453592.37);
    public static final Unit stone = new Unit("st", 6350293.18);
    public static final Unit shortTonsUS = new Unit("tn", 907184740);
    public static final Unit longTonUS = new Unit("", 1.01604691 * Math.pow(10,9));

    public static final ArrayList<Unit> Units = new ArrayList<Unit>(){
        {
            add(carats);
            add(milligrams);
            add(centigrams);
            add(decigrams);
            add(grams);
            add(dekagrams);
            add(hectograms);
            add(kilograms);
            add(metricTonnes);
            add(ounces);
            add(pounds);
            add(stone);
            add(shortTonsUS);
            add(longTonUS);
        }
    };


    public static double a = ounces.toSmallestUnit;
    public static double b = grams.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }
}
