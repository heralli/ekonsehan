package com.heralli.ekonsehan;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String args[]) throws IOException
	{
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if (screenSize.getWidth() != 1024 && screenSize.getHeight() != 768)
		{
			int choice=JOptionPane.showConfirmDialog(null,"Ekonsehan works best in 1024x768 resolution, which is not currently set. Continue anyway?", "EKonsehan", JOptionPane.YES_NO_OPTION);
			if (choice != 0)
			{
				System.exit(0);
			}
		}
		
		
		
		//SplashScreen test = new SplashScreen();
		QuestionManager qm = new QuestionManager();
		qm.loadQuestions();
		MainWindow mainWin = new MainWindow(qm);
		mainWin.setVisible(true);
		mainWin.transferFocus();
		
	}
}
