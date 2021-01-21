/**
 * Operation.java
 *
 * A class for operations.
 *
 * @author Marion Geary
 * Wheaton College, CSCI 235, Fall 2020
 * Project 7
 * December 11, 2020
 */

public class Operation implements ExprNode {

    /**
     * The string of the operator.
     */
    private String operator;

    /**
     * The left node.
     */
    private ExprNode left;

    /**
     * The right node.
     */
    private ExprNode right;

    /**
     * Constructor for the operator.
     * @param text The String of the input function
     * @param leftOperand The expression to the left of the operand
     * @param rightOperand The expression to the right of the operand
     */
    public Operation(String text, ExprNode leftOperand, ExprNode rightOperand) {
	operator = text;
	left = leftOperand;
	right = rightOperand;
    }

    /**
     * Returns output of the input into the function.
     * Evaluates the function given the operator.
     * @param x The double value input into the function
     * @return The output of the function
     */
    public double evaluate(double x) {
	if(operator.equals("+")) {
	    return left.evaluate(x) + right.evaluate(x);
	} else if (operator.equals("-")) {
	    return left.evaluate(x) - right.evaluate(x);
	} else if (operator.equals("*")) {
	    return left.evaluate(x) * right.evaluate(x);
	} else if (operator.equals("/")) {
	    return left.evaluate(x) / right.evaluate(x);
	} else {
	    return Math.pow(left.evaluate(x), right.evaluate(x));
	}
    }
}
