package com.heralli.ekonsehan;

public class ProblemSolvingQuestion extends Question{
	
	public ProblemSolvingQuestion(){}
	
	public ProblemSolvingQuestion(String question, String answer, String level)
	{
		this.question = question;
		this.answer = answer;
		this.level = level;
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return Question.PROBLEM_SOLVING;
	}
}
