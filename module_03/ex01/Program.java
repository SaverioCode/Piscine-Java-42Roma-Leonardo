
public class	Program {
	private static void	exitError(String e) {
		System.err.println(e);
		System.exit(1);
	}

	private static int	checkInput(String[] args) {
		String[]	input;

		if (args.length != 1) {
			exitError("Error: the program accept only 1 argument.");
		}
		input = args[0].split("=", 2);
		if (input.length != 2 || input[0].equals("--count") == false) {
			exitError("Error: input has to be \"--count=<INTEGER>\".");
		}
		return (Integer.parseInt(input[1]));
	}

	public static void	main(String[] args) {
		Thread	eggThread, henThread;
		Threads	egg, hen;
		int		count;
		
		count = 0;
		try {
			count = checkInput(args);
		} catch (NumberFormatException e) {
			exitError("Error: input has to be \"--count=<INTEGER>\".");
		}

		egg = new Threads("Egg", count, true);
		eggThread = new Thread(egg);
		hen = new Threads("Hen", count, false);
		henThread = new Thread(hen);
		eggThread.start();
		henThread.start();
	}
}
