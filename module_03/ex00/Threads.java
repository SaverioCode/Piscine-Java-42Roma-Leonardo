
public class	Threads implements Runnable {
	private String	str;
	private int		count;

	public Threads(String str, int count) {
		this.str = str;
		this.count = count;
	}

	public void	run() {
		for (int i = 0; i < this.count; i++) {
			System.out.println(str);
		}
	}
}
