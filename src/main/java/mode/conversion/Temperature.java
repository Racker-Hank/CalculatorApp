package mode.conversion;

public class Temperature {
    public static double Temperature_C_To_F_ (double x) {
        return (x * 1.8) + 32;
    }

    public static double Temperature_F_To_C_ (double x) {
        return (x - 32) / 1.8;
    }


    public static double Temperature_C_To_K_ (double x) {
        return x + 273.15;
    }

    public static double Temperature_K_To_C_ (double x) {
        return x - 273.15;
    }


    public static double Temperature_F_To_K_ (double x) {
        return Temperature_F_To_C_(x) + 273.15;
    }

    public static double Temperature_K_To_F_ (double x) {
        return Temperature_C_To_F_(x - 273.15);
    }

    public static final double celsius = 1;
    public static final double fahreheit = 2;
    public static final double kelvin = 3;

    public static double a = kelvin;
    public static double b = fahreheit;

    public static double result (double num) {
        if (a == 1 && b == 2) return Temperature_C_To_F_(num);
        if (a == 1 && b == 3) return Temperature_C_To_K_(num);
        if (a == 2 && b == 1) return Temperature_F_To_C_(num);
        if (a == 2 && b == 3) return Temperature_F_To_K_(num);
        if (a == 3 && b == 1) return Temperature_K_To_C_(num);
        if (a == 3 && b == 2) return Temperature_K_To_F_(num);
        else {
            return num;
        }
    }

    public static void main(String[] args) {
        System.out.println(result(27));
    }

}
