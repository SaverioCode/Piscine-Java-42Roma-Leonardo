
public class	Program {
	private	static int	arraySize;
	private static int	threadsCount;

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
		input = args[1].split("=", 2);
		if (input.length != 2 || input[0].equals("--threadsCount") == false) {
			exitError("Error: input has to be \"--threadsCount=<INTEGER>\".");
		}
		threadsCount = Integer.parseInt(input[1]);
	}

	public static void	main(String[] args) {
		
		try {
			checkInput(args);
		} catch (NumberFormatException e) {
			exitError("Error: program input \"--arraySize=<INTEGER> --threadsCount=<INTEGER>\".");
		}
	}
}
