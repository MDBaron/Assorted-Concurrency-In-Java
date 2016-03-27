package garden;

public class OrnamentalGarden {
	public static void main(String args[]) {
		Garden garden = new Garden();
		
		Thread east = new Thread(new Turnstile(garden));
		Thread west = new Thread(new Turnstile(garden));
		
		east.start();
		west.start();
		
		try {
			east.join();
			west.join();
		} catch (InterruptedException ie) {}
		
		garden.print();
	}
}