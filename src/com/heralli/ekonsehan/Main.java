package com.heralli.ekonsehan;

public class Main {
	public static void main(String args[])
	{
		MultipleChoiceQuestion q1 = new MultipleChoiceQuestion();
		q1.setQuestion("Who is the father of Economics?");
		q1.addChoice("a. Adam Smith"); 
		q1.addChoice("b. Adam Sandler");
		q1.addChoice("c. Alan Turing");
		q1.addChoice("d. Alan K");
		System.out.println(q1.getChoice(3));
	}
}
