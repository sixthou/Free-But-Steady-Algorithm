package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_17686 {

    /**
     * 제공자 : 프로그래머스
     * 제목 : [3차] 파일명 정렬
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/17686
     * 난이도 : 2
     * 유형 : 구현
     * 설명 : 정규식을 제대로 알지 못해서 어렵게 풀었다. 기본적인 정규식 작성법을 알고 Comparable 사용법에 대해서도 다시 한번 알아봐야 할듯
     * 예외 :
     **/

    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .map(FileName::new)
                .sorted()
                .map(FileName::toString)
                .collect(Collectors.toList())
                .toArray(new String[files.length]);
    }

    public class FileName implements Comparable {
        private final String head;
        private final String number;
        private final String original;

        public FileName(String fileName) {
            head = fileName.substring(0, fileName.indexOf(fileName.replaceAll("[^0-9]", "").substring(0, 1)));
            number = Arrays.stream(fileName.split("[^0-9]")).filter(s -> !s.equals("")).findFirst().get();
            original = fileName;
        }

        @Override
        public String toString() {
            return original;
        }

        @Override
        public int compareTo(Object o) {
            FileName other = (FileName) o;
            if (this.head.toUpperCase().compareTo(other.head.toUpperCase()) == 0) {
                    return Integer.parseInt(this.number) - Integer.parseInt(other.number);
            } else {
                return this.head.toUpperCase().compareTo(other.head.toUpperCase());
            }
        }
    }


    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String[] files, String[] expect) {
        Assertions.assertThat(solution(files)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
                        new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}),
                Arguments.of(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"},
                        new String[]{"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"})
        );
    }

}
