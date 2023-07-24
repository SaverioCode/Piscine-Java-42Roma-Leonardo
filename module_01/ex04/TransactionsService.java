
import java.util.UUID;

public class TransactionsService {
	private static TransactionsService	instance;
	private static UserList 			userList;

	public static TransactionsService getInstance() {
		if (instance == null) {
			instance = new TransactionsService();
			userList = UsersArrayList.getInstance();
		}
		return (instance);
	}

	public void	addUser(User user) {
		userList.addUser(user);
	}

	public int	getUserBalance(User user) {
		return (userList.getUserByID(user.getID()).getBalance());
	}

	public void transferMoney(int senderID, int recipientID, int amount) {
		UUID	trsIdentifier;
		User	sender = userList.getUserByID(senderID);
		User	recipient = userList.getUserByID(recipientID);

		Transaction trs = new Transaction(sender, recipient, amount, "debits");
		try {
			sender.getTransactionsList();
		} catch (TransactionNotFoundException e) {
			sender.setTransactionsList(new TransactionsLinkedList());
		}
		sender.getTransactionsList().addTransaction(trs);
		trsIdentifier = trs.getID();
		trs = new Transaction(recipient, sender, amount, "credits");
		try {
			recipient.getTransactionsList();
		} catch (TransactionNotFoundException e) {
			recipient.setTransactionsList(new TransactionsLinkedList());
		}
		recipient.getTransactionsList().addTransaction(trs);
		trs.setID(trsIdentifier);
	}

	public Transaction[] getTransactionsArr(User user) {
		return (user.getTransactionsList().toArray());
	}

	public void removeTransaction(UUID trsID, int userID) {
		userList.getUserByID(userID).getTransactionsList().removeTransaction(trsID);
	}

	public Transaction[] checkTransactions() {
		TransactionsList	unpairedArr = new TransactionsLinkedList();
		Transaction[]		senderTrsArr;
		TransactionsList	recipientTrsList;
		Transaction			trs;
	
		for (int i = 0; i < userList.getNumberOfUsers(); i++) {
			senderTrsArr = userList.getUserByIndex(i).getTransactionsList().toArray();
			for (int j = 0; j < senderTrsArr.length; j++) {
				recipientTrsList = senderTrsArr[j].getRecipient().getTransactionsList();
				trs = recipientTrsList.getTransactionByID(senderTrsArr[j].getID());
				if (trs == null) {
					// System.out.println("here");
					unpairedArr.addTransaction(senderTrsArr[j]);
				}
			}
		}
		return (unpairedArr.toArray());
	}
}
