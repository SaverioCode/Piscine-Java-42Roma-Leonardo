
import	java.io.InputStream;
import	java.io.FileInputStream;
import	java.io.IOException;
import	java.io.FileNotFoundException;
import	java.net.MalformedURLException ;
import	java.util.List;
import	java.util.ArrayList;
import	java.net.URL;

public class Database {
	private static Database	instance;
	public static List<URL>	urlsList = new ArrayList<URL>();

	public static URL	getURL() {
		URL	url;
		
		if (urlsList.isEmpty() == true) {
			return (null);
		}
		url = urlsList.get(0);
		urlsList.remove(0);
		return (url);
	}

	private static int	skipNonPrintable(InputStream file, int byteInt) {
		while (byteInt < 33 || byteInt == 127 ) {
			try {
				byteInt = file.read();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		return (byteInt);
	}

	private static String	getStr(InputStream file) {
		String	str = "";
		int		byteInt = 0;

		byteInt = skipNonPrintable(file, byteInt);
		while (byteInt > 32 && byteInt != 127) {
			str += (char)byteInt;
			try {
				byteInt = file.read();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		if (str.length() == 0) {
			return (null);
		}
		return (str);
	}

	public static void	createDatabase(String fileName) throws FileNotFoundException {
		InputStream file = new FileInputStream(fileName);
		String		str;
		
		while ((str = getStr(file)) != null) {
			try {
				urlsList.add(new URL(str));
			} catch (MalformedURLException e) {
				System.err.println(e);
			}
		}
	}
}
