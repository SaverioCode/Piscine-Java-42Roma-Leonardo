
public class	UsersArrayList implements UserList {
	private static UsersArrayList	instance;
	static User[]					userList;

	static public	UsersArrayList	getInstance() {
		if (instance == null) {
			instance = new UsersArrayList();
			userList = new User[10];
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

	public void addUser(User user) {
		int	i;
		int	len;

		len = this.userList.length;
		i = 0;
		while ( i < len) {
			if (userList[i] == null) {
				userList[i] = user;
				return ;
			}
			i++;
		}
		userList = increaseUserList(userList, len);
		userList[i] = user;
	}

	public User getUserByID(int id) {
		int	i;

		i = 0;
		while (i < userList.length) {
			if (userList[i].getID() == id) {
				return (userList[i]);
			}
		}
		throw new UserNotFoundExeption("User not found\n");
	}

	public User	getUserByIndex(int index) {
		if (index < 0 || userList.length <= index) {
			throw new UserNotFoundExeption("User not found\n");
		}
		return (userList[index]);
	}

	public int	getNumberOfUsers() {
		int	i;

		i = 0;
		while (i < userList.length) {
			if (userList[i] == null) {
				return (i);
			}
			i++;
		}
		return (i);
	}
}
