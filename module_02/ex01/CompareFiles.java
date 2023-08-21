
import	java.lang.Math;
import	java.io.FileReader;
import	java.io.FileWriter;
import	java.io.IOException;
import	java.io.FileNotFoundException;
import	java.util.List;
import	java.util.ArrayList;
import	java.util.Iterator;
import	java.util.TreeSet;

public class	CompareFiles {
	private static CompareFiles		instance;
	public static TreeSet<String>	dictionary;
	private static List<String>		wordsList1;
	private static List<String>		wordsList2;
	private static int[]			vector1;
	private static int[]			vector2;
	public static double			similarity;

	private CompareFiles(String[] files) {
		this.wordsList1 = new ArrayList<String>();
		this.wordsList2 = new ArrayList<String>();
		this.dictionary = createDictionary(files);
		this.vector1 = createVector(this.wordsList1);
		this.vector2 = createVector(this.wordsList2);
		this.similarity = compareVectors();
	}

	public static CompareFiles	getInstance(String[] files) {
		if (instance == null) {
			instance = new CompareFiles(files);
		}
		return (instance);
	}
	
	private double	compareVectors() {
		double	numerator, denominator;
		double	a, b, sommatoryA, sommatoryB;

		numerator = denominator = sommatoryA = sommatoryB = 0;
		for (int i = 0; i < dictionary.size(); i++) {
			a = this.vector1[i];
			b = this.vector2[i];
			numerator += a * b;
			sommatoryA += Math.pow(a, 2);
			sommatoryB += Math.pow(b, 2);
		}
		denominator = Math.sqrt(sommatoryA) * Math.sqrt(sommatoryB);
		return (numerator / denominator);
	}

	public void		printDictionary() throws IOException{
		FileWriter			file = null;
		String				word;
		Iterator<String>	list;

		file = new FileWriter("dictionary.txt");
		list = this.dictionary.iterator();
		while (list.hasNext()) {
			word = list.next();
			file.write(word + " ");
		}
		file.close();
	}

	private int[]	createVector(List<String> wordList) {
		Iterator<String>	list;
		String				word;
		int[]				vector;
		int					i;

		vector = new int[this.dictionary.size()];
		list = this.dictionary.iterator();
		i = 0;
		while (list.hasNext()) {
			word = list.next();
			while (wordList.indexOf(word) != -1) {
					wordList.remove(word);
					vector[i] += 1;
			}
			i++;
		}
		wordList = null;
		return (vector);
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
		return (word);
	}

	private static void	addWordList(String fileName, List<String> wordList) {
		FileReader		file = null;

		try {
			file = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		}
		for (String word = getWord(file); word != null; word = getWord(file)) {
			wordList.add(word);
			dictionary.add(word);
		}
		try {
			file.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private TreeSet<String> createDictionary(String[] files) {
		FileReader		file = null;

		this.dictionary = new TreeSet<String>();
		addWordList(files[0], this.wordsList1);
		addWordList(files[1], this.wordsList2);
		return (dictionary);
	}
}
