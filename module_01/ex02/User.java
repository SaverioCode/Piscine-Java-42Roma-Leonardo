
public class	User {
	private int			identifier;
	private String		name;
	private int			balance;

	public User(String name) {
		this.identifier = UserIdsGenerator.getInstance().generateId();
		this.name = name;
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

	public void	setName(String name) {
		this.name = name;
	}

	public void	setBalance(int balance) {
		this.balance = balance;
	}
}
