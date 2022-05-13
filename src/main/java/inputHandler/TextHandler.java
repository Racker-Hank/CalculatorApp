package inputHandler;

import operation.Fraction;
import org.w3c.dom.Text;

import java.util.Stack;

public class TextHandler {
    //    public static void mathInputHandler(String expression , Fraction result) {
    //        char[] tokens = expression.toCharArray();
    //
    //        // use 2 stacks to store operators and operands
    //        Stack <Fraction> operands = new Stack <>();
    //        Stack <Character> operations = new Stack <>();
    //
    //        // iterate through the tokens
    //        for (int i = 0; i < tokens.length; i++) {
    //            if (tokens[i] == ' ') {
    //                continue;
    //            }
    //
    //            // if the token is an operand, push it to operand stack
    //            if (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.') {
    //                StringBuilder sb = new StringBuilder();
    //                boolean hasDot = false;
    //                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')) {
    //                    if (!hasDot && tokens[i] == '.') {
    //                        hasDot = true;
    //                    } else if (hasDot && tokens[i] == '.') {
    //                        System.out.println("error");
    //                    }
    //                    sb.append(tokens[i++]);
    //                }
    //                //                operands.push(Double.parseDouble(sb.toString()));
    //                operands.push(new Fraction(Double.parseDouble(sb.toString())));
    //                i--;
    //            }
    //            // if token is '!' calculate factorial of stack's top and push it to operand stack
    //            else if (tokens[i] == '!') {
    //                //                operands.push((double) MathUtil.factorial((int) (operands.pop().denominator)));
    //                operands.push(new Fraction(MathUtil.factorial((int) (operands.pop().numerator))));
    //            }
    //            // if the token is "(" push it to the operation stack
    //            else if (tokens[i] == '(') {
    //                operations.push(tokens[i]);
    //            }
    //            // if the token is ")" calculate everything inside the brackets
    //            else if (tokens[i] == ')') {
    //                while (!operations.peek().equals('(')) {
    //                    operands.push(calculate(operations.pop() , operands.pop() , operands.pop()));
    //                }
    //                operations.pop();
    //            }
    //            // if the token is an operator, apply the operation to the top two operands
    //            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^') {
    //                // if the token is an operator with higher precedence than the top of the stack, calculate everything in the stack
    //                while (!operations.empty() && hasPrecedence(tokens[i] , operations.peek())) {
    //                    operands.push(calculate(operations.pop() , operands.pop() , operands.pop()));
    //                }
    //                operations.push(tokens[i]);
    //            }
    //        }
    //        // calculate the remaining operations in the stack
    //        while (!operations.empty()) {
    //            operands.push(calculate(operations.pop() , operands.pop() , operands.pop()));
    //        }
    //
    //        //        return operands.pop();
    //        //        System.out.println(operands.pop().toDouble());
    //        result.setValue(operands.pop().simplify());
    //    }
    //
    //    // pemdas:
    //    // parentheses
    //    // exponent
    //    // multiplication
    //    // division
    //    // addition
    //    // subtraction
    //
    //    /**
    //     * Check if op1 has higher precedence than op2 according to PEMDAS.
    //     *
    //     * @param op1 The first operator.
    //     * @param op2 The second operator.
    //     * @return True if op1 has higher precedence than op2.
    //     */
    //    private static boolean hasPrecedence(char op1 , char op2) {
    //        if (op2 == '(' || op2 == ')') {
    //            return false;
    //        }
    //        if ((op1 == '^') && (op2 == '*' || op2 == '/' || op2 == '+' || op2 == '-')) {
    //            return false;
    //        }
    //        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
    //            return false;
    //        }
    //        return true;
    //    }
    //
    //    /**
    //     * Apply the operator to the top three operands.
    //     *
    //     * @param operator The operator.
    //     * @param b        The second operand.
    //     * @param a        The first operand.
    //     * @return The result of the operation.
    //     */
    //    public static Fraction calculate(char operator , Fraction b , Fraction a) {
    //        return switch (operator) {
    //            case '+' -> MathUtil.add(a , b);
    //            case '-' -> MathUtil.subtract(a , b);
    //            case '*' -> MathUtil.multiply(a , b);
    //            case '/' -> MathUtil.divide(a , b);
    //            //            case '^' -> MathUtil.power(a , b);
    //            default -> new Fraction(0);
    //        };
    //    }

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
        } else if (Math.abs((number * Math.pow(10 , decimalNumbers))) - Math.abs(Math.round(number * Math.pow(10 , decimalNumbers))) < 1) {
            result = (Math.round(number * Math.pow(10 , decimalNumbers)) / Math.pow(10 ,
                    decimalNumbers));
        } else {
            result = number;
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
