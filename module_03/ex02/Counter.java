
public class	Counter implements Runnable {
	private static int[]	arr;
	private int				localIndex;
	private int				arrStart, arrEnd;
	private static long		globalSum;
	private	long			localSum;
	private static int		globalIndex = 0;
	private static Object	lock;

	public	Counter(int index, int start, int end) {
		this.localIndex = index;
		this.arrStart = start;
		this.arrEnd = end;
	}

	public static void	setLock(Object obj) {
		lock = obj;
	}

	public static void	setArr(int[] newArr) {
		arr = newArr;
	}

	public static long	getSum() {
		return (globalSum);
	}
	
	@Override
	public void	run() {
		this.localSum = sum(this.arrStart, this.arrEnd);
		synchronized (lock) {
			while (globalIndex != this.localIndex) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					System.err.println(e);
				}
			}
			System.out.printf("Thread %d: from %d to %d sum is %d\n", this.localIndex + 1, this.arrStart, this.arrEnd, this.localSum);
			globalSum += this.localSum;
			globalIndex++;
			lock.notifyAll();
		}
	}
	
	public static long	sum(int start, int end) {
		long	sum = 0;

		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		return (sum);
	}
}
