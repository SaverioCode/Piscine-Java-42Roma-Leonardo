
import	java.util.UUID;

public interface	TransactionsList {
	public abstract void			addTransaction(Transaction transaction);
	public abstract	void			removeTransaction(UUID	id);
	public abstract Transaction[]	toArray();
}
