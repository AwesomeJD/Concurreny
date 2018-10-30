/*
 * @author Janardhan Sharma 
 */
package prodr.consr.condition.reentrant;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * The Class Producer.
 */
public class Producer implements Runnable {

	/** The lock. */
	private Lock lock;

	/** The consumed. */
	private Condition consumed;

	/** The produced. */
	private Condition produced;

	/** The value. */
	private AtomicInteger value;

	/** The flag. */
	private AtomicBoolean flag;

	/**
	 * Instantiates a new producer.
	 *
	 * @param lock the lock
	 * @param consumed the consumed
	 * @param produced the produced
	 * @param value the value
	 * @param flag the flag
	 */
	public Producer(Lock lock, Condition consumed, Condition produced, AtomicInteger value, AtomicBoolean flag) {
		super();
		this.lock = lock;
		this.consumed = consumed;
		this.produced = produced;
		this.value = value;
		this.flag = flag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		lock.lock();
		try {
			while (value.get() < 100) {

				while (!flag.get()) {
					try {
						System.out.println("Waiting for the consumer to consume and realease. ");
						consumed.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				value.incrementAndGet();
				System.out.println("Added value : " + value.get());
				flag.set(false);
				produced.signal();

			}

			System.out.println("Exiting Producer thread. ");

		} finally {
			lock.unlock();
		}

	}
}
