/*
 * @author Janardhan Sharma 
 */
package prodr.consr.semaphore;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class Consumer.
 */
public class Producer implements Runnable {

	private Semaphore semaphore;
	private AtomicBoolean flag;
	private AtomicInteger value;

	public Producer(Semaphore semaphore, AtomicBoolean flag, AtomicInteger value) {
		super();
		this.semaphore = semaphore;
		this.flag = flag;
		this.value = value;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			while (this.flag.get()) {
				System.out.println("Waiting for the consumer to get from queue. ");
				try {
					this.semaphore.acquire();
					this.value.set(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Add to the queue. " + i);
				this.semaphore.release();
				this.flag.set(Boolean.FALSE);
			}
		}
		System.out.println("Exiting producer thread. ");
	}
}
