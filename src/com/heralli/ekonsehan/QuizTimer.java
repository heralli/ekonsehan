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
	
	public QuizTimer(int max)
	{
		this.max = max;
		lblSecondsLeft = new JLabel(max+"");
		lblSecondsLeft.setFont(new Font("Arial", Font.PLAIN, 200));
		this.add(lblSecondsLeft);
		timer = new Timer(1000, this);
		this.addMouseListener(this);
	}
	
	public void start(){
		timer.start();		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		new AePlayWave(getClass().getResource("/resources/countdown.wav").getFile()).start();
		lblSecondsLeft.setText((max-(count++))+"");
		if (count>max+1){
			timer.stop();
			timesUpListener.actionPerformed(null);
		}
		
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
