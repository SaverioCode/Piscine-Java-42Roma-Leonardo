
public class	Program {
	private	static int	arraySize;
	private static int	maxSize = 2000000;
	private static int	threadsCount;
	private static int	maxCount = 1000;

	private static void	exitError(String str) {
		System.err.println(str);
		System.exit(1);
	}

	private static void	checkInput(String[] args) {
		String[]	input;

		if (args.length != 2) {
			exitError("Error: program input \"--arraySize=<INTEGER> --threadsCount=<INTEGER>\".");
		}
		input = args[0].split("=", 2);
		if (input.length != 2 || input[0].equals("--arraySize") == false) {
			exitError("Error: input has to be \"--arraySize=<INTEGER>\".");
		}
		arraySize = Integer.parseInt(input[1]);
		if (arraySize > maxSize) {
			exitError("Error: max array size is \"2.000.000\".");
		}
		input = args[1].split("=", 2);
		if (input.length != 2 || input[0].equals("--threadsCount") == false) {
			exitError("Error: input has to be \"--threadsCount=<INTEGER>\".");
		}
		threadsCount = Integer.parseInt(input[1]);
		if (threadsCount > maxCount) {
			exitError("Error: max threads count is \"1.000\".");
		}
		else if (threadsCount > arraySize) {
			exitError("Error: threads count has to be less or equal to array size.");
		}
	}

	public static void	main(String[] args) {
		
		try {
			checkInput(args);
		} catch (NumberFormatException e) {
			exitError("Error: program input \"--arraySize=<INTEGER> --threadsCount=<INTEGER>\".");
		}
	}
}
