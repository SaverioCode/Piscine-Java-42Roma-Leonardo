
import	java.util.UUID;

public class Transaction {
	private UUID				identifier;
	private User				recipient;
	private User				sender;
	private int					transferAmount;
	private String				transferCategory;
	private Transaction			prev;
	private Transaction			next;

	public Transaction(User sender, User recipient, int amount, String category) {
		this.identifier = UUID.randomUUID();
		this.recipient = recipient;
		this.sender = sender;
		this.transferAmount = amount;
		this.transferCategory = category;
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
