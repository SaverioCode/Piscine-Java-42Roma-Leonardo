
import	java.io.FileReader;
import	java.io.IOException;
import	java.io.FileNotFoundException;
import	java.util.TreeSet;

public class	Dictionary {

	private static void		printDictionary(TreeSet<String> dictionary) {
		
	}

	private	static String	getWord(FileReader file) {
		String	word = "";
		int		character;

		while (true) {
			try {
				character = file.read();
			} catch (IOException e) {
				System.err.println(e);
				break ;
			}
			if (character == -1) {
				break ;
			}
			if (character < 33 || character == 127) {
				if (word.length() == 0) {
					continue ;
				}
				break ;
			}
			word += (char)character;
		}
		if (word.length() == 0) {
			return (null);
		}
		System.out.printf("|%s|\n", word);//////////////////////
		return (word);
	}

	public static TreeSet<String> createDictionary(String[] files) {
		TreeSet<String>	dictionary = new TreeSet<String>();
		FileReader		file = null;

		for (String text: files) {
			try {
				file = new FileReader(text);
			} catch (FileNotFoundException e) {
				System.err.println(e);
				System.exit(1);
			}
			for (String word = getWord(file); word != null; word = getWord(file)) {
				dictionary.add(word);
			}
			try {
				file.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		/// print dictionary
		return (dictionary);
	}
}
