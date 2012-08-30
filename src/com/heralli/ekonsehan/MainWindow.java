package com.heralli.ekonsehan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class MainWindow extends JFrame{
		public MainWindow(){
			this.setExtendedState(MAXIMIZED_BOTH);
			this.setUndecorated(true);
			
						
			MultipleChoiceQuestion q1 = new MultipleChoiceQuestion();
			q1.setQuestion("Who is the father of Economics?");
			q1.addChoice("a. Adam Smith"); 
			q1.addChoice("b. Adam Sandler");
			q1.addChoice("c. Alan Turing");
			q1.addChoice("d. Alan K");
			q1.setLevel(Question.EASY);
			
			QuestionView qv = new QuestionView(q1);
			this.getContentPane().add(qv);
			
			this.pack();
						
			
		}
			    
}

