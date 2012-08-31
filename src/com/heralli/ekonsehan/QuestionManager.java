package com.heralli.ekonsehan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Delimeter is semicolon
 * Column 1 - Question Type
 * Column 2 - Question
 * Column 3 - Answer
 * Column 4 - Choices
 * 
 * 
 * 
 * @author jachermocilla
 *
 */


public class QuestionManager {

	
	public void loadQuestions(String filename) throws IOException
	{
		BufferedReader CSVFile = new BufferedReader(new FileReader("Example.csv"));

        String dataRow = CSVFile.readLine();
        while (dataRow != null){
            String[] dataArray = dataRow.split(";");
            for (String item:dataArray)
            { 
            	System.out.print(item + "\t"); 
            }
            System.out.println(); // Print the data line.
            dataRow = CSVFile.readLine(); // Read next line of data.
        }
        // Close the file once all data has been read.
        CSVFile.close();
		
	}
	
	
	
}
