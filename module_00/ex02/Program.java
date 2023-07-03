import java.util.Scanner;

class Program {
	static int	sumDigitsNumber(int num) {
        short   result;
        byte    i;

        result = 0;
        i = 0;
        while (i < 6) {
            result += num % 10;
            num = (num - num % 10) / 10;
            i++;
        }
		return (result);
	}

    static int  isPrime(int num) {
        int i;

        i = 2;
        while ((i * i) <= num) {
            if (num % i == 0) {
                return (1);
            }
            i++;
        }
        return (0);
    }
    public static void main(String[] args) {
        int num;
		int sum;
        int count;

        Scanner getNum = new Scanner(System.in);
		num = 0;
		count = 0;
        while (num != 42) {
			System.out.print("Insert number: ");
			num = getNum.nextInt();
			if (num <= 2) {
			    System.err.println("Input has to be a natural number > 1");
			    return ;
			}
			sum = sumDigitsNumber(num);
			if (isPrime(sum) == 0) {
				count++;
			}
        }
		System.out.print("Count of coffe-request - ");
		System.out.println(count);
    }
}
