
public class	TransactionsLinkedList implements TransactionsList {
	private Transaction head;
	private Transaction	node;
	private int			listLen;

	public TransactionsLinkedList(Transaction transaction) {
		if (this.head == null) {
			this.head = transaction;
			this.node = transaction;
			this.listLen = 1;
		}
	}

	@Override
	public void	addTransaction(Transaction transaction) {
		if (this.node == null) {
			TransactionsLinkedList(transaction);
			return ;
		}
		this.node.setNext(transaction);
		transaction.setPrev(this.node);
		this.node == transaction;
		this.listLen++;
	}

	@Override
	public void	removeTransaction(UUID id) {
		Transaction	tmp = this.head;
		while (tmp) {
			if (tmp.id == id) {
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
		Transaction[]	arr = new Transaction[listLen];
		Transaction		tmp;
		int				i;

		tmp = head;
		i = 0;
		while (tmp) {
			arr[i] = tmp;
			tmp = tmp.getNext();
			i++;
		}
		return (arr);
	}
}
