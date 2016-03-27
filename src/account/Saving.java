package account;

public class Saving {

	public static void main(String[] args){
		Account account = new Account();
		
		(new Thread(new Customer(account, "C1"))).start();
		(new Thread(new Customer(account, "C2"))).start();
		(new Thread(new Customer(account, "C3"))).start();
		(new Thread(new Customer(account, "C4"))).start();
		(new Thread(new Customer(account, "C5"))).start();
		(new Thread(new Customer(account, "C6"))).start();
	}
	
}