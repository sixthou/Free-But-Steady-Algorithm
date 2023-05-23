package programmers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Q_17683 {
    /**
     * 제공자 : 프로그래머스 - 2018 KAKAO BLIND RECRUITMENT
     * 제목 : [3차] 방금그곡
     * URL : https://school.programmers.co.kr/learn/courses/30/lessons/17683
     * 난이도 : 2
     * 유형 : 문자열
     * 설명 :
     * 예외 :
     **/

    public String solution(String m, String[] musicinfos) {
        List<Music> musics = new ArrayList<>();

        int idx = 0;
        for (String musicinfo : musicinfos) {
            String[] token = musicinfo.split(",");
            musics.add(new Music(token[0], token[1], token[2], token[3], idx++));
        }
        String replacedNote = noteReplacer(m);

        return musics.stream()
                .filter(i -> i.isMatch(replacedNote))
                .sorted()
                .findFirst()
                .orElse(new Music("00:00", "00:00","(None)", "", Integer.MAX_VALUE))
                .getName();
    }

    private static class Music implements Comparable<Music> {


        private final String name;
        private final String note;
        private final int duration;
        private final int index;

        public Music(String start, String end, String name, String note, int index) {
            this.name = name;
            this.duration = (LocalTime.parse(end).toSecondOfDay() - LocalTime.parse(start).toSecondOfDay()) / 60;
            this.note = durationNote(noteReplacer(note));
            this.index = index;
        }

        boolean isMatch(String note) {
            return this.note.contains(note);
        }

        public String getName() {
            return name;
        }

        private String durationNote(String note) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < duration; i++) {
                sb.append(note.charAt(i % note.length()));
            }
            return sb.toString();
        }


        @Override
        public int compareTo(Music o) {
            if(this.duration == o.duration){
                return this.index - o.index;
            }else{
                return o.duration - this.duration;
            }
        }
    }

    private static String noteReplacer(String note) {
        return note.replaceAll("(C#)", "H")
                .replaceAll("(D#)", "I")
                .replaceAll("(F#)", "J")
                .replaceAll("(G#)", "K")
                .replaceAll("(A#)", "L");
    }

    @MethodSource("testcase")
    @ParameterizedTest
    void test_solution(String m, String[] musicinfos, String expect) {
        Assertions.assertThat(solution(m, musicinfos)).isEqualTo(expect);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                Arguments.of("ABCDEFG", new String[]{"12:00,12:14,HELLO1,CDEFGAB", "12:00,12:15,HELLO2,CDEFGAB", "12:00,12:15,HELLO3,CDEFGAB"},	"HELLO2"),
                Arguments.of("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"},	"FOO"),
                Arguments.of("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}, "WORLD")
        );
    }

    @Test
    void name() {
        System.out.println("CDEFGABCDEFGAB".contains("ABCDEFG"));
    }


    private String durationNote(int duration, String note) {
        StringBuilder temp = new StringBuilder();
        while (temp.length() < duration) {
            temp.append(note);
        }
        if (temp.length() > duration) {
            temp.delete(duration, temp.length());
        }
        return temp.toString();
    }

}
