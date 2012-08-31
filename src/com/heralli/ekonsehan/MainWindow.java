package com.heralli.ekonsehan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class MainWindow extends JFrame implements KeyListener{
		public MainWindow(){
			this.setExtendedState(MAXIMIZED_BOTH);
			this.setUndecorated(true);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.requestFocus();
			
			MultipleChoiceQuestion q1 = new MultipleChoiceQuestion();
			q1.setQuestion("Who is the father of Economics? This makes the question longer. The quick brown fox jumps over the lazy dog. I wonder how long this string can be because it's interesting to know");
			q1.addChoice("a. Adam Smith"); 
			q1.addChoice("b. Adam Sandler");
			q1.addChoice("c. Alan Turing");
			q1.addChoice("d. Alan K");
			q1.setLevel(Question.AVERAGE);
			q1.setAnswer("a. Adam Smith");
			
			
			IdentificationQuestion q2 = new IdentificationQuestion();
			q2.setQuestion("What is the best PL?");
			q2.setAnswer("Java");
			
			QuestionView qv = new QuestionView();
			qv.setQuestion(q1);
			this.getContentPane().add(qv);
			
			this.addKeyListener(this);
			
			this.pack();
						
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				this.dispose();				
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
			    
}

