
import	java.util.UUID;

public class Transaction {
	private UUID	identifier;
	private User	recipient;
	private User	sender;
	private int		transferAmount;
	private String	transferCategory;

	public Transaction(User sender, User recipient, int amount, String category) {
		this.identifier = UUID.randomUUID();
		this.recipient = null;
		this.sender = null;
		this.transferAmount = 0;
		this.transferCategory = null;
	}

	public UUID	getID() {
		return (this.identifier);
	}

	public User	getRecipinet() {
		return (this.recipient);
	}

	public User	getSender() {
		return (this.sender);
	}

	public int	getAmount() {
		return (this.transferAmount);
	}

	public String getCategory() {
		return (this.transferCategory);
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public void	setSender(User sender) {
		this.sender = sender;
	}

	public void	setTransferAmount(int amount) {
		this.transferAmount = amount;
	}

	public void setTransferCategory(String category) {
		if (category.equals("debits") || category.equals("credits")) {
			this.transferCategory = category;
		}
		else {
			this.transferCategory = null;
		}
	}
}
