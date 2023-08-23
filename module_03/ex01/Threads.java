
public class	Threads implements Runnable {
	private String	str;
	private int		count;

	public Threads(String str, int count) {
		this.str = str;
		this.count = count;
	}

	@Override
	public void	run() {
		for (int i = 0; i < this.count; i++) {
			System.out.println(this.str);
		}
	}

	/// DATEMI UNA MINCHIA DI MUTEX INVECE DE STA CAGATA DE CONSTRUCTO
	private synchronized void	printMessage() {
		System.out.println(this.str);
	}
}
