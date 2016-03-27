package readerwriter;

import java.util.Random;

public class Writer implements Runnable {
	private Database database;
	
	public Writer(Database database) {
		this.database = database;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				database.acquireWrite();
				Thread.sleep((new Random()).nextInt(150));
				System.out.println("write");
				database.relinquishWrite();
			} catch (InterruptedException ie) {}
		}
	}
}