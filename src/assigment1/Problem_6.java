package assigment1;

import java.util.Scanner;

public class Problem_6 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int n = in.nextInt();
        System.out.println(square(a,n));
    }
    public static int square(int a , int n){
        if(n == 1){
            return a;
        }
        return a * square(a, n-1);
    }
}