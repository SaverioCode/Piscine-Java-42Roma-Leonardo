
import	java.util.UUID;

public class User {
	private UUID	identifier;
	private String	name;
	private Int		balance;

	public User User(String name) {
		this.name = name;
		this.identifier = UUID.randomUUID();
		this.balance = 500;
	}

	public UUID getId() {
		return (this.identifier);
	}

	public String getName() {
		return (this.name);
	}

	public int getBalance() {
		return (this.balance);
	}

	public void setId(int identifier) {
		this.identifier = identifier;
	}

	public void	setName(String name) {
		this.name = name;
	}

	public void	setBalance(int balance) {
		this.balance = balance;
	}
}
