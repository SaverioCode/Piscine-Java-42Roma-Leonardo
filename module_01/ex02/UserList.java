
public interface	UserList {
	static void	addUser(User user);
	static User	getUserByID(int id);
	static User	getUserByIndex(int index);
	static int	getNumberOfUsers();
}
