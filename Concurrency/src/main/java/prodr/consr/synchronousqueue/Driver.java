/*
 * @author Janardhan Sharma 
 */
package prodr.consr.synchronousqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicBoolean;

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

		BlockingQueue<Integer> queue = new SynchronousQueue<>();

		AtomicBoolean flag = new AtomicBoolean(true);

		Thread consumerThread = new Thread(new Consumer(queue, flag));
		Thread producerThread = new Thread(new Producer(queue, flag));

		consumerThread.start();
		producerThread.start();
	}
}
