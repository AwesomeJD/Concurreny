/*
 * @author Janardhan Sharma 
 */
package concurrency.questions;

/**
 * The Class Question2.
 */
public class Question2 extends Thread {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			Thread t = new Thread(new Question2());
			t.start();
			t.start();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		for (int i = 0; i < 2; i++)
			System.out.print(Thread.currentThread().getName() + " ");
	}
}
