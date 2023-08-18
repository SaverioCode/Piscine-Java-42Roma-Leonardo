
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Program {

	private static void	printResults(List<String> results) throws FileNotFoundException {
		OutputStream	resultFile = new FileOutputStream("result.txt");
	
		for (String str: results) {
			try {
				resultFile.write(str.getBytes());
			} catch (IOException e) {
				System.err.println(e);
				continue ;
			}
		}
	}

	private static String[] readSignature(String fileName) {
		InputStream	file;
		String	data[] = new String[4];

		try {
			file = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.err.println(e);
			return (null);
		}
		for (int i = 0; i < 4; i++) {
			try {
				data[i] = Integer.toHexString(file.read()).toUpperCase();
			} catch (IOException e) {
				System.err.println(e);
				break ;
			}
		}
		try {
			file.close();
		} catch (IOException e) {
			System.err.println(e);
		}
		return (data);
	}

	private static byte	check(List<String> results, String[] values, String[] data) {
		for (int i = 0; i < 4; i++) {
			if (values[i].equals(data[i]) == false) {
				return (1);
			}
		}
		return (0);
	}

	private static List<String> matchSignature(Map<String, String[]> database, List<String> fileList) {
		List<String>	results;
		String[]		data;

		results = new ArrayList<String>();
		for (String fileName: fileList) {
			data = readSignature(fileName);
			if (data == null) {
				continue ;
			}
			for (Entry<String, String[]> entry: database.entrySet()) {
				String[] values = entry.getValue();
				if (check(results, values, data) == 0) {
					results.add(fileName + ": " + entry.getKey() + "\n");
				}
			}
		}
		return (results);
	}

	private static void	getFilesName(List<String> fileName) {
		Scanner	getInput = new Scanner(System.in);
		String	input;

		while (true) {
			input = getInput.nextLine();
			if (input.equals("42") == true) {
				getInput.close();
				return ;
			}
			fileName.add(input);
			System.out.println("PROCESSED");
		}
	}

	public static void main(String[] args) {
		Map<String, String[]>	database;
		List<String>			fileName;
		List<String>			results;

		database = new HashMap<String, String[]>();
		try {
			Database.createDatabase(database);
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		fileName = new ArrayList<String>();
		getFilesName(fileName);
		results = matchSignature(database, fileName);
		try {
			printResults(results);
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
	}
}
