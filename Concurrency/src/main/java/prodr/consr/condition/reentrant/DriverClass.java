/*
 * @author Janardhan Sharma 
 */
package prodr.consr.condition.reentrant;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

		Lock lock = new ReentrantLock();
		Condition produced = lock.newCondition();
		Condition consumed = lock.newCondition();

		AtomicInteger value = new AtomicInteger(0);
		AtomicBoolean flag = new AtomicBoolean(true);

		Thread consumerThread = new Thread(new Consumer(lock, consumed, produced, value, flag));
		Thread producerThread = new Thread(new Producer(lock, consumed, produced, value, flag));

		consumerThread.start();
		producerThread.start();

	}

}
