package com.heralli.ekonsehan;

public class Question {
	private String level;
	private String question;
	
	public Question(){}
	
	public Question(String question)
	{
		this.question = question;
	}
	
	public void setQuestion(String question){
		this.question = question;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return null;
	}
	
	public String getLevel()
	{
		return null;		
	}
	
	
}
