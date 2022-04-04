import java.util.Scanner;

public class Problem_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int k =in.nextInt();
        System.out.println(binomialCoefficient(n,k));
    }
    private static int factorial(int n) {
        int res = 1;
        if (n == 1 || n == 0) {
            return res;
        }
        res = n * factorial(n-1);
        return res;
    }
    public static int binomialCoefficient(int n, int k){
        return factorial(n) / (factorial(k) * factorial(n-k));
    }

}