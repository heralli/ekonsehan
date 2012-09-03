package com.heralli.ekonsehan;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QuestionView extends JPanel implements MouseListener, ActionListener{
	
	BackgroundPanel blankPanel;
	TypePanel typePanel = new TypePanel();
	QuestionPanel questionPanel = new QuestionPanel();
	TimesUpPanel timesUpPanel = new TimesUpPanel();
	AnswerPanel answerPanel = new AnswerPanel();
	TimesUpPanel timesUpPanel1 = new TimesUpPanel();
	
	
	
	//Question q;
	
	int qCount=1;
	
	int state=0; 
		
	QuestionManager qm;
	
	CardLayout cl = new CardLayout();
	
	
	public QuestionView(QuestionManager qm)
	{
		addMouseListener(this);
		this.qm = qm;
		start(qm.getNextQuestion());
	}
	
	public void start(Question q)
	{
		
		ImageIcon im;
		this.setLayout(cl);
		this.setBackground(new Color(31,73,125));
		
		im = new ImageIcon(getClass().getResource("/resources/teaser.jpg"));
		blankPanel = new BackgroundPanel(im.getImage(),BackgroundPanel.SCALED);
		
		this.add(blankPanel,"0");
		
		typePanel.setQuestion(q);
		this.add(typePanel,"1");
		
		timesUpPanel.setMessage("(Submit your bets to your proctor)");
		this.add(timesUpPanel,"2");
		
		questionPanel.setQuestion(q);
		this.add(questionPanel,"3");
		
		timesUpPanel1.setMessage("(Submit your answer to your proctor)");
		this.add(timesUpPanel1,"4");
		
		answerPanel.setQuestion(q);		
		this.add(answerPanel,"5");		
				
		
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
	
	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseClicked(MouseEvent e){
		Question q;
		if (state > 5){
			state = 0;
			if ((qm.getCurrentCount() == 10) || (qm.getCurrentCount() == 21) || (qm.getCurrentCount() == 32)) 
				start(qm.getNextBonus());
			else	
				start(qm.getNextQuestion());
		}else{
			CardLayout cl = (CardLayout)(this.getLayout());
			cl.show(this, state+"");
			System.out.println(state);
			state++;
		}
	}
	    
	public void actionPerformed(ActionEvent e){
		mouseClicked(null);
	}
	        
    class AnswerPanel extends JPanel implements MouseListener
    {
    	JTextField lblAnswer;
    	JPanel bottomB;
    	JLabel lblAnswerImage;
	    	
	    	
    	public AnswerPanel()
    	{
    		//JPanel topB = new JPanel();
    		//topB.setBackground(new Color(31,73,125));
	    		
    		bottomB = new JPanel(new FlowLayout());
    		bottomB.setBackground(new Color(31,73,125));
    		bottomB.add(lblAnswerImage = new JLabel(),BorderLayout.NORTH);
    		lblAnswerImage.addMouseListener(this);
	    				
    		JPanel centerB = new JPanel(new GridLayout(2,1));
    		centerB.setBackground(new Color(255,255,255));
	    		
    		JLabel lbl = new JLabel("Correct answer: ");
    		lbl.setHorizontalAlignment(SwingConstants.CENTER);
    		lbl.setFont(new Font("Arial", Font.PLAIN, 50));
    		centerB.add(lbl);
	    			    		
    		lblAnswer = new JTextField();
    		lblAnswer.setFont(new Font("Arial", Font.BOLD, 50));
    		//lblAnswer.setLineWrap(true);
    		//lblAnswer.setWrapStyleWord(true);
    		lblAnswer.setEditable(false);
    		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
    		lblAnswer.setForeground(new Color(31,73,125));
    		centerB.add(new JScrollPane(lblAnswer));
	    		
    		setLayout(new GridLayout(2,1));
    		//add(topB);
    		add(centerB);
    		add(bottomB);
    	}
	    	
    	public void setQuestion(Question q)
    	{
    		lblAnswer.setText(q.getAnswer());
    		lblAnswerImage.setIcon(q.getAnswerImage());
    	}

		@Override
		public void mouseClicked(MouseEvent e) {
			state=3;
			cl.show(QuestionView.this, state+"");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	    	
    }
	    
	    
    class TimesUpPanel extends JPanel
    {
    	JLabel top;
    	JLabel bottom;
	    		    	
    	public TimesUpPanel()
    	{
    		JPanel topA = new JPanel();
    		topA.setBackground(new Color(31,73,125));
    		
    		JPanel bottomA = new JPanel();
    		bottomA.setBackground(new Color(31,73,125));
	    				
    		JPanel centerA = new JPanel(new GridLayout(2,1));
    		centerA.setBackground(new Color(255,255,255));
    				
    		top = new JLabel("TIME'S UP!");
    		top.setHorizontalAlignment(SwingConstants.CENTER);
    		top.setFont(new Font("Times New Roman", Font.BOLD, 100));
    		centerA.add(top);
    		
    		bottom = new JLabel();
    		bottom.setHorizontalAlignment(SwingConstants.CENTER);
    		bottom.setFont(new Font("Times New Roman", Font.BOLD, 60));
    		centerA.add(bottom);
	    			
    		setLayout(new GridLayout(3,1));
    		add(topA);
    		add(centerA);
    		add(bottomA);
	    		
    	}
	    	
    	public void setMessage(String msg)
    	{
    		bottom.setText(msg);
    	}
    	
	    	
    }
	    
	    
    class QuestionPanel extends JPanel implements ActionListener
    {
	    QuizTimer qTimer;
	    	
	    JTextArea displayQuestion;
	    JLabel displayPoints;
	    JLabel displayType;
	    JPanel rightCenter;
	    JLabel lblQuestionImage;
	    ChoicePanel choices;
	    JPanel rightBottom;
	    JLabel controlNumber;
	    	
	    public QuestionPanel()
	    {
	    	GridBagLayout layout = new GridBagLayout();
	    	GridBagConstraints c = new GridBagConstraints();
	    	c.fill = GridBagConstraints.BOTH;
	    	setLayout(layout);
	    		
	    	JPanel leftTop = new JPanel(new GridLayout(3,1));
	    	leftTop.setBackground(new Color(31,73,125));
	    	c.gridx =0;
	    	c.gridy =0;
	    	layout.setConstraints(leftTop,c);
	    	qTimer = new QuizTimer();
	    	qTimer.setTimesUpListener(this);
	    	controlNumber = new JLabel("1:1");
	    	displayPoints = new JLabel();
	    	displayType = new JLabel();
	    	
	    		
	    	controlNumber.setForeground(Color.GREEN);
	    	displayPoints.setForeground(Color.YELLOW);
	    	displayType.setForeground(Color.YELLOW);
	    	controlNumber.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    	displayType.setFont(new Font("Times New Roman", Font.BOLD, 50));
	    	displayPoints.setFont(new Font("Times New Roman", Font.BOLD, 40));
	    	controlNumber.setHorizontalAlignment(SwingConstants.CENTER);
	    	displayPoints.setHorizontalAlignment(SwingConstants.CENTER);
	    	displayType.setHorizontalAlignment(SwingConstants.CENTER);
	    	displayType.setVerticalAlignment(SwingConstants.BOTTOM);
	    	displayPoints.setVerticalAlignment(SwingConstants.TOP);
	    		
	    	leftTop.add(controlNumber);
	    	leftTop.add(displayType);
	    	leftTop.add(displayPoints);
	    	
	    		
	    	JPanel rightTop = new JPanel(new BorderLayout());
	    	rightTop.setBackground(new Color(255,255,255));		
	    	c.gridx =1;
	    	c.gridy =0;
	    	layout.setConstraints(rightTop,c);
	    	displayQuestion = new JTextArea();
	    	displayQuestion.setFont(new Font("Arial", Font.PLAIN, 55));
	    	displayQuestion.setLineWrap(true);
	    	displayQuestion.setWrapStyleWord(true);
	    	displayQuestion.setEditable(false);
	    	rightTop.add(new JScrollPane(displayQuestion));
	    		
	    	JPanel leftCenter = new JPanel();
	    	leftCenter.setBackground(new Color(31,73,125));
	    	c.gridx =0;
	    	c.gridy =1;
	    	layout.setConstraints(leftCenter,c);
	    				
	    	rightCenter = new JPanel(new BorderLayout());
	    	rightCenter.setBackground(new Color(255,255,255));		
	    	c.gridx =1;
	    	c.gridy =1;
	    	layout.setConstraints(rightCenter,c);
	    		
	    		
	    				
	    	JPanel leftBottom = new JPanel();
	    	leftBottom.setBackground(new Color(31,73,125));
	    	c.gridx =0;
	    	c.gridy =2;
	    	layout.setConstraints(leftBottom,c);
	    	leftBottom.add(qTimer);
	    		
	    		
	    	rightBottom = new JPanel(new CardLayout());
	    	rightBottom.setBackground(new Color(255,255,255));		
	    	c.gridx =1;
	    	c.gridy =2;
	    	layout.setConstraints(rightBottom,c);
	    	choices = new ChoicePanel();
	    	lblQuestionImage = new JLabel();
	    	rightBottom.add(choices,"choices");
	    	rightBottom.add(lblQuestionImage,"image");
	    		
	    	
	    		
	    	add(leftTop);
	    	add(rightTop);
	    	add(leftCenter);
	    	add(rightCenter);
	    	add(leftBottom);
	    	add(rightBottom);
	    		
	    	layout.columnWeights = new double[]{0.0f,4.0f};
	    	layout.rowWeights = new double[]{2.0f,2.0f};
	    		
	    		
	    	setColumnMinWidth(layout, 0, 300);
	    	setRowMinHeight(layout, 0, 550);
	    	setRowMinHeight(layout, 1, 10);
	    	setRowMinHeight(layout, 2, 80);
	    		
	    }
	    	
	    public void setQuestion(Question q)
	    {
	    	displayQuestion.setText(q.getQuestion());
	    	displayPoints.setText("(" +q.getLevel()+" - " + q.getPoints() + " points )");
	    	displayType.setText(q.getType());
	    	qTimer.setMax(q.getTimeAllowed());
	    	controlNumber.setText((qm.getCurrentCount())+":"+q.getId());
	    	
	    	CardLayout cl = (CardLayout)rightBottom.getLayout();
	    	
	    	if (q.getType() == Question.MULTIPLE_CHOICE)
	    	{	
	    		MultipleChoiceQuestion mq = (MultipleChoiceQuestion)q; 
	    		choices.setQuestion(mq);
	    		cl.show(rightBottom,"choices");
	    	}else{
	    		lblQuestionImage.setIcon(q.getQuestionImage());
	    		cl.show(rightBottom,"image");
	    	}
	    }
	    	
	    public void actionPerformed(ActionEvent e){
	    	QuestionView.this.mouseClicked(null);
		}
    }
	    
	    
    class TypePanel extends JPanel implements ActionListener
    {
	   	QuizTimer betTimer = new QuizTimer(10);
	   	JLabel lblType;
	   	JLabel lblLevel;
	    	
   	   	public TypePanel(){
   	   		JLabel placeBet = new JLabel("Place your bet!");
   	   		placeBet.setForeground(Color.YELLOW);
   	   		placeBet.setFont(new Font("Times New Roman", Font.BOLD, 70));
   	   		placeBet.setHorizontalAlignment(SwingConstants.CENTER);
   	   		placeBet.setVerticalAlignment(SwingConstants.CENTER);
    		JPanel top = new JPanel(new BorderLayout());
    		top.setBackground(new Color(31,73,125));
    		top.add(placeBet,BorderLayout.CENTER);
	    		
    		JPanel bottom = new JPanel();
    		bottom.setBackground(new Color(31,73,125));
	    		
    		betTimer.setTimesUpListener(this);
    		bottom.add(betTimer);
	    		
    		JPanel center = new JPanel(new GridLayout(2,1));
    		center.setBackground(new Color(255,255,255));
	    		
    		lblType = new JLabel();
    		lblType.setHorizontalAlignment(SwingConstants.CENTER);
    		lblType.setFont(new Font("Times New Roman", Font.BOLD, 80));
	    		
    		lblLevel = new JLabel();
    		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
    		lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 70));
    		lblLevel.setForeground(new Color(100,100,100));
    		center.add(lblType);
    		center.add(lblLevel);
	    		
    		setLayout(new GridLayout(3,1));
    		add(top);
    		add(center);
    		add(bottom);
	    		
    	}
	    	
    	public void setQuestion(Question q)
    	{
    		lblType.setText(q.getType());
    		lblLevel.setText("(" +q.getLevel()+" - " + q.getPoints() + " points )");
    		betTimer.setMax(10);
    	}
	    	
    	public void actionPerformed(ActionEvent e){
	    	QuestionView.this.mouseClicked(null);
	    }
    }

	    
    class ChoicePanel extends JPanel{
    	JTextArea choiceA = new JTextArea();
    	JTextArea choiceB = new JTextArea();
    	JTextArea choiceC = new JTextArea();
	   	JTextArea choiceD = new JTextArea();
	   	JTextArea choiceE = new JTextArea();
	    		    	
	   	public ChoicePanel(){
	   		setLayout(new GridLayout(5,1));
	    	choiceA.setFont(new Font("Arial", Font.BOLD, 30));
	    	choiceB.setFont(new Font("Arial", Font.BOLD, 30));
	    	choiceC.setFont(new Font("Arial", Font.BOLD, 30));
	    	choiceD.setFont(new Font("Arial", Font.BOLD, 30));
	    	choiceE.setFont(new Font("Arial", Font.BOLD, 30));
	    		
	    	add(new JScrollPane(choiceA));
	    	add(new JScrollPane(choiceB));
	    	add(new JScrollPane(choiceC));
	    	add(new JScrollPane(choiceD));
	    	add(new JScrollPane(choiceE));
    	}
	    	
    	public void setQuestion(MultipleChoiceQuestion q)
    	{
    		choiceA.setText(q.getChoice(0));
    		choiceB.setText(q.getChoice(1));
    		choiceC.setText(q.getChoice(2));
    		choiceD.setText(q.getChoice(3));
    		choiceE.setText(q.getChoice(4));
    	}
    }
}
