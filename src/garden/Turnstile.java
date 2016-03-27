package garden;

import java.util.Random;

public class Turnstile implements Runnable {
	
	private Garden garden;
	
	public Turnstile(Garden garden) {
		this.garden = garden;
	}

	public void run() {
		for (int i = 0; i < 200; i++) {
			this.garden.enter();
			try {
				Thread.sleep((new Random()).nextInt(5));
			} catch (InterruptedException ie) {}
		}
	}
}