/*
 * @author Janardhan Sharma 
 */
package prodr.consr.synchronousqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {

	private BlockingQueue<Integer> queue;
	private AtomicBoolean flag;

	public Consumer(BlockingQueue<Integer> queue, AtomicBoolean flag) {
		super();
		this.queue = queue;
		this.flag = flag;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (this.flag.get()) {
			System.out.println("Waiting for the producer to add in queue. ");
			Integer value = null;
			try {
				value = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumed from queue :  " + value);

		}
		System.out.println("Exiting Consumer thread. ");

	}
}
