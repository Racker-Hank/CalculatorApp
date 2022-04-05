package mode.equation;

import inputHandler.MathUtil;
import operation.Fraction;

public class ThirdDegree extends Degree {
    public String name = "Third Degree";
    public Fraction roota (double a, double b) {
        Fraction x = new Fraction(a);
        x.numerator = MathUtil.root(x.numerator, b);
        return x;
    }

    public Fraction as (double a) {
        Fraction x = new Fraction(a);
        x.numerator = Math.abs(x.numerator);
        return x;
    }

    public Fraction hat (double a , double b) {
        Fraction x = new Fraction(a);
        x.numerator = Math.pow(x.numerator, b);
        return x;
    }
    public void solveEqual (Fraction a, Fraction b, Fraction c, Fraction d) {
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }
        else {
            Fraction Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(3),a),c));

            Fraction asd = roota(hat(as(Δ.toDouble()).toDouble(),3).toDouble(),2);
            Fraction denominatorOfK = MathUtil.multiply(new Fraction(2),asd);

            Fraction ve1ofNum = MathUtil.multiply(MathUtil.multiply(MathUtil.multiply(new Fraction(9),a),b),c);
            Fraction ve2ofNum = MathUtil.multiply(new Fraction(2),hat(b.toDouble(),3));
            Fraction ve3ofNum = MathUtil.multiply(MathUtil.multiply(new Fraction(27),d),hat(a.toDouble(),2));
            Fraction numeratorOfK = MathUtil.subtract(MathUtil.subtract(ve1ofNum,ve2ofNum),ve3ofNum);

            Fraction k = MathUtil.divide(numeratorOfK,denominatorOfK);
            System.out.println(Δ);
            System.out.println(k.toDouble());
            double kk = Math.toRadians(k.toDouble());
            if ( Δ.toDouble() > 0) {
                if ( Math.abs(k.toDouble()) <= 1) {
                    Fraction x1 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                            * (MathUtil.cosDegrees(Math.toDegrees(Math.acos(kk))/3) - b.toDouble())) / (3 * a.toDouble()));
//                    Fraction x2 = new Fraction((2 * Math.sqrt(Δ.toDouble())
//                            * (Math.cos(Math.acos(k.toDouble())/3 - (2 * Math.PI / 3))  - b.toDouble())) / (3 * a.toDouble()));
//                    Fraction x3 = new Fraction((2 * Math.sqrt(Δ.toDouble())
//                            * (Math.cos(Math.acos(k.toDouble())/3 + (2 * Math.PI / 3))  - b.toDouble())) / (3 * a.toDouble()));
                    solutions.add(x1);
//                    solutions.add(x2);
//                    solutions.add(x3);
                }
                else if (Math.abs(k.toDouble()) > 1) {
                    double leftx = (Math.sqrt(Δ.toDouble()) * Math.abs(k.toDouble())) / (3 * a.toDouble() * k.toDouble());
                    double middlex = MathUtil.root(Math.abs(k.toDouble())+ Math.sqrt((k.toDouble() * k.toDouble())-1),3)
                            + MathUtil.root(Math.abs(k.toDouble()) - Math.sqrt((k.toDouble() * k.toDouble())-1),3);
                    double rightx = -(b.toDouble()) / (3 * a.toDouble());
                    Fraction no = new Fraction((leftx * middlex) + rightx);
                    solutions.add(no);
                }
            }
            else if (Δ.toDouble() == 0) {
                double n1 = (-b.toDouble() + MathUtil.root(b.toDouble() * b.toDouble() * b.toDouble()
                        - 27 * d.toDouble() * a.toDouble() * a.toDouble(),3)) / (3 *a.toDouble());
                solutions.add( new Fraction(n1));
            }
            else if ( Δ.toDouble() < 0) {
                double leftx = (Math.sqrt(Δ.toDouble())) / (3 * a.toDouble() );
                double middlex = MathUtil.root(k.toDouble()+ Math.sqrt((k.toDouble() * k.toDouble()) + 1),3)
                        + MathUtil.root(k.toDouble() - Math.sqrt((k.toDouble() * k.toDouble())+1),3);
                double rightx = -(b.toDouble()) / (3 * a.toDouble());
                Fraction no1 = new Fraction((leftx * middlex) + rightx);
                solutions.add(no1);
            }
        }
    }

    public static void main(String[] args) {
        ThirdDegree a = new ThirdDegree();
        a.solveEqual(new Fraction(1),new Fraction(-6), new Fraction(11), new Fraction(-6));
        for (Fraction solution: a.solutions) {
            System.out.println(solution.toDouble());
        }
    }

}
