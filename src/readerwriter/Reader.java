package readerwriter;

import java.util.Random;

public class Reader implements Runnable {
	private Database database;
	
	public Reader(Database database) {
		this.database = database;
	}

	@Override
	public void run() {
		while (true) {
			try {
				database.acquireRead();
				Thread.sleep((new Random()).nextInt(50));
				System.out.println("read");
				database.relinquishRead();
			} catch (InterruptedException ie){}			
		}
	}
}