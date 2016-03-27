package philosopher;

public class Philosopher implements Runnable {

	int meal;
	int id;
	Fork fork;
	
	Philosopher(int meal, int id, Fork fork){
		this.meal = meal;
		this.id = id;
		this.fork = fork;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(meal != 0) {
			eat();
			think();
			meal -= 1;
		}
	}
	
	public void eat(){
		if (id % 2 == 0) {
			fork.getLeftFork(id);
			fork.getRightFork(id);
		} else {
			fork.getRightFork(id);
			fork.getLeftFork(id);
		}
	}

	public void think(){
		fork.putLeftFork(id);
		fork.putRightFork(id);
	}
}
