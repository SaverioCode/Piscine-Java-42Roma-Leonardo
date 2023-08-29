
import	java.util.Random;
import	java.util.stream.IntStream;

public class	Program {
	private static int	arraySize;
	private static int	threadsCount;

	private static void	exitError(String str) {
		System.err.println(str);
		System.exit(1);
	}

	private static void	checkInput(String[] args) {
		String[]	input;
		int			maxSize = 2000000;

		if (args.length != 2) {
			exitError("Error: program input \"--arraySize=<INTEGER> --threadsCount=<INTEGER>\".");
		}
		input = args[0].split("=", 2);
		if (input.length != 2 || input[0].equals("--arraySize") == false) {
			exitError("Error: input has to be \"--arraySize=<INTEGER>\".");
		}
		arraySize = Integer.parseInt(input[1]);
		if (arraySize > maxSize || arraySize < 1) {
			exitError("Error: 0 < ARRAY_SIZE < 2.000.000 .");
		}
		input = args[1].split("=", 2);
		if (input.length != 2 || input[0].equals("--threadsCount") == false) {
			exitError("Error: input has to be \"--threadsCount=<INTEGER>\".");
		}
		threadsCount = Integer.parseInt(input[1]);
		if (threadsCount > arraySize || threadsCount < 1 ) {
			exitError("Error: 0 < THREADS_COUNT < ARRAY_SIZE .");
		}
	}

	private static int[]	generateNumArr() {
		Random		generator = new Random();
		IntStream	intStream;

		intStream = generator.ints(arraySize, -1000, 1001);
		return (intStream.toArray());
	}

	private static void	sumArr(int[] arr) {
		long	sum = 0;
	
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("Sum: " + sum);
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
		int[]		arr;
		int			range;
		int			start, end;
		Counter[]	counters;
		Thread[]	threads;

		try {
			checkInput(args);
		} catch (NumberFormatException e) {
			exitError("Error: program input \"--arraySize=<INTEGER> --threadsCount=<INTEGER>\".");
		}
		arr = generateNumArr();
		sumArr(arr);
		Counter.setArr(arr);
		Counter.setLock(new Object());
		counters = new Counter[threadsCount];
		threads = new Thread[threadsCount];
		range = Math.round(arraySize / threadsCount);
		start = 0;
		end = start + range - 1;
		for (int i = 0; i < threadsCount; i++) {
			counters[i] = new Counter(i, start, end);
			threads[i] = new Thread(counters[i]);
			threads[i].start();
			start = end + 1;
			if (i < threadsCount - 2) {
				end = start + range - 1;
			}
			else {
				end = arraySize - 1; 
			}
		}
		waitThreads(threads);
		System.out.println("Sum by threads: " + Counter.getSum());
	}
}
