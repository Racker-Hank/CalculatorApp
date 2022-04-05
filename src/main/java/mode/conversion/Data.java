package mode.conversion;

import java.util.ArrayList;

public class Data {
//    public static final double bits = 1;
//    public static final double bytes = 8;
//    public static final double kilobits = 1000;
//    public static final double kibibits = 1024;
//    public static final double kilobytes = 8 * kilobits;
//    public static final double kibibytes = 8 * kibibits;
//    public static final double megabits = 1000 * kilobits;
//    public static final double mebibits = 1024 * kibibits;
//    public static final double megabytes = 8 * megabits;
//    public static final double mebibytes = 8 * mebibits;
//    public static final double gigabits = 1000 * megabits;
//    public static final double gibibits = 1024 * mebibits;
//    public static final double gigabytes = 8 * gigabits;
//    public static final double gibibytes = 8 * gibibits;
//    public static final double terabits = 1000 * gibibits;
//    public static final double tebibits = 1024 * gibibits;
//    public static final double terabytes = 8 * terabits;
//    public static final double tebibytes = 8 * tebibits;
//    public static final double petabits = 1000 * terabits;
//    public static final double pebibits = 1024 * tebibits;
//    public static final double petabytes = 8 * petabits;
//    public static final double pebibytes = 8 * pebibits;

    public static final Unit bits = new Unit("b", 1);
    public static final Unit bytes = new Unit("B", 8);
    public static final Unit kilobits = new Unit("Kb", 1000);
    public static final Unit kibibits = new Unit("Kib", 1024);
    public static final Unit kilobytes = new Unit("KB", 8 * kilobits.toSmallestUnit);
    public static final Unit kibibytes = new Unit("KiB", 8 * kibibits.toSmallestUnit);
    public static final Unit megabits = new Unit("Mb", 1000 * kilobits.toSmallestUnit);
    public static final Unit mebibits = new Unit("Mib", 1024 * kibibits.toSmallestUnit);
    public static final Unit megabytes = new Unit("MB", 8 * megabits.toSmallestUnit);
    public static final Unit mebibytes = new Unit("MiB", 8 * mebibits.toSmallestUnit);
    public static final Unit gigabits = new Unit("Gb", 1000 * megabits.toSmallestUnit);
    public static final Unit gibibits = new Unit("Gib", 1024 * mebibits.toSmallestUnit);
    public static final Unit gigabytes = new Unit("GB", 8 * gigabits.toSmallestUnit);
    public static final Unit gibibytes = new Unit("GiB", 8 * gibibits.toSmallestUnit);
    public static final Unit terabits = new Unit("Tb", 1000 * gibibits.toSmallestUnit);
    public static final Unit tebibits = new Unit("Tib", 1024 * gibibits.toSmallestUnit);
    public static final Unit terabytes = new Unit("TB", 8 * terabits.toSmallestUnit);
    public static final Unit tebibytes = new Unit("TiB", 8 * tebibits.toSmallestUnit);
    public static final Unit petabits = new Unit("Pb", 1000 * terabits.toSmallestUnit);
    public static final Unit pebibits = new Unit("Pib", 1024 * tebibits.toSmallestUnit);
    public static final Unit petabytes = new Unit("PB", 8 * petabits.toSmallestUnit);
    public static final Unit pebibytes = new Unit("PiB", 8 * pebibits.toSmallestUnit);

    public static final ArrayList<Unit> dataUnits = new ArrayList<Unit>(){
        {
            add(bits);
            add(bytes);
            add(kilobits);
            add(kibibits);
            add(kilobytes);
            add(kibibytes);
            add(megabits);
            add(mebibits);
            add(megabytes);
            add(mebibytes);
            add(gigabits);
            add(gibibits);
            add(gigabytes);
            add(gibibytes);
            add(terabits);
            add(tebibits);
            add(terabytes);
            add(tebibytes);
            add(petabits);
            add(pebibits);
            add(petabytes);
            add(pebibytes);
        }
    };

    public static double a = kibibits.toSmallestUnit;
    public static double b = mebibytes.toSmallestUnit;

    public static double result (double num) {
        return num * a * (1 / b);
    }
}
