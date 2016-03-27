package philosopher;

public class Fork {
	
	// true: available
	// false: occupied
	private Boolean[] forks;
	
	Fork(int size){
		this.forks = new Boolean[size];
		for (int i=0; i<forks.length; ++i){
			forks[i] = true;
		}
	}

	public synchronized void getLeftFork(int num){
		while (!forks[num]){
			try{
				wait();
			} catch (InterruptedException ie){}
		}
		forks[num] = false;
	}
	
	public synchronized void getRightFork(int num){
		while (!forks[(num+1)%forks.length]){
			try {
				wait();
			} catch (InterruptedException ie) {}
		}
		forks[(num+1)%forks.length] = false;
	}
	
	public synchronized void putLeftFork(int num){
		forks[num] = true;
		notifyAll();
	}
	
	public synchronized void putRightFork(int num){
		forks[(num+1)%forks.length] = true;
		notifyAll();
	}
}
