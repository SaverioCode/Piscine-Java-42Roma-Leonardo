
public class Program {
	public static void main(String[] args) {
		TransactionsService service = TransactionsService.getInstance();

		User user1 = new User("Sav");
		user1.setBalance(400);
		User user2 = new User("Bru");
		user2.setBalance(400);
		User user3 = new User("Simo");
		user3.setBalance(400);
		User user4 = new User("Andrea");
		user4.setBalance(400);

		service.addUser(user1);
		service.addUser(user2);
		service.addUser(user3);
		service.addUser(user4);

		System.out.println();

		System.out.printf("user: %s\nbalance: %d\n", user1.getName(), service.getUserBalance(user1));

		System.out.println();

		service.transferMoney(user1.getID(), user2.getID(), 200);
		service.transferMoney(user2.getID(), user1.getID(), 100);
		service.transferMoney(user1.getID(), user3.getID(), 100);
		service.transferMoney(user2.getID(), user3.getID(), 100);
		service.transferMoney(user3.getID(), user2.getID(), 50);
		service.transferMoney(user3.getID(), user1.getID(), 50);

		System.out.println("Attempting a transaction with unsufficient balance.");
		service.transferMoney(user1.getID(), user2.getID(), 1000);

		System.out.println();

		Transaction[] trsArr = service.getTransactionsArr(user1);
		for (int i = 0; i < trsArr.length; i++) {
			System.out.printf("Transaction[%d]:	", i);
			System.out.printf("%s --> %s, %d, %s, %s\n", trsArr[i].getSender().getName(), trsArr[i].getRecipient().getName(), trsArr[i].getAmount(), trsArr[i].getCategory(), trsArr[i].getID());
		}

		System.out.println();

		service.removeTransaction(trsArr[2].getID(), user1.getID());

		System.out.println("Eliminating one transaction trough TransactionService:");
		trsArr = service.getTransactionsArr(user1);
		for (int i = 0; i < trsArr.length; i++) {
			System.out.printf("Transaction[%d]:	", i);
			System.out.printf("%s --> %s, %d, %s, %s\n", trsArr[i].getSender().getName(), trsArr[i].getRecipient().getName(), trsArr[i].getAmount(), trsArr[i].getCategory(), trsArr[i].getID());
		}

		trsArr = service.getTransactionsArr(user2);
		service.removeTransaction(trsArr[0].getID(), user2.getID());
		trsArr = service.getTransactionsArr(user3);
		service.removeTransaction(trsArr[1].getID(), user3.getID());

		System.out.println();

		System.out.println("Getting unpaired transactions");
		trsArr = service.checkTransactions();
		for (int i = 0; i < trsArr.length; i++) {
			System.out.printf("Transaction[%d]:	", i);
			System.out.printf("%s --> %s, %d, %s, %s\n", trsArr[i].getSender().getName(), trsArr[i].getRecipient().getName(), trsArr[i].getAmount(), trsArr[i].getCategory(), trsArr[i].getID());
		}

		System.out.println();
	}
}
