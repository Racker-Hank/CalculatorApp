package mode.standard;

import inputHandler.MathUtil;
import javafx.scene.layout.Pane;
import mode.Function;
import mode.Function2;
import mode.standard.expressions.Cos;
import mode.standard.expressions.Sin;
import mode.standard.expressions.Tan;
import operation.Operand;

import java.util.ArrayList;

public class Expressions extends Operand {
    public static ArrayList <Function2> functions = new ArrayList <Function2>();

    public static Sin sin = new Sin();
    public static Cos cos = new Cos();
    public static Tan tan = new Tan();

    @Override
    public void addToAnchorPane(Pane parentPane) {

    }

    public Expressions() {
        functions.add(sin);
        functions.add(cos);
        functions.add(tan);
    }
}
