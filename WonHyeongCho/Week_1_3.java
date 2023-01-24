import java.time.LocalDate;

/**
 * 제공자: Programers
 * 제목: 해당 요일 출력
 * URL:
 * 난이도: 1
 * 풀이완료시간: -
 * 성공여부: 성공
 * 설명: 2016년 a월 b일은 무슨 요일일까요?, 2016년 1월 1일은 금요일
 * 제한 조건
 * 2016년은 윤년입니다.
 * 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
 *
 */
public class Week_1_3 {
    public static void main(String[] args) {

        int a = 2;
        int b = 22;

        System.out.println(solution(a, b));
    }

    public static String solution(int a, int b) {

        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int dayOfYear = LocalDate.of(2016, a, b).getDayOfYear();

        return day[dayOfYear%7];
    }
}