package Threads;


public class RaceCondition extends Thread {
	static int num = 0; 
	
	// Solved Data Race with Synchronized Keyword 
	
	public synchronized void run() { 
			int temp = num; 
			temp = temp + 1; 
			num = temp; 
		
	}
	
	public static void main(String[] args) throws InterruptedException { 
		Thread t1 = new RaceCondition(); 
		Thread t2 = new RaceCondition(); 
		
		t1.start(); 
		t2.start(); 
		
		// Wait until the statement is FULLY DONE
		t1.join(); 
		t2.join();
		
		System.out.print(num); 
	}
	
	
}
