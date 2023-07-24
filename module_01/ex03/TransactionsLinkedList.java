
import java.util.UUID;

public class	TransactionsLinkedList implements TransactionsList {
	private Transaction 			head;
	private Transaction				node;
	private int						listLen;

	public TransactionsLinkedList() {
		if (this.head == null) {
			this.head = null;
			this.node = null;
			this.listLen = 0;
		}
	}

	@Override
	public void	addTransaction(Transaction transaction) {
		if (this.head == null) {
			this.head = transaction;
			this.node = transaction;
			listLen = 1;
			return ;
		}
		this.node.setNext(transaction);
		transaction.setPrev(this.node);
		this.node = transaction;
		this.listLen++;
	}

	@Override
	public void	removeTransaction(UUID id) {
		Transaction	tmp = this.head;
		while (tmp != null) {
			if (tmp.getID() == id) {
				if (tmp == this.head) {
					this.head = this.head.getNext();
					this.head.setPrev(null);
				}
				else {
					tmp.getPrev().setNext(tmp.getNext());
					if (tmp.getNext() != null) {
						tmp.getNext().setPrev(tmp.getPrev());
					}
				}
				this.listLen--;
				return ;
			}
			tmp = tmp.getNext();
		}
		throw	new TransactionNotFoundException("Transaction not found.\n");
	}

	@Override
	public Transaction[]	toArray() {
		Transaction[]	arr = new Transaction[this.listLen];
		Transaction		tmp;
		int				i;

		tmp = head;
		i = 0;
		while (tmp != null) {
			arr[i] = tmp;
			tmp = tmp.getNext();
			i++;
		}
		return (arr);
	}
}
