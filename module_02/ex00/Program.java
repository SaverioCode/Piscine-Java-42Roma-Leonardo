
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Program {

	private static void readSignature(List<String> fileList, List<int[]> signature) {
		InputStream	file;
		int	data[] = new int[4];

		for (String fileName : fileList) {
			try {
				file = new FileInputStream(fileName);
			} catch (FileNotFoundException e) {
				System.err.println(e);
				continue ;
			}
			for (int i = 0; i < 4; i++) {
				try {
					data[i] = file.read();
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
		}

		//Integer.toHexString(data));
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
		}
	}

	public static void main(String[] args) {
		Map<String, String[]>	database;
		List<int[]> 			signature;
		List<String>			fileName;
		/// create list with results ///

		database = new HashMap<String, String[]>();
		try {
			Database.createDatabase(database);
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		fileName = new ArrayList<String>();
		getFilesName(fileName);
		signature = new ArrayList<int[]>();
		readSignature(fileName, signature);
		// match signatures and store result
		// print results

		// end program
	}
}
