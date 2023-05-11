/**
 * 제공자: Programmers
 * 제목: 피로도
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * 난이도: Level 2
 * 풀이완료시간:
 * 설명: 힘들다...
 */
public class Week_16_2 {

    public static void main(String[] args) {
        int k = 50;
        int[][] dungeons = {{10, 30}, {30, 5}, {100, 1}, {5, 5}};
        System.out.println(solution(k, dungeons));
    }

    static int answer = 0;
    static boolean[] visit;

    static int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    static void dfs(int depth, int k, int[][] dungeons) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }
}
