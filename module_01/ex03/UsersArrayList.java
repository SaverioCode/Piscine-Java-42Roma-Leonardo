
public class	UsersArrayList implements UserList {
	private static UsersArrayList	instance;
	private static User[]			userList;
	private static int				numUsers;

	static public	UsersArrayList	getInstance() {
		if (instance == null) {
			instance = new UsersArrayList();
			userList = new User[10];
			numUsers = 0;
		}
		return (instance);
	}

	private User[] increaseUserList(User[] oldUserList, int len) {
		User[]	newUserList;
		int		i;

		newUserList = new User[len * (3 / 2)];
		i = 0;
		while (i < len) {
			newUserList[i] = oldUserList[i];
			i++;
		}
		return (newUserList);
	}

	@Override
	public void addUser(User user) {
		if (numUsers == userList.length) {
			userList = increaseUserList(userList, userList.length);
		}
		userList[numUsers] = user;
		numUsers++;
	}

	@Override
	public User getUserByID(int id) {
		for (int i = 0; i < userList.length; i++) {
			if (userList[i].getID() == id) {
				return (userList[i]);
			}
		}
		throw new UserNotFoundException("User not found\n");
	}

	@Override
	public User	getUserByIndex(int index) {
		if (index < 0 || userList.length <= index) {
			throw new UserNotFoundException("User not found\n");
		}
		return (userList[index]);
	}

	@Override
	public int	getNumberOfUsers() {
		return (numUsers);
	}
}
