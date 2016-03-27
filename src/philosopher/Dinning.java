package philosopher;

public class Dinning {
	
	public static void main(String[] args){
		if (args.length < 2) {
			System.out.println("Usage: java -jar dining.jar [num_of_philosopher] [num__of_meals]");
			System.exit(1);
		}
		
		long t1 = System.currentTimeMillis();
		int size = Integer.parseInt(args[0]);
		int meals = Integer.parseInt(args[1]);
		
		Fork forks = new Fork(size);
		for (int i=0; i<size; ++i){
			Thread t = (new Thread(new Philosopher(meals, i, forks)));
			t.start();
			try {
				t.join();
			} catch (InterruptedException ie) {}
		}
		
		System.out.println("Elapsed Time: " + (System.currentTimeMillis() - t1));
	}
}
