
package edu.school42.printer.app;

import	java.io.IOException;
import	edu.school42.printer.logic.Logic;

public class	App	{
	private static int		whiteChar;
	private static int		blackChar;
	private static String	pathName;

	private static void	errorInput() {
		System.err.println("Error: input format: --whiteToChar=<CHARACTER> --blackToChar=<CHARACTER> --path=<PATH_TO_FILE>");
		System.exit(1);
	}

	private static void	checkInput(String[] args) {
		String[]	input;

		if (args.length != 3) {
			errorInput();
		}
		input = args[0].split("=");
		if (input.length != 2) {
			errorInput();
		}
		if (input[0].equals("--whiteToChar") == false || input[1].length() != 1) {
			errorInput();
		}
		whiteChar = (int)input[1].charAt(0);
		input = args[1].split("=");
		if (input.length != 2) {
			errorInput();
		}
		if (input[0].equals("--blackToChar") == false || input[1].length() != 1) {
			errorInput();
		}
		blackChar = (int)input[1].charAt(0);
		input = args[2].split("=");
		if (input.length != 2 || input[0].equals("--path") == false) {
			errorInput();
		}
		pathName = input[1];
	}

	public static void	main(String[] args) {
		Logic	instance;

		checkInput(args);
		try {
			instance = Logic.getInstance(pathName, whiteChar, blackChar);
			instance.createPicture();
			instance.printPicture();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}
