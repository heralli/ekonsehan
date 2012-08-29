package com.heralli.ekonsehan;

public interface IQuestion {
		
	
	/**
	 * Sets the question
	 * @param question
	 */
	public void setQuestion(String question);
	
	/**
	 * returns the question
	 * @return
	 */
	public String getQuestion();
	
	/**
	 * Returns the answer
	 * @return
	 */
	public String getAnswer();
	
	/**
	 * Return the level: EASY, AVERAGE, DIFFICULT
	 * @return
	 */
	public int getLevel();
	
	/**
	 * Sets the level of the question
	 */
	public void setLevel(int level);
	
	/**
	 * Return the type of Question
	 * @return
	 */
	public int getType();
	
	/**
	 * Returns the allowed time
	 * @return
	 */
	public int getTimeAllowed();	
	
}
