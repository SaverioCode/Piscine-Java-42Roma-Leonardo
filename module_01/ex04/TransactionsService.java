
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
		Transaction	trs;
		UUID		trsIdentifier;
		User		sender = userList.getUserByID(senderID);
		User		recipient = userList.getUserByID(recipientID);

		try {
			trs = new Transaction(sender, recipient, amount, "debits");
		} catch (IllegalTransactionException e) {
			System.err.print(e);
			return ;
		}
		sender.getTransactionsList().addTransaction(trs);
		trsIdentifier = trs.getID();
		trs = new Transaction(recipient, sender, amount, "credits");
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
					Transaction trsCpy = new Transaction(senderTrsArr[j]);
					unpairedArr.addTransaction(trsCpy);
				}
			}
		}
		return (unpairedArr.toArray());
	}
}
