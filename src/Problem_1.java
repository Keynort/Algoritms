import java.util.Scanner;

class Problem_1 {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=in.nextInt();
        }
        System.out.println(getMin(array));
    }


    public static int getMin(int[] list){
        int minValue = list[0];
        for(int i=0;i<list.length;i++){
            if(list[i] < minValue){
                minValue = list[i];
            }
        }
        return minValue;
    }
}