import java.util.Scanner;


class Problem_2 {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=in.nextInt();
        }
        System.out.println(getAverage(array));
    }


    public static double getAverage(int[] list){
        double sum =0;
        for (int i = 0; i <list.length ; i++) {
            sum+=list[i];
        }
        return sum/list.length;
    }
}

