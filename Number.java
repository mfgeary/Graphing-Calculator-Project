/**
 * Number.java
 *
 * A class for numbers.
 *
 * @author Marion Geary
 * Wheaton College, CSCI 235, Fall 2020
 * Project 7
 * December 11, 2020
 */

public class Number implements ExprNode {
    /**
     * The value of the node.
     */
    private double value;

    /**
     * Constructor for the number.
     */
    public Number(String text) {
	value = Double.parseDouble(text);
    }
    
    /**
     * Return the value of the node.
     * @return value The value of the node.
     */
    public double evaluate(double x) {
	return value;
    }

}
