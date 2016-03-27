package readerwriter;

public class ReaderWriter {
	
	public static void main(String args[]) {
		Database database = new Database();
		
		for (int i = 0; i < 5; i++) {
			(new Thread(new Reader(database))).start();
		}
		
		for (int i = 0; i < 2; i++) {
			(new Thread(new Writer(database))).start();
		}
	}

}