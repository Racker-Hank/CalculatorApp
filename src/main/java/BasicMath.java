public class BasicMath {
    /**
     * Tính căn theo bậc số bất kì
     * @param num
     * @param n
     * @return
     */
    public static double RandomRoot (double num, double n) {
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
     * Căn bậc 2
     * @param num
     * @return
     */
    public static double SquareRoot (double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Math error");
        }
        double x = Math.sqrt(num);
        return x;
    }

    /**
     * Tính tổ hợp C
     * @param k
     * @param n
     * @return Tổ hợp chập k của n
     */
    public static int CoefficientBinomial (int k, int n) {
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
    public static double SinDegrees (double Degrees) {
        double x = Math.sin(Math.toRadians(Degrees));
        return x;
    }

    /**
     * Tính sin theo Rad
     * @param Radians
     * @return
     */
    public static double SinRadians (double Radians) {
        double x = Math.sin(Radians);
        return x;
    }

    /**
     * Tính cos theo Deg
     * @param Degrees
     * @return
     */
    public static double CosDegrees (double Degrees) {
        double x = Math.cos(Math.toRadians(Degrees));
        return x;
    }

    /**
     * Tính cos theo Rad
     * @param Radians Rad
     * @return cos
     */
    public static double CosRadians (double Radians) {
        double x = Math.cos(Radians);
        return x;
    }


    public static double TanDegrees (double Degrees) {
        if (Degrees % 180 == 90) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double x = Math.tan(Math.toRadians(Degrees));
        return x;
    }

    public static double TanRadians (double Radians) {
        if (Math.toDegrees(Radians) % 180 == 90) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double x = Math.tan(Radians);
        return x;
    }

    public static double CotDegrees (double Degrees) {
        if (Degrees % 180 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double x = 1 / Math.tan(Math.toRadians(Degrees));
        return x;
    }

    public static double CotRadians (double Radians) {
        if (Math.toDegrees(Radians) % 180 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double x = 1 / Math.tan(Radians);
        return x;
    }

    public static void main(String[] args) {

        System.out.println(BasicMath.RandomRoot(-2,3));

        System.out.println(BasicMath.factorial(5));

        System.out.println(BasicMath.CoefficientBinomial(6,9));

        System.out.println(BasicMath.power(6 ,7));

        System.out.println(BasicMath.SinRadians(45));

        System.out.println(BasicMath.SinDegrees(45));

        System.out.println(BasicMath.TanRadians(Math.PI / 2));


    }
}
