package com.heralli.ekonsehan;

public class TrueFalseQuestion extends Question {
	
	public TrueFalseQuestion(){}
	
	public TrueFalseQuestion(String question, String answer, String level)
	{
		this.question = question;
		this.answer = answer;
		this.level = level;
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return Question.TRUE_OR_FALSE;
	}
}
