import java.util.Scanner;

public class Problem_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        isPrime(n);
    }
    public static void isPrime(int n ) {
        int c = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                c++;
            }
        }
        if (c > 0) {
            System.out.println("Composite");
        } else {
            System.out.println("Prime");
        }
    }
}
