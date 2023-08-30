
public class	Program {
	private static int	threadsCount;

	private static void	exitError(String str) {
		System.err.println(str);
		System.exit(1);
	}

	private static void	checkInput(String[] args) {
		String	input;

		if (args.length != 1) {
			exitError("Error: program input \"--threadsCount=<INTEGER>\".");
		}
		input = args[0].split("=", 2);
		if (input.length != 2 || input[0].equals("--threadsCount=") == false) {
			exitError("Error: input has to be \"--threadsCount==<INTEGER>\".");
		}
		threadsCount = Integer.parseInt(input[1]);
		if (arraySize > maxSize || arraySize < 1) {
			exitError("Error: <THREADS_COUNT> has to be greater then 0.");
		}
	}

	public static void	main(String[] args) {
		Object	lock;


		try {
			checkInput(args);
		} catch (NumberFormatException e) {
			exitError("Error: program input \"--threadsCount=<INTEGER>\".");
		}
		Database.createDatabase("files_urls.txt");
		lock = new Database();
		Downloader.setLock(lock);
		System.out.println("All file downloaded.");
	}
}
