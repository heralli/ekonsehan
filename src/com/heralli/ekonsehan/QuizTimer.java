package com.heralli.ekonsehan;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class QuizTimer extends JPanel implements ActionListener, MouseListener{
	Timer timer;
	JLabel lblSecondsLeft;
	int max;
	int count=0;
	
	ActionListener timesUpListener;
	
	
	public void setTimesUpListener(ActionListener al)
	{
		this.timesUpListener = al;
	}
	
	public QuizTimer()
	{
		lblSecondsLeft = new JLabel("0");
		lblSecondsLeft.setFont(new Font("Arial", Font.PLAIN, 200));
		this.add(lblSecondsLeft);
		timer = new Timer(1000, this);
		this.addMouseListener(this);
	}
	
	public QuizTimer(int max)
	{
		this.max = max;
		lblSecondsLeft = new JLabel(max+"");
		lblSecondsLeft.setFont(new Font("Arial", Font.PLAIN, 200));
		this.add(lblSecondsLeft);
		timer = new Timer(1000, this);
		this.addMouseListener(this);
	}
	
	public void setMax(int max){
		this.max = max;
		this.count = 0;
		lblSecondsLeft.setText(max+"");
	}
	
	public void start(){
		timer.start();		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String text;
		new AePlayWave(getClass().getResource("/resources/countdown.wav").getFile()).start();
		count++;
		if (count>max){
			timer.stop();
			timesUpListener.actionPerformed(null);
		}
		text = (max-count)+"";
		if ((max-count) < 10)
			text = "0"+(max-count);
		lblSecondsLeft.setText(text);
		
	}
	
	
	public void mousePressed(MouseEvent e) {
	       
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
       
    }

    public void mouseExited(MouseEvent e) {
       
    }

    public void mouseClicked(MouseEvent e) {
    	if (e.getClickCount() == 2)
    	{
    		count = 0;
    	}else if (e.getClickCount() == 1)
    		this.start();
    }
    
    public void play(String filename)
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

	
}
