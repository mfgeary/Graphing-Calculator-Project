/**
 * Variable.java
 *
 * A class for variables.
 *
 * @author Marion Geary
 * Wheaton College, CSCI 235, Fall 2020
 * Project 7
 * December 11, 2020
 */

public class Variable implements ExprNode {

    /**
     * The value of the variable.
     */
    private String variable;

    /**
     * Constructor for the variable.
     */
    public Variable(String text) {
	variable = text;
    }

    /**
     * Returns the value of the variable.
     * @return x The variable
     */
    public double evaluate(double x) {
	return x;
    }
}
