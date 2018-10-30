/*
 * @author Janardhan Sharma 
 */
package prodr.consr.exchanger;

import java.util.concurrent.Exchanger;

/**
 * The Class Consumer.
 */
public class Producer implements Runnable {

	private Exchanger<String> exchanger;

	public Producer(Exchanger<String> exchanger) {
		super();
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		String exchanged = null;
		for (int i = 0; i < 4; i++) {
			System.out.println("Waiting for the consumer to get from queue. ");
			try {
				exchanged = exchanger.exchange(new Integer(i).toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Add to the queue. " + exchanged);
		}
		System.out.println("Exiting producer thread. ");
	}
}
