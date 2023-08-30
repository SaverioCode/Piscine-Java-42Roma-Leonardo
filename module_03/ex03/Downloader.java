
import	java.net.URLConnection;

public static	Downloader implements Runnable {
	private static Object	lock;

	public static void	setLock(Object objLock) {
		lock = objLock;
	}

	@Override
	public void	run() {
		URLConnection	urlC;
		URL				url;

		while (true) {
			url = getURL();			
			if (url == null) {
				return ;
			}
			urlC = new URLConnection(url);
		}
	}

	private static synchronized URL getURL() {
		Database.getURL();
	}
}
