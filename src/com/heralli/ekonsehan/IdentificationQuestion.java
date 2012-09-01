package com.heralli.ekonsehan;

import javax.swing.ImageIcon;

public class IdentificationQuestion extends Question {
	
	public IdentificationQuestion(){}
	
	public IdentificationQuestion(String id, String question, String answer, String level, String qi, String ai)
	{
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.level = level;
		this.questionImage = new ImageIcon(qi);
		this.answerImage = new ImageIcon(ai);
	}
	
	public String getType() {
		// TODO Auto-generated method stub
		return Question.IDENTIFICATION;
	}
}
