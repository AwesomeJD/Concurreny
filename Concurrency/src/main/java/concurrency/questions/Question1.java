/*
 * @author Janardhan Sharma 
 */
package concurrency.questions;

/**
 * The Class Question1.
 */
public class Question1 extends Thread {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new Question1());
		Thread t2 = new Thread(new Question1());
		t.start();
		t2.start();
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		for (int i = 0; i < 2; i++)
			System.out.print(Thread.currentThread().getName() + " ");
	}
}
