/*
 * @author: christopher Nguyen
 * @ID: 216213332
 * Assignment 2 CountRunnable is the runnable class for the threads to use to read files and store the totalCount to totalCount
 */
import java.io.*;
public class CountRunnable implements Runnable {
	
	//Instance Variables
	BufferedReader file;
	totalCount ct;
	String fileName;
  	public int totalCounter = 0;
	
  	/*
  	 * Constructor
  	 * @parama ct1 for totalCount
  	 * @parama fN for fileName
  	 */
	public CountRunnable(totalCount ct1,String fN) {
		ct = ct1;
		fileName = fN;
	}
	
	/*
	 * Secondary Constructor
	 * @parama e1 is the file
	 * @parama ct1 is the totalCount
	 * @parama fN is fileName
	 */
	public CountRunnable(BufferedReader e1, totalCount ct1, String fN) {
		file = e1;
		ct = ct1;
		fileName = fN;
	}
	
	@Override
	public void run() {
		//Check if file is not null then totalCount numbers in the file given to the thread
		if (!(file == null)) 
		{
			try {
				String line= file.readLine();
		         while (line != null) {
		        	 String[] x = line.split("\\s+");
		 			 Double d=0.0;
		        	 for(int i =0; i<x.length;i++) {
		        		 try {
		        			 d= Double.parseDouble(x[i]);
		        			 totalCounter = totalCounter + 1;
		        		 }
		        		 catch(NumberFormatException ex){
		        			 continue;
		        		 }
		        	 }
		        	 line = file.readLine();
		          }
		         ct.addTotalCount(totalCounter);
		         ct.finished();
		         System.out.println(fileName +": " + totalCounter);
			}
			catch (IOException exception)      {
		        System.out.println ("IOException was detected");
		    }
			
			//Checks if threads are finished and signals remaining waiting threads
			ct.checkIfThreadsFinished();
			
		}
		//If file is null then output the file with the Count 0
		else 
		{
			System.out.println(fileName +": "+ 0);
		}
	}
	

}
