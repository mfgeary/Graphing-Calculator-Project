/**
 * Interpreter.java
 *
 * Class to generate ExprNode trees based on a given
 * input.
 *
 * @author Marion Geary
 * CSCI 235, Wheaton College, Fall 2020
 * Project 7
 * December 11, 2020
 */

public class Interpreter {

    /**
     * Turn a string into an ExprNode tree.
     * Parse the string, puts it in the proper class, and returns
     * the input as an ExprNode.
     * @param input The string to parse
     * @return The root of the ExprNode tree
     */
    public static ExprNode parse(String input) {
	// Divides the input into array of strings
	String nodes[] = ExprStringSlicer.slice(input);
	ExprNode out = null; // to store return value
	if(nodes.length == 1) {
	    if(nodes[0].indexOf("x") >= 0) {
		// sorts the variable part of the function
		// to a Variable node
		Variable variable = new Variable(nodes[0]);
		out = variable;
	    } else {
		// sorts the numeric part of the function
		// to a Number node
		Number number = new Number(nodes[0]);
		out = number;
	    }
	} else {
	    // stores the node to the left of the operator
	    ExprNode expr1 = parse(nodes[0]);
	    // stores the node to the right of the operator
	    ExprNode expr2 = parse(nodes[2]);
	    // stores the parsed function as an Operation node
	    Operation operation = new Operation(nodes[1], expr1, expr2);
	    out = operation;
	}
	return out;
    }

    /**
     * For testing project 7 (Part A).
     */
    public static void main(String[] args) {
	ExprNode tree = parse(args[0]);
        System.out.println(tree.evaluate(Double.parseDouble(args[1])));
    }
}
