package mode.equation;

import inputHandler.MathUtil;
import operation.Fraction;

public class SecondDegree extends Degree {
    public String name = "Second Degree";

    public void solveEqual (Fraction a, Fraction b, Fraction c) {
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }
        else {
            Fraction Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(4),a),c));
            if (Δ.toDouble() == 0) {
                solutions.add(MathUtil.divide(MathUtil.multiply(new Fraction(-1),b),MathUtil.multiply(new Fraction(2),a)));
            }
            else if (Δ.toDouble() > 0) {
                Fraction x = new Fraction(Δ.toDouble());
                x.numerator = Math.sqrt(x.numerator);
//                x.denominator = Math.sqrt(x.denominator);

                solutions.add(MathUtil.divide(MathUtil.add(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a)));
                solutions.add(MathUtil.divide(MathUtil.subtract(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a)));
            }
        }
    }

    public void Smaller (Fraction a, Fraction b, Fraction c) {
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }
        else {
            Fraction Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(4),a),c));

            if (Δ.toDouble() == 0) {
                Fraction x = MathUtil.divide(MathUtil.multiply(new Fraction(-1),b),MathUtil.multiply(new Fraction(2),a));
                System.out.println("(-∞," + x.toDouble() + ") U (" + x.toDouble() + ", +∞)");
            }

            else if (Δ.toDouble() > 0) {
                Fraction x = new Fraction(Δ.toDouble());
                x.numerator = Math.sqrt(x.numerator);

                Fraction x2 = MathUtil.divide(MathUtil.add(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
                Fraction x1 = MathUtil.divide(MathUtil.subtract(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
                if (a.toDouble() > 0) {
                    System.out.println("(" + x1.toDouble() + ", " + x2.toDouble() + ")");
                }
                else {
                    System.out.println("(-∞, " + x2.toDouble() + ") U (" + x1.toDouble() + ", +∞)");
                }
            }
        }
    }

    public void Greater (Fraction a, Fraction b, Fraction c) {
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }
        else {
            Fraction Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(4),a),c));

            if (Δ.toDouble() == 0) {
                Fraction x = MathUtil.divide(MathUtil.multiply(new Fraction(-1),b),MathUtil.multiply(new Fraction(2),a));
                System.out.println("(-∞," + x.toDouble() + ") U (" + x.toDouble() + ", +∞)");
            }

            else if (Δ.toDouble() > 0) {
                Fraction x = new Fraction(Δ.toDouble());
                x.numerator = Math.sqrt(x.numerator);

                Fraction x2 = MathUtil.divide(MathUtil.add(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
                Fraction x1 = MathUtil.divide(MathUtil.subtract(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
                if (a.toDouble() > 0) {
                    System.out.println("(-∞, " + x1.toDouble() + ") U (" + x2.toDouble() + ", +∞)");

                }
                else {
                    System.out.println("(" + x2.toDouble() + ", " + x1.toDouble() + ")");
                }
            }
        }
    }

    public void notSmaller (Fraction a, Fraction b, Fraction c) {
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }
        else {
            Fraction Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(4),a),c));

            if (Δ.toDouble() == 0) {
                Fraction x = MathUtil.divide(MathUtil.multiply(new Fraction(-1),b),MathUtil.multiply(new Fraction(2),a));
                System.out.println("(-∞," + x.toDouble() + "] U [" + x.toDouble() + ", +∞)");
            }

            else if (Δ.toDouble() > 0) {
                Fraction x = new Fraction(Δ.toDouble());
                x.numerator = Math.sqrt(x.numerator);

                Fraction x2 = MathUtil.divide(MathUtil.add(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
                Fraction x1 = MathUtil.divide(MathUtil.subtract(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
                if (a.toDouble() > 0) {
                    System.out.println("(-∞, " + x1.toDouble() + "] U [" + x2.toDouble() + ", +∞)");

                }
                else {
                    System.out.println("[" + x2.toDouble() + ", " + x1.toDouble() + "]");
                }
            }
        }
    }

    public void notGreater (Fraction a, Fraction b, Fraction c) {
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }
        else {
            Fraction Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(4),a),c));

            if (Δ.toDouble() == 0) {
                Fraction x = MathUtil.divide(MathUtil.multiply(new Fraction(-1),b),MathUtil.multiply(new Fraction(2),a));
                System.out.println("(-∞," + x.toDouble() + "] U [" + x.toDouble() + ", +∞)");
            }

            else if (Δ.toDouble() > 0) {
                Fraction x = new Fraction(Δ.toDouble());
                x.numerator = Math.sqrt(x.numerator);

                Fraction x2 = MathUtil.divide(MathUtil.add(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
                Fraction x1 = MathUtil.divide(MathUtil.subtract(MathUtil.multiply(new Fraction(-1),b),x),MathUtil.multiply(new Fraction(2),a));
                if (a.toDouble() > 0) {
                    System.out.println("[" + x1.toDouble() + ", " + x2.toDouble() + "]");
                }
                else {
                    System.out.println("(-∞, " + x2.toDouble() + "] U [" + x1.toDouble() + ", +∞)");
                }
            }
        }
    }

    public static void main(String[] args) {
        SecondDegree x = new SecondDegree();
        x.solveEqual(new Fraction(1),new Fraction(2),new Fraction(1));
        x.notGreater(new Fraction(1),new Fraction(-5),new Fraction(4));

//        for (Fraction solution: x.solutions) {
//            System.out.println(solution.toDouble());
//        }
    }
}
