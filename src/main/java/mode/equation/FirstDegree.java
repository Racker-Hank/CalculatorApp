package mode.equation;

import inputHandler.MathUtil;
import operation.Fraction;

public class FirstDegree extends Degree{
    public String name = "First Degree";

    public void equal (Fraction a, Fraction b) {
        solutions.clear();
        if (a.toDouble() == 0) {
//            throw Exception;
//            System.out.println("a cannot be zero");
        }
        else {
            solutions.add((MathUtil.divide(MathUtil.multiply(new Fraction(-1),b), a)).simplify());
            solutionString = "𝑥 = " + solutions.get(0).toDouble();
        }
    }
    // >= ax + b >= 0 => x >= -b/a
    public void notSmaller (Fraction a, Fraction b) {
//        if (a.toDouble() == 0) {
////            throw Exception;
//            System.out.println("a cannot be zero");
//            System.exit(0);
//        }
//        Fraction x =  (MathUtil.divide(MathUtil.multiply(new Fraction(-1),b), a)).simplify();
        equal(a,b);
        Fraction x = solutions.get(0);
        if ( a.toDouble() > 0) {
//            System.out.println("x ∈ " + "[" + x.toDouble() + ", +∞)");
            solutionString = "\uD835\uDC65 ∈ " + "[" + x.toDouble() + ", +∞)";
        }
        else {
//            System.out.println("x ∈ " + "(-∞," + x.toDouble() + "]");
            solutionString = "\uD835\uDC65 ∈ " + "(-∞," + x.toDouble() + "]";
        }
    }

    public void notGreater (Fraction a, Fraction b) {
//        if (a.toDouble() == 0) {
////            throw Exception;
//            System.out.println("a cannot be zero");
//            System.exit(0);
//        }
//        Fraction x =  (MathUtil.divide(MathUtil.multiply(new Fraction(-1),b), a)).simplify();
        equal(a,b);
        Fraction x = solutions.get(0);
        if ( a.toDouble() > 0) {
//            System.out.println("x ∈ " + "(-∞," + x.toDouble() + "]");
            solutionString = "\uD835\uDC65 ∈ " + "(-∞," + x.toDouble() + "]";
        }
        else {
//            System.out.println("x ∈ " + "[" + x.toDouble() + ", +∞)");
            solutionString = "\uD835\uDC65 ∈ " + "[" + x.toDouble() + ", +∞)";
        }
    }

    public void smaller (Fraction a, Fraction b) {
        equal(a,b);
        Fraction x = solutions.get(0);
        if ( a.toDouble() > 0) {
//            System.out.println("x ∈ " + "(-∞," + x.toDouble() + ")");
            solutionString = "\uD835\uDC65 ∈ " + "(-∞," + x.toDouble() + ")";
        }
        else {
//            System.out.println("x ∈ " + "(" + x.toDouble() + ", +∞)");
            solutionString = "\uD835\uDC65 ∈ " + "(" + x.toDouble() + ", +∞)";
        }
    }

    public void greater (Fraction a, Fraction b) {
        equal(a,b);
        Fraction x = solutions.get(0);
        if ( a.toDouble() > 0) {
//            System.out.println("x ∈ " + "(" + x.toDouble() + ", +∞)");
            solutionString = "\uD835\uDC65 ∈ " + "(" + x.toDouble() + ", +∞)";
        }
        else {
//            System.out.println("x ∈ " + "(-∞," + x.toDouble() + ")");
            solutionString = "\uD835\uDC65 ∈ " + "(-∞," + x.toDouble() + ")";
        }
    }

    public static void main(String[] args) {
        Fraction a = new Fraction(1);
        Fraction b = new Fraction(3);
        FirstDegree test = new FirstDegree();
        test.notSmaller(a,b);
        test.notGreater(b,a);
    }
}
