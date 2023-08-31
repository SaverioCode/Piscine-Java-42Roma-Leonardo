
import	java.io.OutputStream;
import	java.io.FileOutputStream;
import	java.io.IOException;
import	java.io.BufferedInputStream;
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
		BufferedInputStream	urlStream;
		URLConnection		urlConnection;
		URL					url;

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
			System.out.printf("Thread-%d start download file number %d\n", this.index, this.localFileNum);
			try {
				urlStream = new BufferedInputStream(url.openStream());
				copyOnFile(urlStream, getFileName(url));
			} catch (IOException e) {
				System.err.println(e);
			}
			System.out.printf("Thread-%d finish download file number %d\n", this.index, this.localFileNum);
		}
	}

	private String	getFileName(URL url) {
		String[]	arr;

		arr = url.getPath().split("/");
		return (arr[arr.length - 1]);
	}

	private void	copyOnFile(BufferedInputStream urlStream, String fileName) throws IOException {
		OutputStream	newFile = new FileOutputStream(fileName);
		int				intByte;

		while ((intByte = urlStream.read()) != -1) {
			newFile.write(intByte);
		}
	}	
}
