
import java.util.UUID;

public class Program {
	public static void main(String[] args) {
		User user1 = new User("Sav");
		User user2 = new User("Bru");
		User user3 = new User("Simo");
		User user4 = new User("Andrea");

		user1.setBalance(300);
		user3.setBalance(500);
		user4.setBalance(150);

		TransactionsList user1TrsList= new TransactionsLinkedList();
		user1.setTransactionsList(user1TrsList);
		TransactionsList user2TrsList= new TransactionsLinkedList();
		user2.setTransactionsList(user2TrsList);
		TransactionsList user3TrsList= new TransactionsLinkedList();
		user3.setTransactionsList(user3TrsList);
		TransactionsList user4TrsList= new TransactionsLinkedList();
		user4.setTransactionsList(user4TrsList);

		Transaction transaction = new Transaction(user1, user2, 100, "debits");
		user1TrsList.addTransaction(transaction);
		transaction = new Transaction(user2, user1, 100, "credits");
		user2TrsList.addTransaction(transaction);
		transaction = new Transaction(user2, user3, 50, "debits");
		user2TrsList.addTransaction(transaction);
		transaction = new Transaction(user3, user2, 50, "credits");
		user3TrsList.addTransaction(transaction);
		transaction = new Transaction(user3, user1, 200, "debits");
		user3TrsList.addTransaction(transaction);
		transaction = new Transaction(user1, user3, 200, "credits");
		user1TrsList.addTransaction(transaction);

		System.out.println();

		Transaction trsList[];
		System.out.printf("User: %s\n", user1.getName());
		trsList = user1.getTransactionsList().toArray();
		for (int i = 0; i < trsList.length; i++) {
			System.out.printf("Transaction[%d]:	", i);
			System.out.printf("%s --> %s, %d, %s, %s\n", trsList[i].getSender().getName(), trsList[i].getRecipient().getName(), trsList[i].getAmount(), trsList[i].getCategory(), trsList[i].getID());
		}

		System.out.println();

		System.out.println("priting transaction moving with next and prev");
		Transaction trs = trsList[0];
		System.out.printf("%s --> %s, %d, %s, %s\n", trs.getSender().getName(), trs.getRecipient().getName(), trs.getAmount(), trs.getCategory(), trs.getID());
		trs = trs.getNext();
		System.out.printf("%s --> %s, %d, %s, %s\n", trs.getSender().getName(), trs.getRecipient().getName(), trs.getAmount(), trs.getCategory(), trs.getID());
		trs = trs.getPrev();
		System.out.printf("%s --> %s, %d, %s, %s\n", trs.getSender().getName(), trs.getRecipient().getName(), trs.getAmount(), trs.getCategory(), trs.getID());

		System.out.println();

		System.out.println("Removing last transaction");
		user1.getTransactionsList().removeTransaction(trsList[1].getID());
		trsList = user1.getTransactionsList().toArray();
		for (int i = 0; i < trsList.length; i++) {
			System.out.printf("Transaction[%d]:	", i);
			System.out.printf("%s --> %s, %d, %s, %s\n", trsList[i].getSender().getName(), trsList[i].getRecipient().getName(), trsList[i].getAmount(), trsList[i].getCategory(), trsList[i].getID());
		}

		System.out.println();

		System.out.println("Removing transaction with wrong ID");
		try {
			user1.getTransactionsList().removeTransaction(UUID.randomUUID());
		} catch (TransactionNotFoundException e) {
			System.out.println(e);
		}

		System.out.println();
	}
}