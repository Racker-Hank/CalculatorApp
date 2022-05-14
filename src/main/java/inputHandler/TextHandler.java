package inputHandler;

import operation.Fraction;

public class TextHandler {

    public static void mathInputHandler(String expression , Fraction result) {
        Expr e = new Expr(expression);
        result.setValue(new Fraction(e.value(0)));
    }


    //    1.1234567891
    public static Number numberFormatter(double number) {
        Number result;
        int decimalNumbers = 9;
        if (number == (int) number) {
            result = ((int) number);
        } else {
            long round = Math.round(number * Math.pow(10, decimalNumbers));
            if (Math.abs((number * Math.pow(10 , decimalNumbers))) - Math.abs(round) < 1) {
                result = (round / Math.pow(10 , decimalNumbers));
            } else {
                result = number;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(TextHandler.numberFormatter(Math.pow(Math.sin(Math.toRadians(45)),2)));

        Fraction a = new Fraction();
        mathInputHandler("3!", a);
        System.out.println(a.toDouble());
    }
}
