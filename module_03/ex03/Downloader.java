
import	java.io.IOException;
import	java.net.URLConnection;
import	java.net.URL;

public class	Downloader implements Runnable {
	private static Object	lock;
	private static int		globalFileNum = 0;
	private	int				localFileNum;
	private	int				index;

	public Downloader(int i) {
		this.index = i + 1;
	}

	public static void	setLock(Object objLock) {
		lock = objLock;
	}

	@Override
	public void	run() {
		URLConnection	urlConnection;
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
			try {
				urlConnection = url.openConnection();
			} catch (IOException e) {
				System.out.println(e);
				continue ;
			}
			// urlC = new URLConnection(url);
			System.out.printf("Thread-%d start download file number %d\n", this.index, this.localFileNum);
			// download file
			System.out.printf("%s finish download file number %d\n", this.index, this.localFileNum);
		}
	}

	private static synchronized URL getURL() {
		return (Database.getURL());
	}
}
