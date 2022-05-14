package inputHandler;

import UI.Controller3;
import UI.StandardController;
import mode.standard.Standard;
import operation.Constants;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Refer to <a href="https://math.hws.edu/javanotes/source/chapter8/Expr.java">Expr</a> for original Java code.
 */

/*
    An object belonging to the class Expr is a mathematical expression that
    can involve:

            -- real numbers such as 2.7, 3, and 12.7e-12
            -- the variable x
            -- arithmetic operators  +,  -,  *,  /, ! and  ^ , where
               the last of these represents raising to a power
            -- the mathematical functions sin, cos, tan, sec, csc, cot,
               arcsin, arccos, arctan, exp, ln, log2, log10, abs, and sqrt,
               where ln is the natural log, log2 is the log to the base 2,
               log10 is the log to the base 10, abs is absolute value,
               and sqrt is the square root
            -- parentheses

     Some examples would be:   x^2 + x + 1
                               sin(2.3*x-7.1) - cos(7.1*x-2.3)
                               x - 1
                               42
                               exp(x^2) - 1

     The trigonometric functions work with radians, not degrees.  The parameter
     of a function must be enclosed in parentheses, so that "sin x" is NOT allowed.

     An Expr is constructed from a String that contains its definition.  If an
     error is found in this definition, the constructor will throw an
     IllegalArgumentException with a message that describes the error and
     the position of the error in the string.  After an Expr has been
     constructed, its defining string can be retrieved using the
     method getDefinition().

     The main operation on an Expr object is to find its value, given
     a value for the variable x.  The value is computed by the value() method.
     If the expression is undefined at the given value of x, then the
     number returned by value() method will be the special "non-a-number number",
     Double.NaN.  (The boolean-valued function Double.isNaN(v) can be used to
     test whether the double value v is the special NaN value.  For technical
     reasons, you can't just use the == operator to test for this value.)

 */

public class Expr {

    //----------------- public interface ---------------------------------------

    /**
     * Construct an expression, given its definition as a string.
     * This will throw an IllegalArgumentException if the string
     * does not contain a legal expression.
     */
    public Expr(String definition) {
//        Field[] fields = Constants.class.getDeclaredFields();
//        for (Field f : fields) {
//            if (Modifier.isStatic(f.getModifiers())) {
//                Constants.Constant constant = null;
//                try {
//                    constant = (Constants.Constant) f.get(null);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                assert constant != null;
//                constantsList.add(constant);
//            }
//        }
        parse(definition);
    }

    /**
     * Computes the value of this expression, when the variable x
     * has a specified value.  If the expression is undefined
     * for the specified value of x, then Double.NaN is returned.
     *
     * @param x the value to be used for the variable x in the expression
     * @return the computed value of the expression
     */
    public double value(double x) {
        return eval(x);
    }

    /**
     * Return the original definition string of this expression.  This
     * is the same string that was provided in the constructor.
     */
    public String toString() {
        return definition;
    }

    //------------------- private implementation details ----------------------------------


    private String definition;  // The original definition of the expression,
    // as passed to the constructor.

    private byte[] code;        // A translated version of the expression, containing
    //   stack operations that compute the value of the expression.

    private double[] stack;     // A stack to be used during the evaluation of the expression.

    private double[] constants; // An array containing all the constants found in the expression.


    private static final byte  // values for code array; values >= 0 are indices into constants array
            PLUS = -1, MINUS = -2, TIMES = -3, DIVIDE = -4, POWER = -5, SIN = -6, COS = -7, TAN = -8,
            COT = -9, SEC = -10, CSC = -11, ARCSIN = -12, ARCCOS = -13, ARCTAN = -14, EXP = -15,
            LN = -16, LOG10 = -17, LOG2 = -18, ABS = -19, SQRT = -20, ROOT = -21, MODULO = -22, RANDOM = -23,
            RANDOM_INT = -24,
            FACTORIAL = -25, PERCENT = -26, UNARYMINUS = -27, VARIABLE = -28;


    private static final String[] functionNames = {  // names of standard functions, used during parsing
            "sin", "cos", "tan", "cot", "sec",
            "csc", "arcsin", "arccos", "arctan", "exp",
            "ln", "log10", "log2", "abs", "sqrt", "rt", "mod", "rand", "randint"};

//    private static final List<Constants.Constant> constantsList = new ArrayList<>(); // array of constants
    private static final List<Constants.Constant> constantsList = Constants.constants; // array of constants

    private double eval(double variable) { // evaluate this expression for this value of the variable
        try {
            int top = 0;
            for (int i = 0; i < codeSize; i++) {
                if (code[i] >= 0)
                    stack[top++] = constants[code[i]];
                else if (code[i] >= POWER) {
                    double y = stack[--top];
                    double x = stack[--top];
                    double ans = Double.NaN;
                    switch (code[i]) {
                        case PLUS:
                            ans = x + y;
                            break;
                        case MINUS:
                            ans = x - y;
                            break;
                        case TIMES:
                            ans = x * y;
                            break;
                        case DIVIDE:
                            ans = x / y;
                            break;
                        case POWER:
                            ans = Math.pow(x, y);
                            break;
                    }
                    if (Double.isNaN(ans))
                        return ans;
                    stack[top++] = ans;
                } else if (code[i] == VARIABLE) {
                    stack[top++] = variable;
                } else {
                    double x = stack[--top];
                    double ans = Double.NaN;
                    boolean deg_rad = Controller3.BottomRightPane.toggleSwitch.switchOnProperty().get();
                    switch (code[i]) {
                        case SIN:
                            ans = deg_rad ? MathUtil.sinDegrees(x) : MathUtil.sinRadians(x);
                            break;
                        case COS:
                            ans = deg_rad ? MathUtil.cosDegrees(x) : MathUtil.cosRadians(x);
                            break;
                        case TAN:
                            ans = deg_rad ? MathUtil.tanDegrees(x) : MathUtil.tanRadians(x);
                            break;
                        case COT:
                            ans = deg_rad ? MathUtil.cotDegrees(x) : MathUtil.cotRadians(x);
                            break;
                        case SEC:
                            ans = 1.0 / Math.cos(x);
                            break;
                        case CSC:
                            ans = 1.0 / Math.sin(x);
                            break;
                        case ARCSIN:
                            if (Math.abs(x) <= 1.0) ans = Math.asin(x);
                            break;
                        case ARCCOS:
                            if (Math.abs(x) <= 1.0) ans = Math.acos(x);
                            break;
                        case ARCTAN:
                            ans = Math.atan(x);
                            break;
                        case EXP:
                            ans = Math.exp(x);
                            break;
                        case LN:
                            if (x > 0.0) ans = Math.log(x);
                            break;
                        case LOG2:
                            if (x > 0.0) ans = Math.log(x) / Math.log(2);
                            break;
                        case LOG10:
                            if (x > 0.0) ans = Math.log(x) / Math.log(10);
                            break;
                        case ABS:
                            ans = Math.abs(x);
                            break;
                        case SQRT:
                            if (x >= 0.0) ans = Math.sqrt(x);
                            break;
                        case UNARYMINUS:
                            ans = -x;
                            break;
                        case ROOT:
                            double y = stack[--top];
                            if (y >= 0.0) ans = Math.pow(y, 1.0 / x);
                            break;
                        case FACTORIAL:
                            ans = factorial(x);
                            break;
                        case PERCENT:
                            ans = x / 100.0;
                            break;
                        case MODULO:
                            y = stack[--top];
                            ans = y % x;
                            break;
                        case RANDOM:
                            y = stack[--top];
                            ans = MathUtil.randInRange(y,x,false);
                            break;
                        case RANDOM_INT:
                            y = stack[--top];
                            ans = MathUtil.randInRange(y,x,true);
                            break;
                    }
                    if (Double.isNaN(ans))
                        return ans;
                    stack[top++] = ans;
                }
            }
        } catch (Exception e) {
            return Double.NaN;
        }
        if (Double.isInfinite(stack[0]))
            return Double.NaN;
        else
            return stack[0];
    }

    private double factorial(double x) {
        if (x < 0.0) return Double.NaN;
        if (x > 170.0) return Double.POSITIVE_INFINITY;
        double ans = 1.0;
        while (x > 1.0) {
            ans *= x--;
        }
        return ans;
    }

    private int pos = 0, constantCt = 0, codeSize = 0;  // data for use during parsing

    private void error(String message) {  // called when an error occurs during parsing
        throw new IllegalArgumentException("Parse error:  " + message + "  (Position in data = " + pos + ".)");
    }

    private int computeStackUsage() {  // call after code[] is computed
        int s = 0;   // stack size after each operation
        int max = 0; // maximum stack size seen
        for (int i = 0; i < codeSize; i++) {
            if (code[i] >= 0 || code[i] == VARIABLE) {
                s++;
                if (s > max)
                    max = s;
            } else if (code[i] >= POWER)
                s--;
        }
        return max;
    }

    private void parse(String definition) { // Parse the definition and produce all
        // the data that represents the expression
        // internally;  can throw IllegalArgumentException
        if (definition == null || definition.trim().equals(""))
            error("No data provided to Expr constructor");
        this.definition = definition;
        code = new byte[definition.length()];
        constants = new double[definition.length()];
        parseExpression();
        skip();
        if (next() != 0)
            error("Extra data found after the end of the expression.");
        int stackSize = computeStackUsage();
        stack = new double[stackSize];
        byte[] c = new byte[codeSize];
        System.arraycopy(code, 0, c, 0, codeSize);
        code = c;
        double[] A = new double[constantCt];
        System.arraycopy(constants, 0, A, 0, constantCt);
        constants = A;
    }

    private char next() {  // return next char in data or 0 if data is all used up
        if (pos >= definition.length())
            return 0;
        else
            return definition.charAt(pos);
    }

    private void skip() {  // skip over white space in data
        while (Character.isWhitespace(next()))
            pos++;
    }

    // remaining routines do a standard recursive parse of the expression

    private void parseExpression() {
        boolean neg = false;
        skip();
        if (next() == '+' || next() == '-') {
            neg = (next() == '-');
            pos++;
            skip();
        }
        parseTerm();
        if (neg)
            code[codeSize++] = UNARYMINUS;
        skip();
        while (next() == '+' || next() == '-') {
            char op = next();
            pos++;
            parseTerm();
            code[codeSize++] = (op == '+') ? PLUS : MINUS;
            skip();
        }
    }

    private void parseTerm() {
        parseFactor();
        skip();
        while (next() == '*' || next() == '/') {
            char op = next();
            pos++;
            parseFactor();
            code[codeSize++] = (op == '*') ? TIMES : DIVIDE;
            skip();
        }
    }

    private void parseFactor() {
        parsePrimary();
        skip();
        while (next() == '^' || next() == '!' || next() == '%') {
            char op = next();
            if (op == '^') {
                pos++;
                parsePrimary();
                code[codeSize++] = POWER;
                skip();
            } else if (op == '!') {
                pos++;
                code[codeSize++] = FACTORIAL;
                skip();
            } else if (op == '%') {
                pos++;
                code[codeSize++] = PERCENT;
                skip();
            }
        }
    }

    private void parsePrimary() {
        skip();
        char ch = next();
        if (ch == 'x' || ch == 'X') {
            pos++;
            code[codeSize++] = VARIABLE;
        } else if (Character.isLetter(ch))
            parseWord();
        else if (Character.isDigit(ch) || ch == '.')
            parseNumber();
        else if (ch == '(') {
            pos++;
            parseExpression();
            skip();
            if (next() != ')')
                error("Expected a right parenthesis.");
            pos++;
        } else if (ch == ')')
            error("Unmatched right parenthesis.");
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
            error("Operator '" + ch + "' found in an unexpected position.");
        else if (ch == 0)
            error("Unexpected end of data in the middle of an expression.");
        else
            error("Illegal character '" + ch + "' found in data.");
    }

    private void parseWord() {
        StringBuilder w = new StringBuilder();
        while (Character.isLetterOrDigit(next())) {
            w.append(next());
            pos++;
        }
        w = new StringBuilder(w.toString());
        for (Constants.Constant constant : constantsList) {
            if (w.toString().equals(constant.symbol)) {
                code[codeSize++] = (byte) constantCt;
                constants[constantCt++] = constant.value;
                return;
            }
        }
        w = new StringBuilder(w.toString().toLowerCase());
        for (int i = 0; i < functionNames.length; i++) {
            if (w.toString().equals(functionNames[i]) && i < 15) {
                skip();
                if (next() != '(')
                    error("Function name '" + w + "' must be followed by its parameter in parentheses.");
                pos++;
                parseExpression();
                skip();
                if (next() != ')')
                    error("Missing right parenthesis after parameter of function '" + w + "'.");
                pos++;
                code[codeSize++] = (byte) (SIN - i);
                return;
            } else if (w.toString().equals(functionNames[i]) && i >= 15) {
                skip();
                if (next() != '(')
                    error("Function name '" + w + "' must be followed by its parameter in parentheses.");
                pos++;
                parseExpression();
                skip();
                if (next() != ',') {
                    error("Missing comma after parameter of function '" + w + "'.");
                }
                pos++;
                parseExpression();
                skip();
                if (next() != ')')
                    error("Missing right parenthesis after parameter of function '" + w + "'.");
                pos++;
                code[codeSize++] = (byte) (SIN - i);
                return;
            }
        }
        error("Unknown word '" + w + "' found in data.");
    }

    private void parseNumber() {
        StringBuilder w = new StringBuilder();
        while (Character.isDigit(next())) {
            w.append(next());
            pos++;
        }
        if (next() == '.') {
            w.append(next());
            pos++;
            while (Character.isDigit(next())) {
                w.append(next());
                pos++;
            }
        }
        if (w.toString().equals("."))
            error("Illegal number found, consisting of decimal point only.");
        if (next() == 'E' || next() == 'e') {
            w.append(next());
            pos++;
            if (next() == '+' || next() == '-') {
                w.append(next());
                pos++;
            }
            if (!Character.isDigit(next()))
                error("Illegal number found, with no digits in its exponent.");
            while (Character.isDigit(next())) {
                w.append(next());
                pos++;
            }
        }
        double d = Double.NaN;
        try {
            d = Double.parseDouble(w.toString());
        } catch (Exception ignored) {
        }
        if (Double.isNaN(d))
            error("Illegal number '" + w + "' found in data.");
        code[codeSize++] = (byte) constantCt;
        constants[constantCt++] = d;
    }

    public static void main(String[] args) {
        //        Expr expr = new Expr("sin(1)+cos(2)");
        //        System.out.println(expr.value(1));
        //        System.out.println(Arrays.toString(expr.code));
        //        System.out.println(Arrays.toString(expr.constants));

        //        Expr expr2 = new Expr("rt(8,3)");
        //        System.out.println(expr2.value(1));
        //        System.out.println(Arrays.toString(expr2.code));
        //        System.out.println(Arrays.toString(expr2.constants));

        //        Expr expr3 = new Expr("mod(10,3)");
        //        System.out.println(expr3.value(1));
        //        System.out.println(Arrays.toString(expr3.code));
        //        System.out.println(Arrays.toString(expr3.constants));

        //        Expr test = new Expr("π");
        //        System.out.println(test.value(0));
        //        Expr test = new Expr("cos(π)");
        //        System.out.println(test.value(0));
        //        test = new Expr("e");
        //        System.out.println(test.value(0));
        //        test = new Expr("qp");
        //        System.out.println(test.value(0));
        //        test = new Expr("h1");
        //        System.out.println(test.value(0));

        Expr test = new Expr("randInt(1,10)");
        System.out.println(test.value(0));
        //        System.out.println(Expr.constantsList);
        //        Field[] fields = Constants.class.getDeclaredFields();
        //        for (Field f : fields) {
        //            if (Modifier.isStatic(f.getModifiers())) {
        ////                System.out.println(f.getType());
        ////                System.out.println(f.getName());
        //                // get object from constants class with name f.getName()
        //                Constants.Constant o = null;
        //                try {
        //                    o = (Constants.Constant) f.get(null);
        //                } catch (IllegalAccessException e) {
        //                    e.printStackTrace();
        //                }
        //                System.out.println(o.symbol);
        //            }
        //        }
    }


} // end class Expr
