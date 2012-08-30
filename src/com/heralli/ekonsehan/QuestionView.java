package com.heralli.ekonsehan;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class QuestionView extends JPanel implements MouseListener{
	BackgroundPanel blankPanel;
	JPanel typePanel;
	JPanel questionPanel;
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
		
		
		//--------------------------------------------------------------------
		JPanel top = new JPanel();
		top.setBackground(new Color(31,73,125));
		
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(31,73,125));
		
		JPanel center = new JPanel(new GridLayout(2,1));
		center.setBackground(new Color(255,255,255));
		
		JLabel lblType = new JLabel(q.getType());
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 80));
		
		JLabel lblLevel = new JLabel("(" +q.getLevel()+" - " + q.getPoints() + " points )");
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 70));
		lblLevel.setForeground(new Color(100,100,100));
		center.add(lblType);
		center.add(lblLevel);
		
		typePanel = new JPanel(new GridLayout(3,1));
		typePanel.add(top);
		typePanel.add(center);
		typePanel.add(bottom);
		//-----------------------------------------------------------------
		
		this.add(typePanel,"1");
		
		
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		questionPanel = new JPanel(layout);
		
		JPanel left = new JPanel();
		left.setBackground(new Color(31,73,125));
		left.setFont(new Font("Arial", Font.BOLD, 60));
		c.gridx =0;
		c.gridy =0;
		layout.setConstraints(left,c);
		
		JPanel right = new JPanel(new BorderLayout());
		right.setBackground(new Color(255,255,255));		
		c.gridx =1;
		c.gridy =0;
		layout.setConstraints(right,c);
		JLabel lblQuestion = new JLabel(q.getQuestion());
		lblQuestion.setFont(new Font("Arial", Font.BOLD, 60));
		right.add(lblQuestion);
		
		layout.columnWeights = new double[]{0.0f,4.0f};
		layout.rowWeights = new double[]{10.0f};
		
		
		questionPanel.add(left);
		questionPanel.add(right);

		
		this.setColumnMinWidth(layout, 0, 300);
		this.setRowMinHeight(layout, 0, 600);
		
		this.add(questionPanel,"2");
		
		addMouseListener(this);
		
		
	}
	
	
	// Sets the minimum width for column c to be w pixels wide
	public void setColumnMinWidth(GridBagLayout gbl, int c, int w) {
	    int[] ws = gbl.columnWidths;
	    if (ws == null) {
	        ws = new int[c+1];
	    } else if (ws.length < c+1) {
	        ws = new int[c+1];
	        System.arraycopy(gbl.columnWidths, 0, ws, 0, gbl.columnWidths.length);
	    }
	    ws[c] = w;
	    gbl.columnWidths = ws;
	}

	// Sets the minimum height for row r to be h pixels high
	public void setRowMinHeight(GridBagLayout gbl, int r, int h) {
	    int[] hs = gbl.rowHeights;
	    if (hs == null) {
	        hs = new int[r+1];
	    } else if (hs.length < r+1) {
	        hs = new int[r+1];
	        System.arraycopy(gbl.rowHeights, 0, hs, 0, gbl.rowHeights.length);
	    }
	    hs[r] = h;
	    gbl.rowHeights = hs;
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
