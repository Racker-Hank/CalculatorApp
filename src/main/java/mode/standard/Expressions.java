package mode.standard;

import inputHandler.MathUtil;
import mode.Function;
import mode.Function2;
import mode.standard.expressions.Sin;
import operation.Operand;

import java.util.ArrayList;

public class Expressions extends Operand {
    public static ArrayList <Function2> functions = new ArrayList <Function2>();

    public static Sin sin = new Sin();

    @Override
    public void display() {

    }

    public Expressions() {
        functions.add(sin);
    }

    //    public static Function sin;
    //
    //    static {
    //        try {
    //            sin = new Function("sin(x)", "calculate sin(x)" new Function(), MathUtil.class.getMethod("sinRadians",
    //                    new Class[] { double.class }));
    //            functions.add(sin);
    //        } catch (NoSuchMethodException e) {
    //            e.printStackTrace();
    //        }
    //    }
    //    public static class Sin extends Function {
    //
    //    }
}
