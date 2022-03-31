import java.util.Scanner;

public class Problem_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        System.out.println(square(n,a));
    }

    private static int square(int n,int a) {
        int result=1;
        if (n == 0) {
            return result;
        }
            result=n*square(n,a-1);
        return result;
    }
}