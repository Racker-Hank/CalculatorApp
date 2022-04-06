package mode.equation;

import inputHandler.MathUtil;
import operation.Fraction;

import java.util.ArrayList;

public class FirstDegree extends Degree {
    public String name = "First Degree";

    public void solveEqual (Fraction a, Fraction b) {
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }
        else {
            solutions.add((MathUtil.divide(MathUtil.multiply(new Fraction(-1),b), a)).simplify());
        }
    }
    // >= ax + b >= 0 => x >= -b/a
    public void notSmaller (Fraction a, Fraction b) {
        if ( a.toDouble() > 0) {
            solutions.add((MathUtil.divide(MathUtil.multiply(new Fraction(-1),b), a)).simplify());
            System.out.print("[,+∞");
        }
    }

    public void solveInEqual(Fraction a, Fraction b) {
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }

    }

    public static void main(String[] args) {
        Fraction a = new Fraction(66);
        Fraction b = new Fraction(3);
        FirstDegree test = new FirstDegree();
        test.notSmaller(a,b);
        for (Fraction solution: test.solutions) {
            System.out.print(solution.toDouble());

        }

    }
}
