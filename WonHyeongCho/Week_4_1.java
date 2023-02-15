import java.util.*;

/**
 * 제공자: 백준
 * 제목: 일곱 난쟁이
 * URL: https://www.acmicpc.net/problem/2309
 * 난이도: 브론즈 1
 * 풀이완료시간: /30
 * 성공여부: 성공
 * 설명: loop labeling 이란게 있었다니??? 처음 써봤다... 이걸 쓰는게 좋은걸까?
 * 예외:
 */
public class Week_4_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> dwarfs = new ArrayList<>(9);

        for(int i = 0; i < 9; i++) {
            dwarfs.add(scanner.nextInt());
        }

        int remain = dwarfs.stream().mapToInt(Integer::intValue).sum() - 100;
        Integer fakeDwarf1;
        Integer fakeDwarf2;

        loop:
        for(int i = 0; i < dwarfs.size(); i++) {
            fakeDwarf1 = dwarfs.get(i);

            for(int j = i+1; j < dwarfs.size(); j++) {
                fakeDwarf2 = dwarfs.get(j);

                if(fakeDwarf1 + fakeDwarf2 == remain) {
                    dwarfs.remove(fakeDwarf1);
                    dwarfs.remove(fakeDwarf2);
                    break loop;
                }
            }
        }

        Collections.sort(dwarfs);

        dwarfs.forEach(System.out::println);
    }
}
