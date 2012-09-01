package com.heralli.ekonsehan;

import java.util.Vector;

import javax.swing.ImageIcon;

public class MultipleChoiceQuestion extends Question {
	Vector<String> choices = new Vector<String>();
	
	public MultipleChoiceQuestion(){}
	
	public MultipleChoiceQuestion(String id, String question, String answer, String level, String qi, String ai)
	{
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.level = level;
		this.questionImage = new ImageIcon(qi);
		this.answerImage = new ImageIcon(ai);
	}
	
	public void addChoice(String choice)
	{
		choices.addElement(choice);
	}
	
	public String getChoice(int i)
	{
		return choices.elementAt(i);	
	}
	
	public int getChoiceCount(){
		return choices.size();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return Question.MULTIPLE_CHOICE;
	}

	
	
}
