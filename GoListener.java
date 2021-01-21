/**
 * GoListener.java
 *
 * Action listener for the Go button.
 *
 * @author Marion Geary
 * CSCI 235, Wheaton College, Fall 2020
 * Project 7
 * December 11, 2020
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoListener implements ActionListener, Painter {

    /**
     * Text field for the function to be graphed.
     */
    private JTextField funcField;

    /**
     * Text field for the minimum x value.
     */
    private JTextField xminField;

    /**
     * Text field for the minimum y value.
     */
    private JTextField yminField;

    /**
     * Text field for the maximum x value.
     */
    private JTextField xmaxField;

    /**
     * Text field for the maximum y value.
     */
    private JTextField ymaxField;

    /**
     * Panel where the graph will be painted.
     */
    private PaintPanel graphPanel;

    /**
     * Label to display error message.
     */
    private JLabel error;

    /**
     * Constructor for the action listener for the go button.
     * @param funcField Text field for the function to graph
     * @param xminField Text field for the minimum x value
     * @param yminField Text field for the minimum y value
     * @param xmaxField Text field for the maximum x value
     * @param ymaxField Text field for the maximum y value
     * @param graphPanel Paint panel  where the graph is drawn
     */
    public GoListener(JTextField funcField, JTextField xminField, JTextField yminField, JTextField xmaxField, JTextField ymaxField, PaintPanel graphPanel, JLabel error) {
	this.funcField = funcField;
	this.xminField = xminField;
	this.yminField = yminField;
	this.xmaxField = xmaxField;
	this.ymaxField = ymaxField;
	this.graphPanel = graphPanel;
	this.error = error;
    }

    /**
     * Paint the desired function on the panel.
     * @param e Unused
     */
    public void actionPerformed(ActionEvent e) {
	// parse the inputs and handle faulty inputs
	try {
	    // reset error text
	    error.setText("");
	    // parse values of the max and min inputs
	    double xmin = Double.parseDouble(xminField.getText());
	    double ymin = Double.parseDouble(yminField.getText());
	    double xmax = Double.parseDouble(xmaxField.getText());
	    double ymax = Double.parseDouble(ymaxField.getText());
	    // parse the function
	    ExprNode tree = Interpreter.parse(funcField.getText());
	    graphPanel.repaint();
	} catch (Exception x) {
	    error.setText("Please enter valid inputs.");
       	}
    }

    public void paint(Graphics g) {
	// set the panel as the painter
	graphPanel.setPainter(this);
	// parse values of the max and min inputs
	double xmin = Double.parseDouble(xminField.getText());
	double ymin = Double.parseDouble(yminField.getText());
	double xmax = Double.parseDouble(xmaxField.getText());
	double ymax = Double.parseDouble(ymaxField.getText());
	// ints for the heigh and width of the window
	int height = graphPanel.height();
	int width = graphPanel.width();
	// ranges of the input min and max values
	double xrange = xmax - xmin;
	double yrange = ymax - ymin;
	// factors used to convert Cartesian coordiantes to pixels
	double xfactor = xrange / (double)width;
	double yfactor = yrange / (double)height;
	
	// draw x axis
	if(ymin <= 0 && ymax >= 0) {
	    g.drawLine(0, yToRow(0), width, yToRow(0));
	}
	// draw y axis
	if(xmin <= 0 && xmax >= 0) {
	    g.drawLine(xToCol(0), 0, xToCol(0), height);
	}
	
	// parse value of the function
	ExprNode tree = Interpreter.parse(funcField.getText());

	// find the corresponding y value for each horizontal pixel
	// and paint a rectangle
	for(double xval = xmin; xval < xmax; xval = xval + xfactor) {
	    g.fillRect(xToCol(xval), yToRow(tree.evaluate(xval)), 1, 1);
	}
    }

    /**
     * Convert the double for the x Cartesian coordinate to 
     * an int for the corresponding horizontal pixel.
     * @param x The Cartesian x value input into the function
     * @return c The int pixel corresponding to the x input
     */
    private int xToCol(double x) {
	// parse values of x min and max
	double xmin = Double.parseDouble(xminField.getText());
	double xmax = Double.parseDouble(xmaxField.getText());
	// width of the paint panel
	double width = graphPanel.width();
	// range of the x min and max
	double xrange = xmax - xmin;
	// x value input into the function
	double xvalue = x - xmin;
	// factor to convert Cartesian to pixel
	double cfactor = width / xrange;
	// formula to convert Cartesian x to x pixel
	int c = (int)(cfactor * xvalue);
	return c;
    }

    /**
     * Convert the double for the y Cartesian coordinate to
     * an int for the corresponding vertical pixel.
     * @param y The Cartesian y value output of the function
     * @return r The int pixel corresponding to the y output
     */
    private int yToRow(double y) {
	// parse values of y min and max
	double ymin = Double.parseDouble(yminField.getText());
	double ymax = Double.parseDouble(ymaxField.getText());
	// height of the paint panel
	double height = graphPanel.height();
	// range of the y min and max
	double yrange = ymax - ymin;
	// y value output of the function
	double yvalue = ymax - y;
	// factor to convert Cartesian to pixel
	double rfactor = height / yrange;
	// formula to convert Cartesian y to y pixel
	int r = (int)(rfactor * yvalue);
	// avoids graphing unreal output from function
	if(y != y) {
	    return -1;
	} else {
	    return r;
	}
    }
}

