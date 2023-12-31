
import	java.util.UUID;

public class Transaction {
	private UUID				identifier;
	private User				sender;
	private User				recipient;
	private int					transferAmount;
	private String				transferCategory;
	private Transaction			prev;
	private Transaction			next;

	public Transaction(User sender, User recipient, int amount, String category) {
		if (category.equals("debits") && sender.getBalance() < amount) {
			throw	new IllegalTransactionException("Unsifficient balance.\n");
		}
		this.identifier = UUID.randomUUID();
		this.sender = sender;
		this.recipient = recipient;
		this.transferAmount = amount;
		this.transferCategory = category;
	}

	public Transaction(Transaction transaction) {
		this.identifier = transaction.getID();
		this.sender = transaction.getSender();
		this.recipient = transaction.getRecipient();
		this.transferAmount = transaction.getAmount();
		this.transferCategory = transaction.getCategory();
	}

	public UUID	getID() {
		return (this.identifier);
	}

	public User	getRecipient() {
		return (this.recipient);
	}

	public User	getSender() {
		return (this.sender);
	}

	public int	getAmount() {
		return (this.transferAmount);
	}

	public String	getCategory() {
		return (this.transferCategory);
	}

	public Transaction getNext() {
		return (this.next);
	}

	public Transaction getPrev() {
		return (this.prev);
	}

	public void	setID(UUID ID) {
		this.identifier = ID;
	}

	public void	setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public void	setSender(User sender) {
		this.sender = sender;
	}

	public void	setTransferAmount(int amount) {
		this.transferAmount = amount;
	}

	public void	setTransferCategory(String category) {
		if (category.equals("debits") || category.equals("credits")) {
			this.transferCategory = category;
		}
		else {
			this.transferCategory = null;
		}
	}

	public void	setNext(Transaction transaction) {
		this.next = transaction;
	}

	public void	setPrev(Transaction transaction) {
		this.prev = transaction;
	}
}
