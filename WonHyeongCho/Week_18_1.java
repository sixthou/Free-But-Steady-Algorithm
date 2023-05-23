/**
 * 제공자: Programmers
 * 제목: 연속된 부분 수열의 합
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/178870
 * 난이도: Level 2
 * 풀이완료시간: 40
 * 설명: 슬라이딩 윈도우 방식으로 해결
 */
public class Week_18_1 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] sequence, int k) {
        int left = 0; // 부분 수열의 시작 인덱스
        int sum = 0; // 부분 수열의 합
        int minLength = Integer.MAX_VALUE; // 최소 길이
        int[] result = new int[2]; // 결과 배열 [시작 인덱스, 마지막 인덱스]

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            // 부분 수열의 합이 k보다 크다면, 왼쪽 인덱스를 이동하면서 합을 조정
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            // 부분 수열의 합이 k와 같고 길이가 더 짧다면 결과 업데이트
            if (sum == k && right - left + 1 < minLength) {
                minLength = right - left + 1;
                result[0] = left;
                result[1] = right;
            }
        }

        return result;
    }
}
