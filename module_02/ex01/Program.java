
import	java.io.Reader;
import	java.io.FileReader;
import	java.io.IOException;
import	java.io.FileNotFoundException;
import	java.util.TreeSet;

public class	Program {

	public static void	main(String[] args) {
		TreeSet<String>	dictionary;

		if (args.length != 2) {
			System.err.println("Error: number of arguments has to be 2.");
			System.exit(1);
		}
		/// check size of the files

		// dictionary = createDictionary(args);
		dictionary = Dictionary.createDictionary(args);
		/// print dictionary in dictionary.txt
		
		/// match worlds
		/// end program

	}
}
