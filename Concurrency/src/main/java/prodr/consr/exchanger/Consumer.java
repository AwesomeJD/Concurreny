/*
 * @author Janardhan Sharma 
 */
package prodr.consr.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * The Class Consumer.
 */
public class Consumer implements Runnable {

	private Exchanger<String> exchanger;

	public Consumer(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String exchanged = null;
		for (int i = 0; i < 4; i++) {
			System.out.println("Waiting for the producer to add in queue. ");
			try {
				exchanged = exchanger.exchange(new Integer(i).toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumed from queue :  " + exchanged);

		}
		System.out.println("Exiting Consumer thread. ");

	}
}
