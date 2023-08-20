
import	java.io.IOException;
import	java.lang.Math;
import	java.math.BigDecimal;
import	java.nio.file.Files;
import	java.nio.file.Path;
import	java.nio.file.Paths;
import	java.util.TreeSet;

public class	Program {

	private static void	checkInput(String[] files) {
		Path	path;
		long	fileSize = 0;

		if (files.length != 2) {
			System.err.println("Error: number of arguments has to be 2.");
			System.exit(1);
		}
		for (String file: files) {
			path = Paths.get(file);
			try {
				fileSize = Files.size(path) / Math.round(Math.pow(10, 6));
			}	catch (IOException e) {
				System.err.println(e);
				System.exit(1);
			}
			if (fileSize > 10) {
				System.err.println("Error: file is bigger then 10Mb.");
				System.exit(1);
			}
		}
	}

	public static void	main(String[] args) {
		CompareFiles	instance;
		BigDecimal		similarity;
	
		checkInput(args);
		instance = CompareFiles.getInstance(args);
		try {
			instance.printDictionary();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		similarity = new BigDecimal((float)instance.similarity);
		similarity = similarity.setScale(2, similarity.ROUND_DOWN);
		System.out.println("Similarity = " + similarity);
	}
}
