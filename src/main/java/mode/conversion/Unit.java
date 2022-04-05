package mode.conversion;

public class Unit {
    public String name;
    public double toSmallestUnit;

    public Unit () {}
    public Unit (String name, double toSmallestUnit) {
        this.name = name;
        this.toSmallestUnit = toSmallestUnit;
    }

}
