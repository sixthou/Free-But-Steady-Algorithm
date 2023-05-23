import java.util.Arrays;

/**
 * 제공자: Programmers
 * 제목: 체육복
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * 난이도: Level 1
 * 풀이완료시간:
 * 설명: 
 */
public class Week_17_3 {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n, lost, reserve));
    }

    static int solution(int n, int[] lost, int[] reserve) {

        int[] students = new int[n];
        Arrays.fill(students, 1);

        for (int k : lost) {
            students[k-1]--;
        }

        for (int j : reserve) {
            students[j-1]++;
        }

        for(int i = 0; i < students.length; i++) {
            if(i == 0) {
                if(students[i+1] == 2) {
                    students[i] = 1;
                    students[i+1] = 1;
                }
            } else if (i == students.length - 1) {
                if(students[i-1] == 2) {
                    students[i] = 1;
                    students[i-1] = 1;
                }
            } else {
                if(students[i-1] == 2) {
                    students[i] = 1;
                    students[i-1] = 1;
                }
                else if(students[i+1] == 2) {
                    students[i] = 1;
                    students[i+1] = 1;
                }
            }
        }

        return (int)Arrays.stream(students).filter(student -> student != 0).count();
    }
}
