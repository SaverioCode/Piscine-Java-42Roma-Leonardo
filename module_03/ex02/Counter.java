
public class	Counter implements Runnable {
	private	static int[]	intArr;
	private static long		sum;
	private int				arrStart;
	private int				arrEnd;

	// public	Counter(int[] intArr, int[] range) {
	// 	this.arrStart = range[0];
	// 	this.arrEnd = range[1];
	// }

	public	Counter(int start, int end) {
		this.arrStart = start;
		this.arrEnd = end;
	}

	@Override
	public void	run() {
		System.out.println("FATTI I CAZZI TUOI");
	}

	public static void setArr(int[] arr) {
		intArr = arr;
	}

	private static synchronized void	addSumm(int num) {
		sum += num;
	}

	public static long	getSum() {
		return (sum);
	}
	
	// /// TESTING ///
	// public static int[]	getArr() {
	// 	return (intArr);
	// }
}
