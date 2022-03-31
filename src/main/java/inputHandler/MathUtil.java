package inputHandler;

import operation.Fraction;

public class MathUtil {
    public static Fraction add(Fraction a, Fraction b) {
        return a.add(b);
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        return a.subtract(b);
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        return a.multiply(b);
    }

    public static Fraction divide(Fraction a, Fraction b) {
//        if (b == 0) {
//            throw new IllegalArgumentException("Cannot divide by zero");
//        }
//        return a / b;
        return a.divide(b);
    }

    /**
     * Tính căn theo bậc số bất kì
     * @param num
     * @param n
     * @return
     */
    public static double root (double num, double n) {
        if (num == 0) {
            throw new IllegalArgumentException("Math error");
        }

        if (n % 2 != 0 && num < 0) {
            double x = - Math.pow(- num, 1 / n);
            return x;
        }
        else if (num > 0) {
            double x = Math.pow(num, 1 / n);
            return x;
        }
        else {
            throw new IllegalArgumentException("Math error");
        }
    }

    /**
     * Căn bậc 2
     * @param num
     * @return
     */
    public static double squareRoot (double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Math error");
        }
        double x = Math.sqrt(num);
        return x;
    }

    /**
     * tinh giai thừa !
     * @param num
     * @return
     */
    public static int factorial (int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Math error");
        }
        int x = 1;
        for (int i = 1; i <= num; i++) {
            x *= i;
        }
        return x;
    }

    /**
     * tính số mũ ^
     * @param num
     * @param n
     * @return
     */
    public static double power (double num, double n) {
        double x = Math.pow(num, n);
        return x;
    }



    /**
     * Tính tổ hợp C
     * @param k
     * @param n
     * @return Tổ hợp chập k của n
     */
    public static int coefficientBinomial (int k, int n) {
        if (n < k) {
            throw new IllegalArgumentException("Math error");
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    /**
     * Tính sin theo Deg
     * @param Degrees
     * @return
     */
    public static double sinDegrees (double Degrees) {
        double x = Math.sin(Math.toRadians(Degrees));
        return x;
    }

    /**
     * Tính sin theo Rad
     * @param Radians
     * @return
     */
    public static double sinRadians (double Radians) {
        double x = Math.sin(Radians);
        return x;
    }

    /**
     * Tính cos theo Deg
     * @param Degrees
     * @return
     */
    public static double cosDegrees (double Degrees) {
        double x = Math.cos(Math.toRadians(Degrees));
        return x;
    }

    /**
     * Tính cos theo Rad
     * @param Radians Rad
     * @return cos
     */
    public static double cosRadians (double Radians) {
        double x = Math.cos(Radians);
        return x;
    }


    public static double tanDegrees (double Degrees) {
        if (Degrees % 180 == 90) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double x = Math.tan(Math.toRadians(Degrees));
        return x;
    }

    public static double tanRadians (double Radians) {
        if (Math.toDegrees(Radians) % 180 == 90) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double x = Math.tan(Radians);
        return x;
    }

    public static double cotDegrees (double Degrees) {
        if (Degrees % 180 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double x = 1 / Math.tan(Math.toRadians(Degrees));
        return x;
    }

    public static double cotRadians (double Radians) {
        if (Math.toDegrees(Radians) % 180 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double x = 1 / Math.tan(Radians);
        return x;
    }

    public static void main(String[] args) {

        System.out.println(MathUtil.root(-2,3));

        System.out.println(MathUtil.factorial(5));

        System.out.println(MathUtil.coefficientBinomial(6,9));

        System.out.println(MathUtil.power(6 ,7));

        System.out.println(MathUtil.sinRadians(45));

        System.out.println(MathUtil.sinDegrees(45));

        System.out.println(MathUtil.tanRadians(Math.PI / 2));


    }
}
