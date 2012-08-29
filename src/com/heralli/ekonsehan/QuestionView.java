package com.heralli.ekonsehan;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestionView extends JPanel implements MouseListener{
	BackgroundPanel blankPanel;
	BackgroundPanel typePanel;
	BackgroundPanel questionPanel;
	BackgroundPanel timesUpPanel;
	BackgroundPanel answerPanel;
	
	Question q;
	
	int state=0; 
	
	public QuestionView(Question q)
	{
		ImageIcon im;
		this.setLayout(new CardLayout());
		
		im = new ImageIcon(getClass().getResource("/resources/teaser.jpg"));
		blankPanel = new BackgroundPanel(im.getImage(),BackgroundPanel.SCALED);
		
		this.add(blankPanel,"0");
		
		im = new ImageIcon(getClass().getResource("/resources/fadedbackground.jpg"));
		typePanel = new BackgroundPanel(im.getImage(),BackgroundPanel.SCALED);
		typePanel.add(new JLabel(q.getQuestion()));
		
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
