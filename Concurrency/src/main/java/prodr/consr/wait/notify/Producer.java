/*
 * @author Janardhan Sharma 
 */
package prodr.consr.wait.notify;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class Producer.
 */
public class Producer implements Runnable {

	/** The value. */
	private AtomicInteger value;

	/** The flag. */
	private AtomicBoolean flag;

	/**
	 * Instantiates a new producer.
	 *
	 * @param value the value
	 * @param flag the flag
	 */
	public Producer(AtomicInteger value, AtomicBoolean flag) {
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

				while (!flag.get()) {
					try {
						System.out.println("Waiting for the consumer to consume and realease. ");
						value.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				value.incrementAndGet();
				System.out.println("Added value : " + value.get());
				flag.set(false);
				value.notify();
			}
			System.out.println("Exiting Producer thread. ");
		}

	}
}
