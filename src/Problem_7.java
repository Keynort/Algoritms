import java.util.Scanner;

public class Problem_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int [] list = new int [n];
        for (int i = 0; i < n; i++) {
            list[i]=in.nextInt();
        }
        int[] revArray=reverseArray(list,0,list.length-1);
        for(int i:revArray)
            System.out.print(i+" ");
    }
    public static int[] reverseArray(int[] a,int i,int j){
        if(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            reverseArray(a, i+1, j-1);
        }
        return a;
    }

}