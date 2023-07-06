
class Program {
    public static void main(String[] args) {
        int     num;
        short   result;

        num = 479598;
        result = 0;
		result += num % 10;
		num = (num - num % 10) / 10;
		result += num % 10;
		num = (num - num % 10) / 10;
		result += num % 10;
		num = (num - num % 10) / 10;
		result += num % 10;
		num = (num - num % 10) / 10;
		result += num % 10;
		num = (num - num % 10) / 10;
		result += num % 10;
		num = (num - num % 10) / 10;
        System.out.println(result);
    }
}
