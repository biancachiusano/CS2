import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExerciseOne {

	/**
	 * Main Method for exercise 1
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		/**
		 * The main method throws an IOException (FileNotFoundException) if the 
		 * file passed to the scanner is inexistent or misspelled. This exception
		 * is handled with a try and catch clause.
		 */
		try {
			
			int length = 0;
			/**
			 * Scanner that gets the name of the file that will undergo 
			 * the rest of the exercise.
			 */
			Scanner scan1 = new Scanner(System.in);
			System.out.print("Provide the name of a file: ");
			String fileName = scan1.nextLine();
	
			//Creating a new File object of the file passed by the user
			Scanner input = new Scanner(new File(fileName));
			int numOfLines = 0;
			int numOfWords = 0;
			/*
			 * Looping through all of the lines of the file until
			 * all lines have been read
			 */
			while(input.hasNextLine()) {
				//Getting the each line, also counting the lines with the counter (numOfLines)
				String line = input.nextLine();
				//lineArray.add(line);
				numOfLines++;
			}
			input.close();
	
			Scanner input2 = new Scanner(new File(fileName));
			/**
			 * Reading every word in the current line
			 */
			while(input2.hasNext()) {
				String word = input2.next();
				/**
				 *  Increasing the counter, counting the number of words in the 
				 *  file passed by the user.
				 */
				numOfWords++;
				/**
				 * Increasing the counter, summing the number of characters in each word
				 * To count the number of characters in each word: use .length() method
				 */
				length = length + word.length();
	
			}
			//Closing the scanner
			input2.close();
	
			//Printing the number of lines, characters and words for the file passed.
			System.out.println("Number of lines: " + numOfLines);
			System.out.println("Number of Characters: " + length);
			System.out.println("Number of words: " + numOfWords);
		
		}catch(FileNotFoundException e) {
			//Catching the exception
			System.out.println("File Not Found, try again!");
		}
	}

}
