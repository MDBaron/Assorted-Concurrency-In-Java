package garden;

public class Garden {
	
	private int population;
	
	public Garden() {
		this.population = 0;
	}
	
	public synchronized void enter() {
		population = population + 1;
	}
	
	public void print() {
		System.out.println("Garden Population: " + population);
	}
}