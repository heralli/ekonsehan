package com.heralli.ekonsehan;

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
			
			ImageIcon im = new ImageIcon(getClass().getResource("/resources/fadedbackground.jpg"));
			BackgroundPanel p = new BackgroundPanel(im.getImage(),0);
			this.getContentPane().add(p);
						
			
		}
			    
}

