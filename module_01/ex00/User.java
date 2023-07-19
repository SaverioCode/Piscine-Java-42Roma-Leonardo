
public class User {
	private static int	num = 0;
	private int			identifier;
	private String		name;
	private int			balance;

	public User(String name) {
		this.name = name;
		this.identifier = this.num + 1;
		this.num = this.identifier;
		this.balance = 0;
	}

	public int getID() {
		return (this.identifier);
	}

	public String getName() {
		return (this.name);
	}

	public int getBalance() {
		return (this.balance);
	}

	public void setID(int identifier) {
		this.identifier = identifier;
	}

	public void	setName(String name) {
		this.name = name;
	}

	public void	setBalance(int balance) {
		this.balance = balance;
	}
}
