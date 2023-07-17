
import java.util.Scanner;

class Program {
	static long	formatResult(long results) {
		long	formatted;

		formatted = 0;
		while (results > 0) {
			formatted = (formatted * 10) + (results % 10);
			results = (results - (results % 10)) / 10;
		}
		return (formatted);
	}

	static void printResults(long results, byte maxWeek) {
		byte	week;
		long	grade;
		int		i;
		char	c;

		c = '=';
		results = formatResult(results);
		week = 1;
		while (week < maxWeek) {
			grade = results % 10;
			results = (results - results % 10) / 10;
			System.out.printf("Week %d ", week);
			i = 0;
			while (i < grade) {
				System.out.print(c);
				i++;
			}
			System.out.println(">");
			week++;
		}
	}

	static long	updateResults(int grades, long results) {
		long	update;

		update = 0;
		update = results * 10 + grades;
		return (update);
	}

	static int	getGrades(Scanner getGrade) {
		int		lower;
		int		newGrade;
		byte	i;
		lower = 10;
		i = 0;

		while (i < 5) {
			newGrade = getGrade.nextInt();
			if (newGrade < 1 || newGrade > 9) {
				System.err.println("Grade has to be >= 1 and <= 9");
				getGrade.close();
				System.exit(-1);
			}
			if (lower > newGrade) {
				lower = newGrade;
			}
			i++;
		}
		return (lower);
	}

	public static void main(String[] args) {
		byte	week;
		int		lowerGrade;
		long	results;
		String	input;
		
		Scanner getInput = new Scanner(System.in);
		results = 0;
		week = 1;
		while (week < 19) {
			input = getInput.nextLine();
			if (input.equals("42") == true) {
				week++;
				break ;
			}
			if (input.equals("Week " + week) == false) {
				System.out.printf("|%s|\n", input);
				System.err.println("IllegalArgument");
				getInput.close();
				System.exit(-1);
			}
			lowerGrade = getGrades(getInput);
			results = updateResults(lowerGrade, results);
			week++;
			input = getInput.nextLine();
		}
		getInput.close();
		week--;
		printResults(results, week);
	}
}
