
class	Program {
	public static void main(String[] args) {
		User	user1;
		User	user2;
		User	user3;

		user1 = new User("Alberto");
		user2 = new User("Giovanni");
		user3 = new User("Marco");
		System.out.printf("%s --> %d\n", user1.getName(), user1.getID());
		System.out.printf("%s --> %d\n", user2.getName(), user2.getID());
		System.out.printf("%s --> %d\n", user3.getName(), user3.getID());
	}
}
