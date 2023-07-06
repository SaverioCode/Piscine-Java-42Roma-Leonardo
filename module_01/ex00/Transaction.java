
import	java.util.UUID;

public class Transaction {
	private UUID	identifier;
	private User	recipient;
	private User	sender;
	private String	transferCategory;
	private int		transerAmount;

	public Transaction Transaction(String sender, String recipient, int amount) {
		this.identifier = UUID.randomUUID();
		this.recipient = recipient;
		this.sender = sender;
		this.transerAmount = amount;
		this.transferCategory = NULL;
	}

	public UUID	getID() {
		return (this.identifier);
	}

	public User	getRecipinet() {
		return (this.recipient);
	}

	public User	gerSender() {
		return (this.sender);
	}

	public int	getAmount() {
		return (this.transerAmount);
	}

	public String getCategory() {
		return (this.transferCategory);
	}
}
