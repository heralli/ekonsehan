package com.heralli.ekonsehan;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class QuestionView extends JPanel implements MouseListener{
	BackgroundPanel blankPanel;
	JPanel typePanel;
	BackgroundPanel questionPanel;
	BackgroundPanel timesUpPanel;
	BackgroundPanel answerPanel;
	
	Question q;
	
	int state=0; 
	
	public QuestionView(Question q)
	{
		ImageIcon im;
		this.setLayout(new CardLayout());
		this.setBackground(new Color(31,73,125));
		
		im = new ImageIcon(getClass().getResource("/resources/teaser.jpg"));
		blankPanel = new BackgroundPanel(im.getImage(),BackgroundPanel.SCALED);
		
		this.add(blankPanel,"0");
		
		JPanel top = new JPanel();
		top.setBackground(new Color(31,73,125));
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(31,73,125));
		
		JPanel center = new JPanel(new GridLayout(2,1));
		center.setBackground(new Color(255,255,255));
		
		JLabel lblType = new JLabel(q.getType());
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 80));
		
		JLabel lblLevel = new JLabel(q.getLevel());
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 70));
		lblLevel.setForeground(new Color(100,100,100));
		
		
		center.add(lblType);
		center.add(lblLevel);
		
		
		typePanel = new JPanel(new GridLayout(3,1));
		typePanel.add(top);
		typePanel.add(center);
		typePanel.add(bottom);
		
		
		this.add(typePanel,"1");
		
		addMouseListener(this);
		
		
	}
	
	public void mousePressed(MouseEvent e) {
	       
	    }

	    public void mouseReleased(MouseEvent e) {
	       
	    }

	    public void mouseEntered(MouseEvent e) {
	       
	    }

	    public void mouseExited(MouseEvent e) {
	       
	    }

	    public void mouseClicked(MouseEvent e) {
	       CardLayout cl = (CardLayout)(this.getLayout());
	       cl.show(this, state+"");
	       state++;
	    }
	
}
