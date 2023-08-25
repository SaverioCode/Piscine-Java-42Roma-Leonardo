
public class	Threads implements Runnable {
	private	static boolean	lock = true;
	private boolean			status;
	private String			str;
	private int				count;

	public Threads(String str, int count, boolean status) {
		this.str = str;
		this.count = count;
		this.status = status;
	}

	@Override
	public void	run() {
		for (int i = 0; i < this.count; i++) {
			if (lock == this.status) {
				printMessage(this.status, this.str);
			}
			else {
				i--;
			}
		}
	}

	private static synchronized void	printMessage(boolean status, String str) {
		lock = !status;
		System.out.println(str);
	}
}
