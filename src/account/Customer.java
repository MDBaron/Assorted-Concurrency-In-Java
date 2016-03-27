package account;
import java.util.Random;

public class Customer implements Runnable {

	private Account account;
	private String identity;
	
	public Customer(Account account, String identity){
		this.account = account;
		this.identity = identity;
	}
	
	private void deposit(int amount){
		this.account.deposit(amount, identity);
	}
	
	private void withdraw(int amount){
		this.account.withdraw(amount, identity);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			Random random = new Random();
			if (random.nextBoolean()){
				deposit(random.nextInt(300));
			}
			else{
				withdraw(random.nextInt(300));
			}
			try{
				Thread.sleep(random.nextInt(500));
			}
			catch(InterruptedException e){}
		}
	}

}