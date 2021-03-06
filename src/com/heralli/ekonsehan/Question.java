package com.heralli.ekonsehan;

import javax.swing.ImageIcon;

public class Question implements IQuestion {

	public static final String EASY = "Easy";
	public static final String AVERAGE = "Average";
	public static final String DIFFICULT = "Difficult";
	
	
	public static final String TRUE_OR_FALSE = "True or False";
	public static final String IDENTIFICATION = "Identification";
	public static final String MULTIPLE_CHOICE = "Multiple Choice";
	public static final String PROBLEM_SOLVING = "Problem Solving";
	public static final String BONUS = "Bonus";
	
	
	protected String id;
	protected String question;
	protected String answer;
	protected String level = EASY;
	protected ImageIcon questionImage;
	protected ImageIcon answerImage;
	
	
	public Question(){}
	
	public Question(String id, String question, String answer, String level, String qi, String ai)
	{
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.level = level;
		this.questionImage = new ImageIcon(qi);
		this.answerImage = new ImageIcon(ai);
	}
	
	public void setQuestionImage(ImageIcon questionImage)
	{
		this.questionImage = questionImage;
	}
	
	public ImageIcon getQuestionImage()
	{
		return questionImage;
	}
	
	public void setAnswerImage(ImageIcon answerImage)
	{
		this.answerImage = answerImage;
	}
	
	public ImageIcon getAnswerImage()
	{
		return answerImage;		
	}
	
	@Override
	public void setQuestion(String question) {
		this.question = question;

	}

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;		
	}

	@Override
	public String getLevel() {
		// TODO Auto-generated method stub
		return level;
	}
	
	public void setLevel(String level)
	{
		this.level=level;
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTimeAllowed() {
		if (level.equals(EASY))
			return 10;
		if (level.equals(AVERAGE))
			return 15;
		if (level.equals(DIFFICULT))
			return 20;		
		return 0;
	}
	
	public int getPoints() {
		if (level.equals(EASY))
			return 5;
		if (level.equals(AVERAGE))
			return 10;
		if (level.equals(DIFFICULT))
			return 15;		
		return 0;
	}

	public String getId(){
		return id;
	}
	
}
