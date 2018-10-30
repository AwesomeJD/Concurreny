/*
 * @author Janardhan Sharma 
 */
package prodr.consr.semaphore;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {

	private Semaphore semaphore;
	private AtomicBoolean flag;
	private AtomicInteger value;

	public Consumer(Semaphore semaphore, AtomicBoolean flag, AtomicInteger value) {
		super();
		this.semaphore = semaphore;
		this.flag = flag;
		this.value = value;
	}

	@Override
	public void run() {
		while (value.get() != 9) {
			while (this.flag.get()) {
				System.out.println("Waiting for the producer to add. ");
				try {
					this.semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Consumed from queue :  " + value.get());

				this.semaphore.release();
			}
		}
		System.out.println("Exiting Consumer thread. ");
	}
}
