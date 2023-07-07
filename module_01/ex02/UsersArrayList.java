
public class	UsersArrayList implements UserList {
	private static UseArrayList	instance;

	private	UserArrayList() {
		User[]	userList;

		userList = new User[10];
	}

	public	getInstance() {
		if (instance == null) {
			instance = new UserList();
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

		len = userList.length;
		i = 0;
		while ( i < length) {
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
		/// thrown exception ///
	}

	public User	getUserByIndex(int index) {
		if (userList.length <= index) {
			/// thrown exception ///
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
