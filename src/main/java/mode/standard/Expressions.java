package mode.standard;

import inputHandler.MathUtil;
import mode.Function;
import operation.Operand;

import java.util.ArrayList;

public class Expressions extends Operand {
    public static ArrayList <Function> functions = new ArrayList <Function>();

    @Override
    public void display() {

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
