package mode.equation;

import mode.Mode;

public class Equation extends Mode {
    public String name = "Equation";

    public static Mode solve = new Solve();
    public Equation() {
        childModes.add(solve);
    }

}
