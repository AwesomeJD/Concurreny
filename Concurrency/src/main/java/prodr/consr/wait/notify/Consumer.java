/*
 * @author Janardhan Sharma 
 */
package prodr.consr.wait.notify;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {

	/** The value. */
	private AtomicInteger value;
	
	/** The flag. */
	private AtomicBoolean flag;

	/**
	 * Instantiates a new consumer.
	 *
	 * @param value the value
	 * @param flag the flag
	 */
	public Consumer(AtomicInteger value, AtomicBoolean flag) {
		super();
		this.value = value;
		this.flag = flag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (value) {
			while (value.get() < 100) {
				while (flag.get()) {
					try {
						System.out.println("Waiting for the producer to produce and realease. ");
						value.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Consumed value : " + value.get());
				flag.set(true);
				value.notify();
			}
		}
		System.out.println("Exiting Consumer thread. ");
	}
}
