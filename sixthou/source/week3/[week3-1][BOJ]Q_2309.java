package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q_2309 {
    /**
     * 제공자 : 백준
     * 제목 : 일곱난장이
     * URL : https://www.acmicpc.net/problem/2309
     * 난이도 : 브론즈2
     * 설명 :
     * 예외 :
     **/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(sc.nextLine()));
        }

        solution(list);

        list.forEach(System.out::println);

    }

    public static ArrayList<Integer> solution(ArrayList<Integer> param) {
        Collections.sort(param);
        int sum = param.stream().reduce(0, Integer::sum);
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - param.get(i) - param.get(j) == 100) {
                    param.remove(j);
                    param.remove(i);
                    return param;
                }
            }
        }
        return null;
    }


}
