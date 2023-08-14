
import java.io.*;
import java.util.*;

public class	Database {

	private static int	skipNonPrintable(InputStream file, int data) throws IOException {
		while ((data < 33 || data == 127) && data != -1) {
			data = file.read();
		}
		return (data);
	}

	private static String	getValue(InputStream file, int data) throws IOException {
		String	value;

		value = "";
		data = skipNonPrintable(file, data);
		while (data > 32 && data != 127) {
			value += (char)data;
			data = file.read();
		}
		return (value);
	}

	private	static String	getKey(InputStream file, int data) throws IOException {
		String	key;
		
		key = "";
		data = skipNonPrintable(file, data);
		while (((char)data != ',' || data < 33 || data == 127) && data != -1) {
			key += (char)data;
			data = file.read();
		}
		return (key);
	}

	public static void createDatabase(Map<String, String[]> database) throws IOException {
		InputStream	file;
		int			data;
		String		key;
		String[]	value = new String[4];
	
		file = null;
		try {
			file = new FileInputStream("signature.txt");
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		}
		data = 0;
		while (data != -1) {
			key = getKey(file, data);
			data = file.read();
			for (byte i = 0; i < 4; i++) {
				value[i] = getValue(file, data);
			}
			database.put(key, value);
			data = skipNonPrintable(file, data);
		}
		file.close();
	}
}
