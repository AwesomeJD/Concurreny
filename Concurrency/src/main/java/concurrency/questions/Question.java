/*
 * @author Janardhan Sharma and Sremayee Debbarmna
 */


package concurrency.questions;

class Paratrooper implements Runnable {
	public void run() {
		System.out.print(Thread.currentThread().getName() + " ");
	}
}

class YO {
	static {
		System.out.println("In static block YO.");
	}
	{
		System.out.println("In initialization block YO.");
	}
}

/**
 * The Class Question.
 */
public class Question extends YO {
	
	/** The p. */
	static Paratrooper p;
	static {
		System.out.println("In static block Jump.");
		p = new Paratrooper();
	}
	{
		System.out.println("In initialization block Jump.");

		Thread t1 = new Thread(p, "bob");
		t1.start();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new Question();
		new Thread(new Runnable() {
			public void run() {
				;
			}
		}, "carol").start();
		new Thread(new Paratrooper(), "alice").start();
	}

	/**
	 * Instantiates a new question.
	 */
	Question() {
		System.out.println("In constructor of Jump.");

		Thread t2 = new Thread(p, "ted");
		t2.start();
	}
}