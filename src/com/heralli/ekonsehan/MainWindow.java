package com.heralli.ekonsehan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class MainWindow extends JFrame implements KeyListener{
		QuestionManager qm;
	
	
		public MainWindow(QuestionManager qm) throws IOException{
			
			this.setExtendedState(MAXIMIZED_BOTH);
			this.setUndecorated(true);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.requestFocus();
			
			
			this.qm = qm;
						
			QuestionView qv = new QuestionView(qm);
			this.getContentPane().add(qv);
			
			this.addKeyListener(this);
			
			this.pack();
						
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				int choice=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?", "EKonsehan", JOptionPane.YES_NO_OPTION);
				if (choice == 0)
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

