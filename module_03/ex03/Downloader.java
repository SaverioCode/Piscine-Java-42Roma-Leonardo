
import	java.net.URLConnection;

public static	Downloader implements Runnable {
	private static Object	lock;
	private static int		globalFileNum = 0;
	private	int				localFileNum;

	public static void	setLock(Object objLock) {
		lock = objLock;
	}

	@Override
	public void	run() {
		URLConnection	urlC;
		URL				url;

		while (true) {
			synchronized (lock) {
				url = Database.getURL();
				globalFileNum++;
				this.localFileNum = globalFileNum;
			}
			if (url == null) {
				return ;
			}
			urlC = new URLConnection(url);
			System.out.printf("%s start download file number %d\n", Thread.getName(), this.localFileNum);
			// download file
			System.out.printf("%s finish download file number %d\n", Thread.getName(), this.localFileNum);
		}
	}

	private static synchronized URL getURL() {
		return (Database.getURL());
	}
}
