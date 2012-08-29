package com.heralli.ekonsehan;

public class Question implements IQuestion {

	public static final int EASY=0;
	public static final int AVERAGE=1;
	public static final int DIFFICULT=2;
	
	
	public static final int TRUE_OR_FALSE=0;
	public static final int IDENTIFICATION=1;
	public static final int MULTIPLE_CHOICE=2;
	public static final int PROBLEM_SOLVING=3;
	
	
	protected String question;
	protected String answer;
	protected int level = EASY;
	
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
		int retval=0;
		switch (level){
		case EASY: return retval=10; 
		case AVERAGE: return retval=15; 
		case DIFFICULT: return retval=20; 
		}
		return retval;
	}

}
