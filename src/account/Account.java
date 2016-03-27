package account;

public class Account {
	
	private int balance;
	
	public Account(){
		balance = 0;
	}

	public synchronized void deposit(int amount, String identity){
		int temp = balance;
		balance = balance + amount;
		System.out.println(identity + ": " + temp + "+" + amount + "=" + balance);
		notifyAll();
	}
	
	public synchronized void withdraw(int amount, String identity){
		while (balance < amount){
			try{
				wait();
			}
			catch (InterruptedException e){}
		}
		int temp = balance;
		balance = balance - amount;
		System.out.println(identity + ": " + temp + "-" + amount + "=" + balance);
	}
}
