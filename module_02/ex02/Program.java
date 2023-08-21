
import	java.util.Scanner;
import	java.nio.file.Files;
import	java.nio.file.Paths;
import	java.nio.file.Path;

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
		Commands	shell;
		Path		path;

		if (args.length != 1) {
			System.err.println("Error: starting path is mandatory.");
			System.exit(1);
		}
		path = Paths.get(args[0]);
		if (Files.isDirectory(path) == false) {
			System.err.println("Error: invalid path.");
			System.exit(1);
		}
		shell = Commands.getInstance(path);
		shell.executeCd(args[0]);
		return (shell);
	}

	public static void	main(String[] args) {
		Scanner		getInput = new Scanner(System.in);
		Commands	shell;
		String		input;
		String[]	inputArr;

		shell = checkInput(args);
		while (true) {
			input = getInput.nextLine();
			if (input == null) {
				continue ;
			}
			inputArr = tokenizeInput(input);
			shell.execute(inputArr);
		}
	}
}
