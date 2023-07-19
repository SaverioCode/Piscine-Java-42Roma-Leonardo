
class Program {
	private static void	doTransaction(User sender, User recipient, int amount, String category) {
		Transaction transaction;
		String		type;

		type = null;
		if (category.equals("credits")) {
			if (amount < 0) {
				System.err.print("Error: transfer amount has to be grater then 0.");
				System.exit(-1);
			}
			sender.setBalance(recipient.getBalance() + amount);
			type = "INCOME";
		}
		if (category.equals("debits")) {
			if (amount > 0) {
				System.err.print("Error: transfer amount has to be less then 0.");
				System.exit(-1);
			}
			if (sender.getBalance() <= 0 || sender.getBalance() < amount) {
				System.err.print("Error: balance is insufficient.");
				System.exit(-1);
				sender.setBalance(sender.getBalance() - amount);
			}
			type = "OUTCOME";
		}
		transaction = new Transaction(sender, recipient, amount, category);
		System.out.printf("%s --> %s, %d, %s, %s\n", sender.getName(), recipient.getName(), amount, type, transaction.getID());
	}

	public static void main(String[] args) {
		User		sender;
		User		reciver;

		sender = new User("John");
		sender.setBalance(500);
		reciver = new User("Mike");
		reciver.setBalance(500);
		doTransaction(sender, reciver, -500, "debits");
		doTransaction(reciver, sender, 500, "credits");
	}
}
