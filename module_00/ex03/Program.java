
import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		byte	week;
		String input;
		
		Scanner getInput = new Scanner(System.in);
		week = 1;
		while (week < 19) {
			input = getInput.nextLine();
			if (input.equals("42") == true) {
				break ;
			}
			if (input.equals("Week " + week) == false) {
				System.err.println("IllegalArgument");
				System.exit(-1);
			}
			week++;
		}
	}
}