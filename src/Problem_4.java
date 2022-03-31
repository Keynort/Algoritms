import java.util.Scanner;

public class Problem_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {

        int res = 1;
        if (n == 1 || n == 0) {
            return res;
        }
        res = n * factorial(n-1);
        return res;
    }
}