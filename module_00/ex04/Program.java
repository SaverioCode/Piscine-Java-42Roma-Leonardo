
import java.util.Scanner;

class Program {
	static int[][] insertArray(int[][] top10, int index, int[] arr) {
		int		i;
		int[]	tmp1;
		int[]	tmp2;

		tmp1 = top10[index];
		top10[index] = arr;
		i = index + 1;
		while (i < 9) {
			tmp2 = top10[i];
			top10[i] = tmp1;
			i++;
		}
		return (old);
	}

	static boolean	isEligible(int[][] top10, int c, int value) {
		byte	i;

		i = 0;
		while (i < 10) {
			if (value == top10[i][1] && c > top[i][0]) {
				return (true);
			}
			else if (value > top10[i][1]) {
				return (true);
			}
			i++;
		}
	}

	// static int[][] initTop10(int[][] top10) {
	// 	byte	i;

	// 	i = 0;
	// 	while (i < 10) {
	// 		top10[i][0] = 0;
	// 		top10[i][1] = 0;
	// 		i++;
	// 	}
	// 	return (top10);
	// }

	static int[][] getTop10(int[] unicode) {
		int		i;
		int[][]	top10 = new int[10][2];
		
		i = 0;
		while (i < 65536) {
			if (isEligible(top10, i, unicode[i]) == true) {
				top10 = updateTop10(top10, unicode[i]);
			}
			i++;
		}
	}

	static int[] updateUnicode(char[] arrOfChar, int len) {
		int[]	unicode = new int[65536];
		int		i;
		int		index;

		i = 0;
		while (i < len) {
			index = (int) arrOfChar[i];
			unicode[index] += 1;
			if (unicode[index] > 999) {
				System.err.println("Maximum character of the same type is 999.");
				System.exit(-1);
			}
			i++;
		}
		return (unicode);
	}

	public static void main(String[] args) {
		String	input;
		char[]	arrOfChar;
		int		len;
		int[]	unicode;
		int[][]	top10;
	
		Scanner getInput = new Scanner(System.in);
		input = getInput.nextLine();
		getInput.close();
		len = input.length();
		arrOfChar = input.toCharArray();
		unicode = updateUnicode(arrOfChar, len);
		top10 = getTop10(unicode);
		/// print chart ///
	}
}
