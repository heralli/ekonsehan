package com.heralli.ekonsehan;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	public static void main(String args[])
	{
		//SplashScreen test = new SplashScreen();
		
		MultipleChoiceQuestion q1 = new MultipleChoiceQuestion();
		q1.setQuestion("Who is the father of Economics?");
		q1.addChoice("a. Adam Smith"); 
		q1.addChoice("b. Adam Sandler");
		q1.addChoice("c. Alan Turing");
		q1.addChoice("d. Alan K");
		
		MultipleChoiceQuestionView q1v = new MultipleChoiceQuestionView(q1);
		MainWindow mainWin = new MainWindow();
		//mainWin.getContentPane().add(q1v);
		mainWin.setVisible(true);
		
		/*
		// Determine if full-screen mode is supported directly
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		if (gs.isFullScreenSupported()) {
		    System.out.println("Full screen supported.");
		} else {
			System.out.println("Full screen NOT supported.");
		}

		// Create a button that leaves full-screen mode
		Button btn = new Button("OK");
		btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        // Return to normal windowed mode
		        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		        GraphicsDevice gs = ge.getDefaultScreenDevice();
		        gs.setFullScreenWindow(null);
		    }
		});

		// Create a window for full-screen mode; add a button to leave full-screen mode
		Frame frame = new Frame(gs.getDefaultConfiguration());
		Window win = new Window(frame);
		win.add(btn, BorderLayout.CENTER);

		try {
		    // Enter full-screen mode
		    gs.setFullScreenWindow(win);
		    win.validate();

		    // ...
		} finally {
		    // Exit full-screen mode
		    gs.setFullScreenWindow(null);
		}
		*/
		
	}
}
