
class Program {
    public static void main(String[] args) {
        int     num;
        short   result;
        byte    i;

        num = 479598;
        result = 0;
        i = 0;
        while (i < 6) {
            result += num % 10;
            num = (num - num % 10) / 10;
            i++;
        }
        System.out.println(result);
    }
}
