package com.heralli.ekonsehan;

public class Question implements IQuestion {

	public static final int EASY=0;
	public static final int AVERAGE=1;
	public static final int DIFFICULT=2;
	
	
	public static final int TRUE_OR_FALSE=0;
	public static final int IDENTIFICATION=1;
	public static final int MULTIPLE_CHOICE=2;
	public static final int PROBLEM_SOLVING=3;
	
	
	private String question;
	private String answer;
	private int level;
	
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

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return level;
	}
	
	public void setLevel(int level)
	{
		this.level=level;
		
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTimeAllowed() {
		// TODO Auto-generated method stub
		return 0;
	}

}
