
public interface	UserList {
	public abstract void	addUser(User user);
	public abstract User	getUserByID(int id);
	public abstract User	getUserByIndex(int index);
	public abstract int		getNumberOfUsers();
}
