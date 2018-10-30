/*
 * @author Janardhan Sharma 
 */
package prodr.consr.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class DriverClass.
 */
public class Driver {

	/**
	 * T;he main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(1);

		AtomicBoolean flag = new AtomicBoolean(true);
		AtomicInteger value = new AtomicInteger(0);

		Thread consumerThread = new Thread(new Consumer(semaphore, flag, value));
		Thread producerThread = new Thread(new Producer(semaphore, flag, value));

		consumerThread.start();
		producerThread.start();

	}
}
