/**
 * GraphCalc.java
 *
 * Graphing calculator program (class with main method)
 *
 * @author Marion Geary
 * CSCI 235, Wheaton College, Fall 2020
 * Project 7
 * December 11, 2020
 */

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;

public class GraphCalc {

    /**
     * Constructor for the graphing calculator.
     */
    public GraphCalc() {
	// create the window for the calculator
        JFrame window = new JFrame("Graphing calculator");
	window.setLayout(new FlowLayout());
	window.setSize(400, 550);

	// create the panel where the graph will be drawn
        PaintPanel graphPanel = new PaintPanel(350, 350);

	// create the panels for the textfields and button
	JPanel panel2 = new JPanel();
       	panel2.setLayout(new FlowLayout());
	JPanel panel3 = new JPanel();
	panel3.setLayout(new FlowLayout());
	JPanel panel4 = new JPanel();
	panel4.setLayout(new FlowLayout());
	JPanel panel5 = new JPanel();
	panel5.setLayout(new FlowLayout());

	// create the text fields
        JTextField funcField = new JTextField(25);
        JTextField xminField = new JTextField(5);
        JTextField yminField = new JTextField(5);
        JTextField xmaxField = new JTextField(5);
        JTextField ymaxField = new JTextField(5);

	// create the labels
	JLabel func = new JLabel("f(x) =");
	JLabel xmin = new JLabel("x min:");
	JLabel ymin = new JLabel("y min:");
	JLabel xmax = new JLabel("x max:");
	JLabel ymax = new JLabel("y max:");
	JLabel error = new JLabel("");

	// set the initial text in the text fields.
        xminField.setText("-10");
        yminField.setText("-10");
        xmaxField.setText("10");
        ymaxField.setText("10");
	funcField.setText("(x + 1)");

	// create the Go button
        JButton go = new JButton("Go");
	// create the action listener for the Go button
	GoListener gl = new GoListener(funcField, xminField, yminField, xmaxField, ymaxField, graphPanel, error);
	// add the action listener to the button
	go.addActionListener(gl);

	// add the graph panel to the window
	window.add(graphPanel);
	// set the action listener as the painter
      	graphPanel.setPainter(gl);

	// add the text fields, labels, and button to the panel
	panel2.add(func);
	panel2.add(funcField);
	panel3.add(xmin);
	panel3.add(xminField);
	panel3.add(ymin);
	panel3.add(yminField);
	panel4.add(xmax);
	panel4.add(xmaxField);
	panel4.add(ymax);
	panel4.add(ymaxField);
	panel5.add(go);
	panel5.add(error);

	// add the panel to the window
	window.add(panel2);
	window.add(panel3);
	window.add(panel4);
	window.add(panel5);
	
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setVisible(true);	
    }

    public static void main(String[] args) {
	GraphCalc theWindow = new GraphCalc();
    }
}
