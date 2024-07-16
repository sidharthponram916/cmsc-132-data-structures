package Threads;

class Z { 
	
}

class A implements Runnable { 
	public void run() { 
		for (int i = 0; i < 10; i++) { 
			System.out.println("Hi"); 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class B implements Runnable { 
	public void run() { 
		for (int i = 0; i < 10; i++) { 
			System.out.println("Hello"); 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadExample {
	
	
	public static void main(String[] args) { 
		Runnable obj1 = new A(); 
		Runnable obj2 = new B(); 
		
		// Threads can help run pieces of code at the same time. (Asynchronous) 
		
		Thread t1 = new Thread(obj1); 
		Thread t2 = new Thread(obj2); 
		
		t1.start(); 
		t2.start(); 
	}
}
