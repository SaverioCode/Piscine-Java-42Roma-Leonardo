
import	java.util.Scanner;
import	java.io.File;
import	java.io.IOException;

public class	Program {

	private static boolean	isPrintable(int c) {
		if (c > 32 && c != 127) {
			return (true);
		}
		return (false);
	}

	private static int	getArrLen(String input) {
		int	len;
	
		len = 0;
		for (int i = 0; i < input.length(); i++) {
			if (isPrintable(input.charAt(i)) == true) {
				len += 1;
			}
			while (i < input.length() && isPrintable(input.charAt(i)) == true) {
				i++;
			}
		}
		return (len);
	}

	private static String[]	tokenizeInput(String input) {
		String[]	inputArr;
		int			arrLen, i, j;

		arrLen = getArrLen(input);
		if (arrLen == 0) {
			return (null);
		}
		inputArr = new String[arrLen];
		i = j = 0;
		for (String str: inputArr) {
			str = "";
			while (i < input.length() && isPrintable(input.charAt(i)) == false) {
				i++;
			}
			while (i < input.length() && isPrintable(input.charAt(i)) == true) {
				str += input.charAt(i);
				i++;
			}
			inputArr[j] = str;
			j++;
		}
		return (inputArr);
	}

	private static Commands	checkInput(String[] args) {
		String[]	input;
		Commands	shell;
		File		path;

		if (args.length != 1) {
			System.err.println("Error: starting path is mandatory.");
			System.exit(1);
		}
		input = args[0].split("=", 2);
		if (input[0].equals("--current-folder") == false) {
			System.err.println("Error: program input has to be \"--current-folder=<FOLDER_NAME>\".");
			System.exit(1);
		}
		path = new File(input[1]);
		if (path.isDirectory() == false) {
			System.err.println("Error: invalid path.");
			System.exit(1);			
		}
		shell = Commands.getInstance(input[1]);
		return (shell);
	}

	public static void	main(String[] args) {
		Scanner		getInput = new Scanner(System.in);
		Commands	shell;
		String		input;
		String[]	inputArr;

		shell = checkInput(args);
		while (true) {
			System.out.print(">> ");
			input = getInput.nextLine();
			if (input == null) {
				continue ;
			}
			inputArr = tokenizeInput(input);
			try {
				shell.execute(inputArr);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}
}
