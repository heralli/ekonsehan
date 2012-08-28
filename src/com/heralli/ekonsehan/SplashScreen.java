package com.heralli.ekonsehan;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class SplashScreen extends JFrame{
		public SplashScreen(){
			this.setExtendedState(MAXIMIZED_BOTH);
			this.setUndecorated(true);
			ImageIcon im = new ImageIcon(getClass().getResource("/resources/teaser.jpg"));
			this.getContentPane().add(new JLabel(im));
			this.setVisible(true);
		}	
	    
}

