/*
 * @author Janardhan Sharma 
 */
package prodr.consr.wait.notify;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class DriverClass.
 */
public class DriverClass {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		AtomicInteger value = new AtomicInteger(0);
		AtomicBoolean flag = new AtomicBoolean(true);

		Thread consumerThread = new Thread(new Consumer(value, flag));
		Thread producerThread = new Thread(new Producer(value, flag));

		consumerThread.start();
		producerThread.start();
	}

}
