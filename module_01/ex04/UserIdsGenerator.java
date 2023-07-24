
public class	UserIdsGenerator {
	private static UserIdsGenerator	instance;
	private	static int				id;

	private UserIdsGenerator() {
		this.id = 1;
	}

	public static UserIdsGenerator getInstance() {
		if (instance == null) {
			instance = new UserIdsGenerator();
		}
		return (instance);
	}

	public int	generateId() {
		int	id;

		id = this.id;
		this.id += 1;
		return (id);
	}
}
