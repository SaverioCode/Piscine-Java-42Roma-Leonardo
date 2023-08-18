
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Program {

	private static void	printResults(List<String> results) {
		for (String str: results) {
			System.out.println(str);
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
				data[i] = Integer.toHexString(file.read());
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

	/// TESTING ///
	private static void	printData(String[] data) {
		System.out.println("PRINT DATA 1");
		for (String str: data) {
			System.out.println(str);
		}
		System.out.println("END PRINT DATA\n");
	}

	private static byte	check(List<String> results, String[] values, String[] data) {
		System.out.println("\nCHECK");
		for (int i = 0; i < 4; i++) {
			System.out.printf("value: |%s|, data: |%s|\n", values[i], data[i] );////////////////
			if (values[i].equals(data[i]) == false) {
				System.out.println("FAILED\n");
				// System.out.println(fileName + "FAILED");/////////////
				return (1);
			}
		}
		System.out.println("SUCCESS\n");
		return (0);
	}

	private static List<String> matchSignature(Map<String, String[]> database, List<String> fileList) {
		List<String>	results;
		String[]		data;

		results = new ArrayList<String>();
		for (String fileName: fileList) {
			data = readSignature(fileName);
			if (data == null) {
				System.out.println("DATA IS NULL");///////////
				continue ;
			}
			printData(data);
			// if (database.containsValue(data) == true) {
				System.out.println("FUCKING HERE");///////////////
				for (Entry<String, String[]> entry: database.entrySet()) {
					String[] values = entry.getValue();
					// String[] values = entry.getValue();
					// for (int i = 0; i < 4; i++) {
					// 	System.out.println(values[i]);////////////////
					// 	if (values[i].equals(data[i]) == false) {
					// 		System.out.println(fileName + "FAILED");/////////////
					// 		continue;
					// 	}
					// }
					if (check(results, values, data) == 0) {
						results.add(fileName + "\n" + entry);
					}
				}
			// }
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

	/// TESTING ///
	private static void	printFileNames(List<String> fileList) {
		System.out.println("\nPRINT FILE NAMES");
		for (String fileName: fileList) {
			System.out.println(fileName);
		}
		System.out.println();
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
		printFileNames(fileName);//////TESTING///////
		results = matchSignature(database, fileName);
		printResults(results);
	}
}
