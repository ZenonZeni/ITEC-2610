/*
 * @author: christopher Nguyen
 * @ID: 216213332
 * Assignment 2 NumberCount is the main class used to get files from command line arguments then totalCount the numbers from the files given
 * then output them. If there is no file output with totalCount 0 otherwise output the totalCount.
 */
import java.io.*;
public class NumberCount {

	public static void main(String[] args) {
		
		//Variables
		Boolean working = false;
		totalCount c = new totalCount(args.length);
		BufferedReader[] fileStorage = new BufferedReader[args.length];
		Thread[] t = new Thread[args.length];
		
		//Read files and buffer to fileStorage
		for(int i=0; i<args.length; i++) {
			try {
				FileReader fr = new FileReader (args[i]);
				BufferedReader inFile = new BufferedReader (fr);
				fileStorage[i] = inFile;
			}
			catch (FileNotFoundException exception)      {
		         System.out.println ("The file " + args[i] + " does not exist or does not contain any elements and numbers");
		      }
		}
		
		//Create threads depending on how many files are given
		for(int i= 0; i<fileStorage.length; i++) {
			if(fileStorage[i] == null) {
				t[i] = new Thread(new CountRunnable(c, args[i]));
			}
			else {
				t[i] = new Thread(new CountRunnable(fileStorage[i],c, args[i]));
			}
		}
		
		//Run Threads
		for(int i=0;i<t.length;i++) {
			working = true;
			t[i].start();
		}
		
		if(working) {
		System.out.println(c.checkIfFinished());
		}
		
		//if statement to check if reader and threads are working properly. If working is false then command line arguments must not be given.
		if(working == false) {
			System.out.println("No arugments entered to use the program NumbertotalCount correctly you must input:javac NumberCount.java then input: java NumberCount hello.txt p.txt wow.txt for example"
					+" (each .txt file must be seperated by a space when using command prompt. Also note that txt files must have interger or float point values seperated by one space"
					+" and all .txt files must be in the same folder");
		}
	}

}
