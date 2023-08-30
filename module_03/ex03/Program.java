
import	java.io.FileNotFoundException;

public class	Program {
	private static int	threadsCount;

	private static void	exitError(String str) {
		System.err.println(str);
		System.exit(1);
	}

	private static void	checkInput(String[] args) {
		String[]	input;

		if (args.length != 1) {
			exitError("Error: program input \"--threadsCount=<INTEGER>\".");
		}
		input = args[0].split("=", 2);
		if (input.length != 2 || input[0].equals("--threadsCount=") == false) {
			exitError("Error: input has to be \"--threadsCount==<INTEGER>\".");
		}
		threadsCount = Integer.parseInt(input[1]);
		if (threadsCount < 1) {
			exitError("Error: <THREADS_COUNT> has to be greater then 0.");
		}
	}

	private static void	waitThreads(Thread[] threads) {
		for (int i = 0; i < threadsCount; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}

	public static void	main(String[] args) {
		Object			lock;
		Downloader[]	threadsRunable;
		Thread[]		threads;

		try {
			checkInput(args);
		} catch (NumberFormatException e) {
			exitError("Error: program input \"--threadsCount=<INTEGER>\".");
		}
		try {
			Database.createDatabase("files_urls.txt");
		} catch (FileNotFoundException e) {
			exitError(e.toString());
		}
		lock = new Database();
		Downloader.setLock(lock);
		threadsRunable = new Downloader[threadsCount];
		threads = new Thread[threadsCount];
		for (int i = 0; i < threadsCount; i++) {
			threadsRunable[i] = new Downloader(i);
			threads[i] = new Thread(threadsRunable[i]);
			threads[i].start();
		}
		System.out.println("All file downloaded.");
	}
}
