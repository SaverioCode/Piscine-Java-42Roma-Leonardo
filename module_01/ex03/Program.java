
public class Program {
	public static void main(String[] args) {
		
        User andrea = new User("Andrea");
		andrea.setBalance(200);
        User clefari = new User("Clefari");
        User dario = new User("Dario");
		dario.setBalance(200);
        User marco = new User("Marco");
        User luis = new User("Luis");
		luis.setBalance(200);
        User africa = new User("Africa");
        UsersArrayList userList = UsersArrayList.getInstance();
        TransactionsList transactionList = new TransactionsLinkedList();


        Transaction debts = new Transaction(andrea, luis, 100, "DEBTS");
        System.out.println("amount    : " + debts.getAmount());
        System.out.println("category  : " + debts.getCategory());
        System.out.println("identifier: " + debts.getID());
        System.out.println("sender    : " + debts.getSender());
        System.out.println("recipient : " + debts.getRecipient());
        Transaction credits = new Transaction(luis, africa, 100, "CREDITS");

        System.out.println("identifier: " + andrea.getID());
        System.out.println("name      : " + andrea.getName());
        System.out.println("balance   : " + andrea.getBalance());
        System.out.println();
        System.out.println("identifier: " + clefari.getID());
        System.out.println("name      : " + clefari.getName());
        System.out.println("balance   : " + clefari.getBalance());
        System.out.println();
        System.out.println("identifier: " + dario.getID());
        System.out.println("name      : " + dario.getName());
        System.out.println("balance   : " + dario.getBalance());
        System.out.println();
        System.out.println("identifier: " + marco.getID());
        System.out.println("name      : " + marco.getName());
        System.out.println("balance   : " + marco.getBalance());
        System.out.println();
        System.out.println("identifier: " + luis.getID());
        System.out.println("name      : " + luis.getName());
        System.out.println("balance   : " + luis.getBalance());
        System.out.println();
        System.out.println("identifier: " + africa.getID());
        System.out.println("name      : " + africa.getName());
        System.out.println("balance   : " + africa.getBalance());

        userList.addUser(africa);
        userList.addUser(andrea);
        userList.addUser(luis);
        userList.addUser(marco);
        userList.addUser(dario);
        userList.addUser(clefari);

        Transaction debts0 = new Transaction(dario, luis, 100, "DEBTS");
        Transaction credits0 = new Transaction(andrea, africa, 100, "CREDITS");
        Transaction debts1 = new Transaction(africa, andrea, 100, "DEBTS");
        Transaction credits1 = new Transaction(luis, clefari, 100, "CREDITS");
        Transaction debts2 = new Transaction(dario, marco, 100, "DEBTS");

        transactionList.addTransaction(debts);
        transactionList.addTransaction(credits);
        transactionList.addTransaction(debts0);
        transactionList.addTransaction(credits0);
        transactionList.addTransaction(debts1);
        transactionList.addTransaction(credits1);
        transactionList.addTransaction(debts2);
        // transactionList.lenList();

        // transactionList.printList();

        try {
            transactionList.removeTransaction(debts.getID());
            transactionList.removeTransaction(debts2.getID());
            transactionList.removeTransaction(credits0.getID());
        } catch (TransactionNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // System.out.println("\n");
        // transactionList.printList();
        // transactionList.lenList();
        System.out.println("\n");

        // try {
        //     User found = userList.getUserByID(100);
        //     if (found != null) {
        //         System.out.println("User by id: " + found.getName());
        //     }
        // } catch (UserNotFoundException e) {
        //     System.out.println(e.getMessage());
        // }

        // User found = userList.getUserByIndex(85);
        User found = userList.getUserByIndex(5);

        if (found != null) {
            System.out.println("User by index: " + found.getName());
        } else {
            System.out.println("User by index : user not found");
        }
        System.out.println("Number of users: " + userList.getNumberOfUsers());

        System.out.println("toArray Method:");
        Transaction[] toAarray = transactionList.toArray();
        for (Transaction t: toAarray) {
            System.out.println(t);
        }
	}
}