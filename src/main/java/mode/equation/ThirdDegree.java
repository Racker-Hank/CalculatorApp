package mode.equation;

import inputHandler.MathUtil;
import operation.Fraction;

public class ThirdDegree extends Degree {
    public String name = "Third Degree";
    Fraction Δ;
    Fraction numeratorOfK;
    Fraction denominatorOfK;

    public void equal (Fraction a, Fraction b, Fraction c, Fraction d) {
        solutions.clear();
        Δ = new Fraction(0);
        numeratorOfK = new Fraction(0);
        denominatorOfK = new Fraction(0);
        if (a.toDouble() == 0) {
//            throw Exception;
            System.out.println("a cannot be zero");
        }
        else {
            Δ = MathUtil.subtract(MathUtil.multiply(b,b),MathUtil.multiply(MathUtil.multiply(new Fraction(3),a),c));
//            Fraction tmp = roota(hat(as(Δ.toDouble()).toDouble(),3).toDouble(),2);
            Fraction tmp = Δ.abs().pow(new Fraction(3,2));
            denominatorOfK = MathUtil.multiply(new Fraction(2),tmp);

            Fraction ve1ofNum = MathUtil.multiply(MathUtil.multiply(MathUtil.multiply(new Fraction(9),a),b),c);
//            Fraction ve2ofNum = MathUtil.multiply(new Fraction(2),hat(b.toDouble(),3));
            Fraction ve2ofNum = MathUtil.multiply(new Fraction(2),b.pow(new Fraction(3)));
//            Fraction ve3ofNum = MathUtil.multiply(MathUtil.multiply(new Fraction(27),d),hat(a.toDouble(),2));
            Fraction ve3ofNum = MathUtil.multiply(MathUtil.multiply(new Fraction(27),d),a.pow(new Fraction(2)));
            numeratorOfK = MathUtil.subtract(MathUtil.subtract(ve1ofNum,ve2ofNum),ve3ofNum);

            if ( Δ.toDouble() > 0) {
                Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
                if ( Math.abs(k.toDouble()) <= 1) {
                    Fraction x1 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                            * Math.cos(Math.acos(k.toDouble()) / 3) - b.toDouble()) / (3 * a.toDouble()));
                    Fraction x2 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                            * Math.cos(Math.acos(k.toDouble()) / 3 - (2 * Math.PI / 3)) - b.toDouble()) / (3 * a.toDouble()));
                    Fraction x3 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                            * Math.cos(Math.acos(k.toDouble()) / 3 + (2 * Math.PI / 3)) - b.toDouble()) / (3 * a.toDouble()));
                    solutions.add(x1);
                    if (x2.toDouble() != x3.toDouble()) {
                        solutions.add(x2);
                        solutions.add(x3);
                    }
                    else {
                        solutions.add(x2);
                    }
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
                Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
                double leftx = Math.sqrt(Math.abs(Δ.toDouble())) / (3 * a.toDouble());
                double middlex = MathUtil.root(k.toDouble() + Math.sqrt((k.toDouble() * k.toDouble()) + 1),3)
                        + MathUtil.root(k.toDouble() - Math.sqrt((k.toDouble() * k.toDouble())+1),3);
                double rightx = b.toDouble() / (3 * a.toDouble());
                Fraction no1 = new Fraction((leftx * middlex) - rightx);
                solutions.add(no1);
            }
        }
    }

    public void greater (Fraction a, Fraction b, Fraction c, Fraction d) {
        equal(a,b,c,d);
        if ( Δ.toDouble() > 0) {
            Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
            if ( Math.abs(k.toDouble()) <= 1) {
                Fraction x1 = new Fraction ((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble())/3) - b.toDouble()) / (3 * a.toDouble()));
                Fraction x2 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble())/3 - (2 * Math.PI / 3))  - b.toDouble()) / (3 * a.toDouble()));
                Fraction x3 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble())/3 + (2 * Math.PI / 3))  - b.toDouble()) / (3 * a.toDouble()));
                if ( a.toDouble() > 0) {
                    if (x2.toDouble() == x3.toDouble()) {
                        System.out.println("(" + x1.toDouble() + ", +∞)");
                    } else {
                        System.out.println("(" + x3.toDouble() + ", " + x2.toDouble() + ") U (" + x1.toDouble() + ", +∞)");
                    }
                }
                else {
                    if ( x1.toDouble() == x2.toDouble()) {
                        System.out.println("(-∞, " + x3.toDouble() + ")"  );
                    }
                    else if (x2.toDouble() == x3.toDouble()){
                        System.out.println("(-∞, " + x1.toDouble() + ")"  );
                    }
                    else {
                        System.out.println("(-∞, " + x1.toDouble() + ") U (" + x2.toDouble() + ", " + x3.toDouble() + ")" );
                    }
                }
            }

            else if (Math.abs(k.toDouble()) > 1) {
                double leftx = (Math.sqrt(Δ.toDouble()) * Math.abs(k.toDouble())) / (3 * a.toDouble() * k.toDouble());
                double middlex = MathUtil.root(Math.abs(k.toDouble())+ Math.sqrt((k.toDouble() * k.toDouble())-1),3)
                        + MathUtil.root(Math.abs(k.toDouble()) - Math.sqrt((k.toDouble() * k.toDouble())-1),3);
                double rightx = -(b.toDouble()) / (3 * a.toDouble());
                Fraction no = new Fraction((leftx * middlex) + rightx);
                if ( a.toDouble() > 0)
                System.out.println("(" + no.toDouble() + ", +∞)");
                    else
                    System.out.println("(-∞ , " + no.toDouble() + ")");
            }
        }

        else if (Δ.toDouble() == 0) {
            double n1 = (-b.toDouble() + MathUtil.root(b.toDouble() * b.toDouble() * b.toDouble()
                    - 27 * d.toDouble() * a.toDouble() * a.toDouble(),3)) / (3 *a.toDouble());
            if ( a.toDouble() > 0)
            System.out.println("(" + n1 + ", +∞)");
            else
                System.out.println("(-∞ , " + n1 + ")");
        }

        else if ( Δ.toDouble() < 0) {
            Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
            double leftx = Math.sqrt(Math.abs(Δ.toDouble())) / (3 * a.toDouble());
            double middlex = MathUtil.root(k.toDouble() + Math.sqrt((k.toDouble() * k.toDouble()) + 1),3)
                    + MathUtil.root(k.toDouble() - Math.sqrt((k.toDouble() * k.toDouble())+1),3);
            double rightx = b.toDouble() / (3 * a.toDouble());
            Fraction no1 = new Fraction((leftx * middlex) - rightx);
            if (a.toDouble() > 0)
            System.out.println("(" + no1.toDouble() + ", +∞)");
                else System.out.println("(-∞ , " + no1.toDouble() + ")");
        }
    }


    public void smaller (Fraction a, Fraction b, Fraction c, Fraction d) {
        equal(a,b,c,d);
        if ( Δ.toDouble() > 0) {
            Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
            if ( Math.abs(k.toDouble()) <= 1) {
                Fraction x1 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble()) / 3) - b.toDouble()) / (3 * a.toDouble()));
                Fraction x2 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble()) / 3 - (2 * Math.PI / 3)) - b.toDouble()) / (3 * a.toDouble()));
                Fraction x3 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble()) / 3 + (2 * Math.PI / 3)) - b.toDouble()) / (3 * a.toDouble()));
                if (a.toDouble() > 0) {
                    if (x1.toDouble() == x2.toDouble()) {
                        System.out.println("(-∞, " + x3.toDouble() + ")");
                    } else {
                        System.out.println("(-∞, " + x3.toDouble() + ") U (" + x2.toDouble() + ", " + x1.toDouble() + ")");
                    }
                } else {
                    if (x2.toDouble() == x3.toDouble()) {
                        System.out.println("(" + x1.toDouble() + ", +∞)");
                    } else {
                        System.out.println("(" + x1.toDouble() + ", " + x2.toDouble() + ") U (" + x3.toDouble() + ", +∞)");
                    }
                }
            }
            else if (Math.abs(k.toDouble()) > 1) {
                double leftx = (Math.sqrt(Δ.toDouble()) * Math.abs(k.toDouble())) / (3 * a.toDouble() * k.toDouble());
                double middlex = MathUtil.root(Math.abs(k.toDouble())+ Math.sqrt((k.toDouble() * k.toDouble())-1),3)
                        + MathUtil.root(Math.abs(k.toDouble()) - Math.sqrt((k.toDouble() * k.toDouble())-1),3);
                double rightx = -(b.toDouble()) / (3 * a.toDouble());
                Fraction no = new Fraction((leftx * middlex) + rightx);
                if( a.toDouble() > 0) {
                    System.out.println("(-∞ , " + no.toDouble() + ")");
                }
                else {
                    System.out.println("(" + no.toDouble() + ", +∞)");
                }
            }
        }

        else if (Δ.toDouble() == 0) {
            double n1 = (-b.toDouble() + MathUtil.root(b.toDouble() * b.toDouble() * b.toDouble()
                    - 27 * d.toDouble() * a.toDouble() * a.toDouble(),3)) / (3 *a.toDouble());
            if ( a.toDouble() > 0) {
                System.out.println("(-∞ , " + n1 + ")");
            }
            else {
                System.out.println("(" + n1 + ", +∞)");
            }
        }

        else if ( Δ.toDouble() < 0) {
            Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
            double leftx = Math.sqrt(Math.abs(Δ.toDouble())) / (3 * a.toDouble());
            double middlex = MathUtil.root(k.toDouble() + Math.sqrt((k.toDouble() * k.toDouble()) + 1),3)
                    + MathUtil.root(k.toDouble() - Math.sqrt((k.toDouble() * k.toDouble())+1),3);
            double rightx = b.toDouble() / (3 * a.toDouble());
            Fraction no1 = new Fraction((leftx * middlex) - rightx);
            if ( a.toDouble() > 0)
            System.out.println("(-∞ , " + no1.toDouble() + ")");
            else
                System.out.println("(" + no1.toDouble() + ", +∞)");
        }
    }

    public void notSmaller (Fraction a, Fraction b, Fraction c, Fraction d) {
        equal(a,b,c,d);

        if ( Δ.toDouble() > 0) {
            Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
            if ( Math.abs(k.toDouble()) <= 1) {
                Fraction x1 = new Fraction ((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble())/3) - b.toDouble()) / (3 * a.toDouble()));
                Fraction x2 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble())/3 - (2 * Math.PI / 3))  - b.toDouble()) / (3 * a.toDouble()));
                Fraction x3 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble())/3 + (2 * Math.PI / 3))  - b.toDouble()) / (3 * a.toDouble()));
                if ( a.toDouble() > 0) {
                    if (x1.toDouble() == x2.toDouble()) {
                        System.out.println("[" + x3.toDouble() + ", +∞)");
                    }
                    else if (x2.toDouble() == x3.toDouble()) {
                        System.out.println("[" + x1.toDouble() + ", +∞)");
                    } else  {
                        System.out.println("[" + x3.toDouble() + ", " + x2.toDouble() + "] U [" + x1.toDouble() + ", +∞)");
                    }
                }
                else {
                    if ( x1.toDouble() == x2.toDouble()) {
                        System.out.println("(-∞, " + x3.toDouble() + "]"  );
                    }
                    else if (x2.toDouble() == x3.toDouble()){
                        System.out.println("(-∞, " + x1.toDouble() + "]"  );
                    }
                    else {
                        System.out.println("(-∞, " + x1.toDouble() + "] U [" + x2.toDouble() + ", " + x3.toDouble() + "]" );
                    }
                }
            }

            else if (Math.abs(k.toDouble()) > 1) {
                double leftx = (Math.sqrt(Δ.toDouble()) * Math.abs(k.toDouble())) / (3 * a.toDouble() * k.toDouble());
                double middlex = MathUtil.root(Math.abs(k.toDouble())+ Math.sqrt((k.toDouble() * k.toDouble())-1),3)
                        + MathUtil.root(Math.abs(k.toDouble()) - Math.sqrt((k.toDouble() * k.toDouble())-1),3);
                double rightx = -(b.toDouble()) / (3 * a.toDouble());
                Fraction no = new Fraction((leftx * middlex) + rightx);
                if ( a.toDouble() > 0)
                    System.out.println("[" + no.toDouble() + ", +∞)");
                else
                    System.out.println("(-∞ , " + no.toDouble() + "]");
            }
        }

        else if (Δ.toDouble() == 0) {
            double n1 = (-b.toDouble() + MathUtil.root(b.toDouble() * b.toDouble() * b.toDouble()
                    - 27 * d.toDouble() * a.toDouble() * a.toDouble(),3)) / (3 *a.toDouble());
            if ( a.toDouble() > 0)
                System.out.println("[" + n1 + ", +∞)");
            else
                System.out.println("(-∞ , " + n1 + "]");
        }

        else if ( Δ.toDouble() < 0) {
            Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
            double leftx = Math.sqrt(Math.abs(Δ.toDouble())) / (3 * a.toDouble());
            double middlex = MathUtil.root(k.toDouble() + Math.sqrt((k.toDouble() * k.toDouble()) + 1),3)
                    + MathUtil.root(k.toDouble() - Math.sqrt((k.toDouble() * k.toDouble())+1),3);
            double rightx = b.toDouble() / (3 * a.toDouble());
            Fraction no1 = new Fraction((leftx * middlex) - rightx);
            if (a.toDouble() > 0)
                System.out.println("[" + no1.toDouble() + ", +∞ )");
            else System.out.println("(-∞ , " + no1.toDouble() + "]");
        }
    }


    public void notGreater (Fraction a, Fraction b, Fraction c, Fraction d) {
        equal(a,b,c,d);
        if ( Δ.toDouble() > 0) {
            Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
            if ( Math.abs(k.toDouble()) <= 1) {
                Fraction x1 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble()) / 3) - b.toDouble()) / (3 * a.toDouble()));
                Fraction x2 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble()) / 3 - (2 * Math.PI / 3)) - b.toDouble()) / (3 * a.toDouble()));
                Fraction x3 = new Fraction((2 * Math.sqrt(Δ.toDouble())
                        * Math.cos(Math.acos(k.toDouble()) / 3 + (2 * Math.PI / 3)) - b.toDouble()) / (3 * a.toDouble()));
                if (a.toDouble() > 0) {
                    if ( x1.toDouble() == x2.toDouble()) {
                        System.out.println("(-∞, " + x3.toDouble() + "]"  );
                    }
                    else if (x2.toDouble() == x3.toDouble()){
                        System.out.println("(-∞, " + x1.toDouble() + "]"  );
                    }
                    else {
                        System.out.println("(-∞, " + x1.toDouble() + "] U [" + x2.toDouble() + ", " + x3.toDouble() + "]" );
                    }
                } else {
                    if (x1.toDouble() == x2.toDouble()) {
                        System.out.println("[" + x3.toDouble() + ", +∞)");
                    }
                    else if (x2.toDouble() == x3.toDouble()) {
                        System.out.println("[" + x1.toDouble() + ", +∞)");
                    } else  {
                        System.out.println("[" + x3.toDouble() + ", " + x2.toDouble() + "] U [" + x1.toDouble() + ", +∞)");
                    }
                }
            }
            else if (Math.abs(k.toDouble()) > 1) {
                double leftx = (Math.sqrt(Δ.toDouble()) * Math.abs(k.toDouble())) / (3 * a.toDouble() * k.toDouble());
                double middlex = MathUtil.root(Math.abs(k.toDouble())+ Math.sqrt((k.toDouble() * k.toDouble())-1),3)
                        + MathUtil.root(Math.abs(k.toDouble()) - Math.sqrt((k.toDouble() * k.toDouble())-1),3);
                double rightx = -(b.toDouble()) / (3 * a.toDouble());
                Fraction no = new Fraction((leftx * middlex) + rightx);
                if( a.toDouble() > 0) {
                    System.out.println("(-∞ , " + no.toDouble() + "]");
                }
                else {
                    System.out.println("[" + no.toDouble() + ", +∞)");
                }
            }
        }

        else if (Δ.toDouble() == 0) {
            double n1 = (-b.toDouble() + MathUtil.root(b.toDouble() * b.toDouble() * b.toDouble()
                    - 27 * d.toDouble() * a.toDouble() * a.toDouble(),3)) / (3 *a.toDouble());
            if ( a.toDouble() > 0) {
                System.out.println("(-∞ , " + n1 + "]");
            }
            else {
                System.out.println("[" + n1 + ", +∞");
            }
        }

        else if ( Δ.toDouble() < 0) {
            Fraction k = MathUtil.divide(numeratorOfK, denominatorOfK);
            double leftx = Math.sqrt(Math.abs(Δ.toDouble())) / (3 * a.toDouble());
            double middlex = MathUtil.root(k.toDouble() + Math.sqrt((k.toDouble() * k.toDouble()) + 1),3)
                    + MathUtil.root(k.toDouble() - Math.sqrt((k.toDouble() * k.toDouble())+1),3);
            double rightx = b.toDouble() / (3 * a.toDouble());
            Fraction no1 = new Fraction((leftx * middlex) - rightx);
            if ( a.toDouble() > 0)
                System.out.println("(-∞ , " + no1.toDouble() + "]");
            else
                System.out.println("[" + no1.toDouble() + ", +∞)");
        }
    }

    public static void main(String[] args) {
        ThirdDegree a = new ThirdDegree();
//        a.equal(new Fraction(1),new Fraction(-5), new Fraction(8), new Fraction(-4));
        a.notSmaller(new Fraction(1),new Fraction(-5), new Fraction(8), new Fraction(-4));
        a.greater(new Fraction(1),new Fraction(-5), new Fraction(8), new Fraction(-4));
        a.notGreater(new Fraction(3),new Fraction(-10), new Fraction(8), new Fraction(-4));
//        for (Fraction solution: a.solutions) {
//            System.out.println(solution.toDouble());
//        }
    }

}
