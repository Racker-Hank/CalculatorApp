package mode.equation;

import inputHandler.MathUtil;
import operation.Fraction;

public class SecondDegree extends Degree {
    public String name = "Second Degree";

    public void equal (Fraction a, Fraction b, Fraction c) {
        solutions.clear();
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
            solutionString = "a cannot be zero";
        }
        else {
            Fraction Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(4),a),c));
            if (Δ.toDouble() == 0) {
                solutions.add(MathUtil.divide(MathUtil.multiply(new Fraction(-1),b),MathUtil.multiply(new Fraction(2),a)));
                solutionString = "𝑥 = " + solutions.get(0).toDouble();
            }
            else if (Δ.toDouble() > 0) {
                Fraction x = new Fraction(Δ.toDouble());
                x.numerator = Math.sqrt(x.numerator);
                solutions.add(MathUtil.divide(MathUtil.add(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a)));
                solutions.add(MathUtil.divide(MathUtil.subtract(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a)));
                solutionString = "𝑥 = " + solutions.get(0).toDouble() + " or " + solutions.get(1).toDouble();
            }
        }
    }

    public void smaller (Fraction a, Fraction b, Fraction c) {
//        if (a.toDouble() == 0) {
////            throw Exception;
//            System.out.println("a cannot be zero");
//        }
//        else {
//            Fraction Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(4),a),c));

        equal(a,b,c);
        if (solutions.size() == 1) {
            Fraction x = MathUtil.divide(MathUtil.multiply(new Fraction(-1),b),MathUtil.multiply(new Fraction(2),a));
            System.out.println("x ∈ " + "(-∞," + x.toDouble() + ") U (" + x.toDouble() + ", +∞)");
            solutionString = "\uD835\uDC65 ∈ " + "(-∞," + x.toDouble() + ") ∪ (" + x.toDouble() + ", +∞)";
        }

        else if (solutions.size() > 1) {
//            Fraction x = new Fraction(Δ.toDouble());
//            x.numerator = Math.sqrt(x.numerator);
//
//            Fraction x2 = MathUtil.divide(MathUtil.add(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
//            Fraction x1 = MathUtil.divide(MathUtil.subtract(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));

            Fraction x1 = solutions.get(1);
            Fraction x2 = solutions.get(0);
            if (a.toDouble() > 0) {
                System.out.println("x ∈ " + "(" + x1.toDouble() + ", " + x2.toDouble() + ")");
                solutionString = "\uD835\uDC65 ∈ " + "(" + x1.toDouble() + ", " + x2.toDouble() + ")";
            }
            else {
                System.out.println("x ∈ " + "(-∞, " + x2.toDouble() + ") U (" + x1.toDouble() + ", +∞)");
                solutionString = "\uD835\uDC65 ∈ " + "(-∞, " + x2.toDouble() + ") ∪ (" + x1.toDouble() + ", +∞)";
            }
        }
    }

    public void greater (Fraction a, Fraction b, Fraction c) {
        equal(a,b,c);
        if (solutions.size() == 1) {
            Fraction x = MathUtil.divide(MathUtil.multiply(new Fraction(-1),b),MathUtil.multiply(new Fraction(2),a));
            System.out.println("x ∈ " + "(-∞," + x.toDouble() + ") U (" + x.toDouble() + ", +∞)");
            solutionString = "\uD835\uDC65 ∈ " + "(-∞," + x.toDouble() + ") ∪ (" + x.toDouble() + ", +∞)";
        }
        else if (solutions.size() > 1) {
            Fraction x1 = solutions.get(1);
            Fraction x2 = solutions.get(0);
            if (a.toDouble() > 0) {
                System.out.println("x ∈ " + "(-∞, " + x1.toDouble() + ") ∪ (" + x2.toDouble() + ", +∞)");
                solutionString = "\uD835\uDC65 ∈ " + "(-∞, " + x1.toDouble() + ") ∪ (" + x2.toDouble() + ", +∞)";
            }
            else {
                System.out.println("x ∈ " + "(" + x2.toDouble() + ", " + x1.toDouble() + ")");
                solutionString = "\uD835\uDC65 ∈ " + "(" + x2.toDouble() + ", " + x1.toDouble() + ")";
            }
        }
    }

    public void notSmaller (Fraction a, Fraction b, Fraction c) {
        equal(a,b,c);
        if (solutions.size() == 1) {
            System.out.println("x ∈ " + "(-∞, +∞)");
        }
        else if (solutions.size() > 1) {
            Fraction x1 = solutions.get(1);
            Fraction x2 = solutions.get(0);
            if (a.toDouble() > 0) {
                System.out.println("x ∈ " + "(-∞, " + x1.toDouble() + "] U [" + x2.toDouble() + ", +∞)");
                solutionString = "\uD835\uDC65 ∈ " + "(-∞, " + x1.toDouble() + "] ∪ [" + x2.toDouble() + ", +∞)";
            }
            else {
                System.out.println("x ∈ " + "[" + x2.toDouble() + ", " + x1.toDouble() + "]");
                solutionString = "\uD835\uDC65 ∈ " + "[" + x2.toDouble() + ", " + x1.toDouble() + "]";
            }
        }
    }

    public void notGreater (Fraction a, Fraction b, Fraction c) {
        equal(a,b,c);
        if (solutions.size() == 1) {
            System.out.println("x = " + solutions.get(0).toDouble());
        }
        else if (solutions.size() > 1) {
            Fraction x1 = solutions.get(1);
            Fraction x2 = solutions.get(0);
            if (a.toDouble() > 0) {
                System.out.println("x ∈ " + "[" + x1.toDouble() + ", " + x2.toDouble() + "]");
                solutionString = "\uD835\uDC65 ∈ " + "[" + x1.toDouble() + ", " + x2.toDouble() + "]";
            }
            else {
                System.out.println("x ∈ " + "(-∞, " + x2.toDouble() + "] U [" + x1.toDouble() + ", +∞)");
                solutionString = "\uD835\uDC65 ∈ " + "(-∞, " + x2.toDouble() + "] ∪ [" + x1.toDouble() + ", +∞)";
            }
        }
    }

    public static void main(String[] args) {
        SecondDegree x = new SecondDegree();
        x.equal(new Fraction(1),new Fraction(2),new Fraction(1));
        x.notGreater(new Fraction(1),new Fraction(-5),new Fraction(4));
        x.smaller(new Fraction(1),new Fraction(-5),new Fraction(4));
        x.notSmaller(new Fraction(1),new Fraction(2),new Fraction(1));
        x.notGreater(new Fraction(1),new Fraction(2),new Fraction(1));
    }
}
