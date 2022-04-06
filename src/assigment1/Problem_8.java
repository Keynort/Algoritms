package assigment1;

import java.util.Scanner;

public class Problem_8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        if(allDigits(a,0)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    public static boolean allDigits(String a , int i){
        char[] aa = a.toCharArray();
        if(i >= a.length()) {
            return true;
        }
        else if(!Character.isDigit(aa[i])) {
            return false;
        }
                return allDigits(a, i+1);

    }

}