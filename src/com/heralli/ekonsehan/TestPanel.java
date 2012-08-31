package com.heralli.ekonsehan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class TestPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TestPanel() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Identification");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JTextArea txtrHello = new JTextArea();
		txtrHello.setRows(20);
		txtrHello.setText("Hello");
		add(txtrHello, BorderLayout.SOUTH);
		
		JLabel lblTest = new JLabel("Test");
		lblTest.setBackground(Color.RED);
		add(lblTest, BorderLayout.EAST);

	}

}
