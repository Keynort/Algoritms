import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int list[] = new int[n];
        for (int i = 0; i <n ; i++) {
            list[i]=in.nextInt();
        }
        int min=list[0];
        for (int i = 0; i <n ; i++) {
            if(min>list[i]){
                min=list[i];
            }
        }
        System.out.println(min);
    }
}
