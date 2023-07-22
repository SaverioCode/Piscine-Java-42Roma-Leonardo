
import	java.util.UUID;

public interface	TransactionsList {
	public abstract void			addTransaction();
	public abstract	void			removeTransaction(UUID	id);
	public abstract Transaction[]	toArray();
}
