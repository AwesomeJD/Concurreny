/*
 * @author Janardhan Sharma 
 */
package prodr.consr.exchanger;

import java.util.concurrent.Exchanger;

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

		Exchanger<String> exchanger = new Exchanger<>();

		Thread consumerThread = new Thread(new Consumer(exchanger));
		Thread producerThread = new Thread(new Producer(exchanger));

		consumerThread.start();
		producerThread.start();
	}
}
