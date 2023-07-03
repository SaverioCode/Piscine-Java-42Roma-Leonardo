
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
                // System.out.print("false ");
                // System.out.println(i - 1);
				System.out.printf("flase %d\n", i - 1);
                System.exit(0);
            }
			i++;
        }
		// System.out.printf("true %d\n", i - 2);
        // System.out.print("true ");
        System.out.println(i - 2);
    }    
}
