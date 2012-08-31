package com.heralli.ekonsehan;

import java.util.Vector;

public class MultipleChoiceQuestion extends Question {
	Vector<String> choices = new Vector<String>();
	
	public MultipleChoiceQuestion(){}
	
	public MultipleChoiceQuestion(String question, String answer, String level)
	{
		this.question = question;
		this.answer = answer;
		this.level = level;
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
