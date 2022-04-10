import java.io.*;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Class Find for exercise 2, Lab6
 * @author biancacaissottidichiusano
 *
 */
public class Find
{
	/**
	 * Main method
	 * @param args the first element of the String array args[] (from the command line) is assumed to 
	 * be the word that has to be found by the program in the files inputed after that first
	 * element
	 */
	public static void main(String[] args)
	{
		
		try{	
				/**
				 * Looping through any/all existing files passed in the command line. 
				 * These are stored in the String array "args". 
				 */
				for(int i = 1; i < args.length; i++)
				{		
						//The first element will be the word to find in the files passed
						String find = args[0];
						/**
						 * Creating a new File Object of the current file being considered
						 * by the for loop.
						 */
						File fileName = new File(args[i]);
						Scanner scan1 = new Scanner(fileName);
						//Looping until there are no more lines in the file
						while(scan1.hasNextLine()){
								String line = scan1.nextLine();
								//Check if the line contains the word, then print the line and corresponding fileName
								if(line.contains(find)) {
									System.out.println(fileName + ": " + line);
								}

						}
						scan1.close();
				}
			//Catching any relevant exceptions
			}catch(IOException e){
					System.out.println("Something went wrong");
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Index out of bounds");
			}
		}
	
}
