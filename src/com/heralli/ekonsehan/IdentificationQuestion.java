package com.heralli.ekonsehan;

public class IdentificationQuestion extends Question {
	
	public IdentificationQuestion(){}
	
	public IdentificationQuestion(String question, String answer, String level)
	{
		this.question = question;
		this.answer = answer;
		this.level = level;
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return Question.IDENTIFICATION;
	}
}
