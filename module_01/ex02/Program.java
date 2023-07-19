
class	Program {
	public void	main(String[] args) {
		UserList userList;
		User	user;
		User	userTest;
		String	name;
		int		i;

		// userList = new UserList();
		userList = UsersArrayList.getInstance();
		name = "user";
		i = 0;
		System.out.printf("Number of user: %d\n", UserList.getNumberOfUsers());
		while (i < 10) {
			userTest = new User(name + (i + 1));
			UserList.addUser(userTest);
			i++;
		}
		System.out.printf("Number of user: %d\n", UserList.getNumberOfUsers());
		user = UserList.getUserByIndex(2);
		System.out.printf("User at index number 2 is: %s\n", user.getName());
		user = UserList.getUserByID(5);
		System.out.printf("User with id = 5 is: %s\n", user.getName());
	}
}
