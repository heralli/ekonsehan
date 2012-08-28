package com.heralli.ekonsehan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class QuizTimer {
	
	int period = 1000;
	final int max = 10;
    private int count;

    Timer t;
	
	public QuizTimer(int period, final int max)
	{
		this.period =period;
		t = new Timer(period,new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		            if (count < max) {
		               count++;
		            }
		         }
		      });
	}
	
	public void start()
	{
		t.start();
	
	}
	
	public void stop()
	{
		
	}
	
}
