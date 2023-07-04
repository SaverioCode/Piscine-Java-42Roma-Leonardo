
import  java.util.Scanner;

class Program {
    public static void main(String[] args) {
        int num;
        int i;

        Scanner getNum = new Scanner(System.in);
        System.out.print("Insert a number: ");
        num = getNum.nextInt();
        if (num < 2) {
            System.err.println("Illegal argument");
            System.exit(-1);
        }
        i = 2;
        while ((i * i) <= num) {
            if (num % i == 0) {
				System.out.printf("false %d\n", i - 1);
                System.exit(0);
            }
			i++;
        }
		getNum.close();
		System.out.printf("true %d\n", i - 2);
    }    
}
