package com.heralli.ekonsehan;

import java.util.Vector;

public class MultipleChoiceQuestion extends Question {
	Vector<String> choices = new Vector<String>();
	
	public MultipleChoiceQuestion(){}
	
	
	public MultipleChoiceQuestion(String question)
	{
		super(question);		
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
	
}
