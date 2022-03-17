import java.util.Stack;

public class Operations {
    /**
     * The method takes a string as input and returns the result of the expression.
     *
     * @param expression The expression to be evaluated.
     * @return The result of the expression.
     */
    public double calculate(String expression) {
        char[] tokens = expression.toCharArray();

        // use 2 stacks to store operators and operands
        Stack<Double> operands = new Stack<>();
        Stack<Character> operations = new Stack<>();

        // iterate through the tokens
        for (int i = 0; i < tokens.length; i++) {
//            System.out.println("i: " + i);
//            System.out.println("operands: " + operands);
//            System.out.println("operations: " + operations);
            if (tokens[i] == ' ') {
                continue;
            }

            // if the token is an operand, push it to operand stack
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sb.append(tokens[i++]);
                }
                operands.push(Double.parseDouble(sb.toString()));
                i--;
            }
            // if token is '!' calculate factorial of stack's top and push it to operand stack
            else if (tokens[i] == '!') {
                operands.push((double) BasicMath.factorial(operands.pop().intValue()));
            }
            // if the token is "(" push it to the operation stack
            else if (tokens[i] == '('){
                operations.push(tokens[i]);
            }
            // if the token is ")" calculate everything inside the brackets
            else if (tokens[i] == ')') {
                while (!operations.peek().equals('(')) {
                    operands.push(applyOp(operations.pop(), operands.pop(), operands.pop()));
                }
                operations.pop();
            }
            // if the token is an operator, apply the operation to the top two operands
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^') {
                // if the token is an operator with higher precedence than the top of the stack, calculate everything in the stack
                while (!operations.empty() && hasPrecedence(tokens[i], operations.peek())) {
                    operands.push(applyOp(operations.pop(), operands.pop(), operands.pop()));
                }
                operations.push(tokens[i]);
            }
        }
        // calculate the remaining operations in the stack
        while (!operations.empty()) {
            operands.push(applyOp(operations.pop(), operands.pop(), operands.pop()));
        }

        return operands.pop();
    }

    // pemdas:
    // parentheses
    // exponent
    // multiplication
    // division
    // addition
    // subtraction

    /**
     * Check if op1 has higher precedence than op2 according to PEMDAS.
     *
     * @param op1 The first operator.
     * @param op2 The second operator.
     * @return True if op1 has higher precedence than op2.
     */
    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '^') && (op2 == '*' || op2 == '/' || op2 == '+' || op2 == '-')) {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    /**
     * Apply the operation to a, b.
     * b is inserted first to make sure that the order of the operands is correct.
     *
     * @param op The operation to be applied.
     * @param b The second operand.
     * @param a The first operand.
     * @return The result of the operation.
     */
    private double applyOp(char op, double b, double a) {
        return switch (op) {
            case '+' -> BasicMath.add(a, b);
            case '-' -> BasicMath.subtract(a, b);
            case '*' -> BasicMath.multiply(a, b);
            case '/' -> BasicMath.divide(a, b);
            case '^' -> BasicMath.power(a, b);
            default -> 0;
        };
    }

    public static void main(String[] args) {
        Operations operations = new Operations();
        String s;
        s = "1+2-3*4";
        System.out.println(operations.calculate(s));

        s = "123+456*61-7876";
        System.out.println(operations.calculate(s));

        s = "(1+2*3+4)*(5+6)*7+8*9";
        System.out.println(operations.calculate(s));

        s = "1 + 33";
        System.out.println(operations.calculate(s));

        s = "(2+2)!*2";
        System.out.println(operations.calculate(s));

        s = "3+3^3*3";
        System.out.println(operations.calculate(s));

//        // should throw an exception
//        s = "1/(10-10)";
//        System.out.println(operations.calculate(s));
//
//        // should throw an exception
//        s = "(1+2-3))*5";
//        System.out.println(operations.calculate(s));

    }
}
