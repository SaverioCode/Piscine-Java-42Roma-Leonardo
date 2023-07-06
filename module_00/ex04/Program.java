
import java.util.Scanner;

class Program {
	static int[][] insertArray(int[][] top10, int index, int c, int value) {
		int		i;
		int[][]	newTop10;
		int[]	arr;

		newTop10 = new int[10][2];
		arr = new int[2];
		arr[0] = c;
		arr[1] = value;

		while (i < index) {
			newTop10[i] = top10[i];
			i++;
		}
		newTop10[i] = arr;
		i++;
		while (i < 10) {
			newTop10[i] = top10[i - 1];
			i++;
		}
		return (newTop10);
	}

	static void	printChart(int[][] top10) {
		int		unit;
		int		i;
		byte	j;

		if (top10[0][1] < 1) {
			return ;
		}
		unit = 1;
		if (top10[0][1] > max) {
			unit = top10[0][1] / 10;
		}
		i = top10[0][1] + unit;
		while (i >= 0) {
			j = 0;
			while (j < 10) {
				if (top10[j][1] > 0) {
					if (top10[j][1] / 10 >= 1) {
						System.out.print("#");
					}
					else if (i - unit <= top10[j][1]) {
						System.out.print(top10[j][1]);
					}
				}
				j++;
			}
			System.out.println();
			i -= unit;
		}
		i = 0;
		while (i < 10) {
			if (top10[i][1] > 0) {
				System.out.print((char) top10[i][0]);
			}
			i++;
		}
		System.out.println();
	}

	static int[][] getTop10(int[] unicode) {
		int		i;
		int		j;
		int[][]	top10 = new int[10][2];
		
		i = 0;
		while (i < 65536) {
			if (unicode[i] > 0) {
				j = 0;
				while (j < 10) {
					if (unicode[i] == top10[j][1] && i < top[j][0]) {
						top10 = insertArray(top10, j, i unicode[i]);
						return (true);
					}
					else if (unicode[i] > top10[j][1]) {
						top10 = insertArray(top10, i unicode[i]);
						return (true);
					}
					j++;
				}
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
		printChart(top10);
	}
}
