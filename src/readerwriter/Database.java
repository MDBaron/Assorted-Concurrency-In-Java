package readerwriter;

public class Database {
	private int numReader;
	private boolean writing;
	private int readerWait;
	private int writerWait;
	private boolean readerTurn;
	
	public Database() {
		numReader = 0;
		writing = false;
		readerWait = writerWait = 0;
		readerTurn = false;
	}
	
	public synchronized void acquireRead() throws InterruptedException {
		readerWait++;
		while (writing || (writerWait > 0 && !readerTurn)) wait();
		readerWait--;
		numReader++;
	}
	
	public synchronized void relinquishRead() throws InterruptedException {
		numReader--;
		readerTurn = false;
		if (numReader == 0) notifyAll();
	}
	
	public synchronized void acquireWrite() throws InterruptedException {
		writerWait++;
		while (writing || numReader > 0 || (readerWait > 0 && readerTurn)) wait();
		writerWait--;
		writing = true;
	}
	
	public synchronized void relinquishWrite() throws InterruptedException {
		writing = false;
		readerTurn = true;
		notifyAll();
	}
}