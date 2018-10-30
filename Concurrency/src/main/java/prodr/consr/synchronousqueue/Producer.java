/*
 * @author Janardhan Sharma 
 */
package prodr.consr.synchronousqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The Class Consumer.
 */
public class Producer implements Runnable {

	private BlockingQueue<Integer> queue;
	private AtomicBoolean flag;

	public Producer(BlockingQueue<Integer> queue, AtomicBoolean flag) {
		super();
		this.queue = queue;
		this.flag = flag;
	}

	@Override
	public void run() {

		while (this.flag.get()) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Waiting for the consumer to get from queue. ");
				try {
					queue.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Add to the queue. " + i);
			}
			this.flag.set(Boolean.FALSE);
		}
		System.out.println("Exiting producer thread. ");
	}
}
