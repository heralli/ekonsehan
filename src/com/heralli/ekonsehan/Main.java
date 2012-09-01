package com.heralli.ekonsehan;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException
	{
		//SplashScreen test = new SplashScreen();
		QuestionManager qm = new QuestionManager();
		qm.loadQuestions();
		MainWindow mainWin = new MainWindow(qm);
		mainWin.setVisible(true);
		mainWin.transferFocus();
		
	}
}
