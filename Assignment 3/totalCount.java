/*
 * @author: christopher Nguyen
 * @ID: 216213332
 * Assignment 2 totalCount holds the totalCount value for the files and locks/unlocks when threads try to access addTotalCount
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.*;
import java.util.concurrent.locks.Condition;

public class totalCount {
	
	//Instance Variables
	private int totalCount =0;
	private int threadsToFinish = 0;
	private boolean finished = false;
	private Lock countLock;
	private Condition Complete;
	
	//Constructor
	//@parama int threads to indicate how many threads will be run
	public totalCount(int threads) {
		countLock = new ReentrantLock();
		threadsToFinish = threads;
		Complete = countLock.newCondition();
	}
	
	//getTotalCount
	public int getTotalCount() {
		countLock.lock();
		int temp = totalCount;
		countLock.unlock();
		return temp;
	}
	
	/*addTotalCount
	 * @parama int c for count to add to totalCount
	 */
	public void addTotalCount(int c) {
		try{
			countLock.lock();
			totalCount = totalCount + c;
		}
		finally {
			countLock.unlock();
		}
	}
	
	/*
	 * Subracts one from threadsTofinish to indicate that a thread has finished calculating numbers from the file
	 */
	public void finished() {
		countLock.lock();
		threadsToFinish = threadsToFinish -1;
		countLock.unlock();
	}
	
	/*
	 * ChecksThreads used to check if threads are finished and signals anything remaining
	 */
	public void checkIfThreadsFinished() {
		countLock.lock();
		try {
				if(threadsToFinish ==0 && !finished) {
					finished = true;
					Complete.signalAll();
				}
		}
		finally {
			countLock.unlock();
		}
	}
	
	/*
	 * Checks if finished
	 * @returns String this.toString to output the combined count.
	 */
	public String checkIfFinished() {
		countLock.lock();
		try {
			while(!(threadsToFinish ==0)) {
				try {
				Complete.await();
				}
				catch(InterruptedException x){
					System.out.println("error");
				}
			}
			return this.toString();
		}
		finally {
			countLock.unlock();
		}
	}
	
	//returns a string for combined count
	public String toString() {
		return "combined count: " + totalCount;
	}
	
}
