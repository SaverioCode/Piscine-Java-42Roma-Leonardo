
public class	User {
	private int					identifier;
	private String				name;
	private int					balance;
	private TransactionsList	transactions;

	public User(String name) {
		this.identifier = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		this.balance = 0;
		this.transactions = null;
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

	public TransactionsList getList() {
		return (this.transactions);
	}

	public void	setName(String name) {
		this.name = name;
	}

	public void	setBalance(int balance) {
		this.balance = balance;
	}

	public void	setList(TransactionsList head) {
		this.transactions = head;
	}
}
