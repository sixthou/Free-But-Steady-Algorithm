import java.util.*;
import java.util.stream.*;
import java.io.*;


public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] param = sc.nextLine().split(" ");
        int N = Integer.parseInt(param[0]);
        int M = Integer.parseInt(param[1]);
        int[] standard = new int[101];

        int start = 0;
        for(int i =0 ; i < N ; i++){
            String[] input = sc.nextLine().split(" ");
            int length = Integer.parseInt(input[0]);
            int speed = Integer.parseInt(input[1]);
            for(int j = start+1 ; j <= start + length ; j++){
                standard[j] = speed;
            }
            start = start + length;
        }

        start = 0;
        int maxGap = 0;

        for(int i =0 ; i < M ; i++){
            String[] input = sc.nextLine().split(" ");
            int length = Integer.parseInt(input[0]);
            int speed = Integer.parseInt(input[1]);
            for(int j =start+1 ; j <= start + length ; j++){
                if(speed - standard[j] > maxGap){
                    maxGap = speed - standard[j];
                }
            }
            start = start + length;
        }

        System.out.println(maxGap);
    }


}
