/**
 * 제공자: Programmers
 * 제목: 가장 긴 펠린드롬
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/12904
 * 난이도: Level 3
 * 풀이완료시간: 40분
 * 설명: 완전 탐색으로 풀어봤는데 효율성은 다 통과하는데 예외를 찾지 못해서 테스트케이스 1개가 통과하지 못했다.
 *      인터넷에 있는 코드로 작성... 보니 왜케 어렵게 풀었을까 나는??ㅠㅠ
 */
public class Week_12_3 {

    public static void main(String[] args) {
//        String s = "abcdcba";
//        String s= "abacde";
//        String s = "";
//        String s = "a";
//        String s = "aaaa";
//        String s = "abbba";
        String s = "ccbcc";
//        String s = "aaabaaaadaaaacccccdcccccaaaadaaaabaaa";
//        String s = "aamnasdpqnmpodndnaadsdddaba";
//        String s = "bbddccddccddbb";
//        String s = "abba";
//        String s = "eeeaaaaabbbbaaaaeeee";

        System.out.println(solution(s));
    }

    static int solution(String s) {

        for(int i = s.length(); i > 0; i--) {
            for(int j = 0; j+i <= s.length(); j++) {
                if(isPalindrome(s, j, j+i-1)) return i;
            }
        }

        return 0;
    }

    static boolean isPalindrome(String value, int start, int end) {
        while(start <= end) {
            if(value.charAt(start++) != value.charAt(end--)) return false;
        }
        return true;
    }

    // 예외를 찾지 못함... 시간복잡도도 너무 높다.
//    static int solution(String s) {
//        int answer = 1;
//
//        for(int i = 0; i < s.length(); i++) {
//
//            int startIndex = i;
//            int endIndex = s.length()-1;
//            int length = 0;
//            boolean start = false;
//
//            while (startIndex != endIndex) {
//                if(s.charAt(startIndex) == s.charAt(endIndex)) {
//                    if(!start) {
//                        start = true;
//                        length = endIndex - startIndex + 1;
//                    }
//
//                    startIndex++;
//
//                    if(startIndex == endIndex) {
//                        if(length%2 != 0) {
//                            start = false;
//                        }
//                        break;
//                    }
//
//                    endIndex--;
//                }
//                else {
//                    if(start) {
//                        break;
//                    }
//                    else {
//                        endIndex--;
//                    }
//                }
//            }
//
//            if(start && startIndex == endIndex) {
//                answer = Math.max(length, answer);
//            }
//        }
//
//        return answer;
//    }
}
