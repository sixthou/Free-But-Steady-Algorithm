import java.util.Arrays;

/**
 * 제공자: Programmers
 * 제목: H-INDEX
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * 난이도: Level 2
 */
public class Week_11_3 {

    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }

    static int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순으로 정렬

        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int count = n - i;
            if (citations[i] >= count) {
                h = count;
                break;
            }
        }

        return h;
    }
}
