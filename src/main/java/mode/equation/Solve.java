package mode.equation;

import mode.Mode;

public class Solve extends Mode {
    public String name = "Solve";

    public static Mode solveEquation = new SolveEquation();
    public static Mode solveInequation = new SolveInequation();

    public Solve() {
        childModes.add(solveEquation);
        childModes.add(solveInequation);
    }


}
