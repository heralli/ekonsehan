package com.heralli.ekonsehan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

/**
 * Delimeter is semicolon
 * Column 1 - QID
 * Column 2 - Question Type;0-TF,1-Ide,2-multi,3-prob
 * Column 3 - Question
 * Column 4 - Answer
 * Column 5 - LEvel
 * Column 6 - Question Image
 * Column 7 - Answer Image
 * Columns 8-12, multiple choice
 * 
 * @author jachermocilla
 *
 */


public class QuestionManager {

	Vector<Question> questions = new Vector<Question>();
	
	int qIndex = 0;
	
	public Question getNextQuestion()
	{
		Question q = questions.elementAt(qIndex); 
		if (qIndex < questions.size()-1)
			qIndex++;
		else
			qIndex = 0;
		return q;
					
	}
	
	
	public void loadQuestions() throws IOException
	{
		//BufferedReader CSVFile = new BufferedReader(new FileReader(getClass().getResource("/resources/questions.txt").getFile()));
		BufferedReader CSVFile = new BufferedReader(new FileReader("questions.txt"));
        String dataRow = CSVFile.readLine();
        while (dataRow != null){
            String[] dataArray = dataRow.split(";");
                
            MultipleChoiceQuestion mq;
            
            if (dataArray[1].equals("1"))
            {
            	questions.add(new IdentificationQuestion(dataArray[0],dataArray[2],dataArray[3],dataArray[4],dataArray[5],dataArray[6]));
            }
            else if (dataArray[1].equals("2"))
            {
            	questions.add(mq=new MultipleChoiceQuestion(dataArray[0],dataArray[2],dataArray[3],dataArray[4],dataArray[5],dataArray[6]));
            	mq.addChoice(dataArray[7]);
            	mq.addChoice(dataArray[8]);
            	mq.addChoice(dataArray[9]);
            	mq.addChoice(dataArray[10]);
            	mq.addChoice(dataArray[11]);
            	
            }
            else if (dataArray[1].equals("3"))
            {
            	questions.add(new ProblemSolvingQuestion(dataArray[0],dataArray[2],dataArray[3],dataArray[4],dataArray[5],dataArray[6]));            	
            }
            else if (dataArray[1].equals("0"))
            {
            	questions.add(new TrueFalseQuestion(dataArray[0],dataArray[2],dataArray[3],dataArray[4],dataArray[5],dataArray[6]));            	
            }
            
            
            
            
            for (String item:dataArray)
            { 
            	System.out.print("[" + item + "]"); 
            }
            System.out.println(); // Print the data line.
            dataRow = CSVFile.readLine(); // Read next line of data.
        }
        // Close the file once all data has been read.
        CSVFile.close();
		
        System.out.println(questions.size());
        //Collections.shuffle(questions);
	}
	
	
	
}
