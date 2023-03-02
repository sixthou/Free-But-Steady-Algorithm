import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 제공자: Programmers
 * 제목: 호텔 대실
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 난이도: 2
 * 풀이완료시간: 30/30
 * 성공여부: 실패
 * 설명:  LocalTime 을 사용해서 시간 비교, isAfter, isBefore는 == 을 포함하지 않는다. 예외찾기, 그리디 알고리즘
 * 예외:
 */

public class Week_6_2 {

    public static void main(String[] args) {

//        String[][] book_time = {{"15:00", "17:00"},
//                {"16:40", "18:20"},
//                {"14:20", "15:20"},
//                {"14:10", "19:20"},
//                {"14:10", "19:55"},
//                {"18:20", "21:20"}};

                String[][] book_time = {{"09:10", "10:10"},
                {"10:20", "12:20"},
                {"08:00", "09:00"},};


        System.out.println(solution(book_time));
    }

    private static int solution(String[][] book_time) {

        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room(book_time[0]));

        for(int i = 1; i < book_time.length; i++) {

            boolean flag = false;
            for(Room room : roomList) {
                if(room.isAvailable(book_time[i])) {
                    room.book(book_time[i]);
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                roomList.add(new Room(book_time[i]));
            }
        }

        return roomList.size();
    }

    static class Room {

        List<String[]> bookList;

        Room(String[] book) {
            bookList = new ArrayList<>();
            bookList.add(book);
        }

        void book(String[] book) {
            bookList.add(book);
        }

        boolean isAvailable(String[] book) {

            for(String[] booked: bookList) {
                LocalTime bookStartTime = LocalTime.parse(book[0]);
                LocalTime bookEndTime = LocalTime.parse(book[1]).plusMinutes(10);

                System.out.println("book offer: " + bookStartTime.toString() + "->" + bookEndTime.toString());

                LocalTime bookedStartTime = LocalTime.parse(booked[0]);
                LocalTime bookedEndTime = LocalTime.parse(booked[1]).plusMinutes(10);

                System.out.println("booked offer: " + bookedStartTime.toString() + "->" + bookedEndTime.toString());

                if(bookStartTime.isBefore(bookedStartTime)) {
                    if(bookEndTime.isBefore(bookedStartTime) || bookEndTime.equals(bookedStartTime)) break;
                    else return false;
                }
                else {
                    if (bookStartTime.isBefore(bookedEndTime)) return false;
                }
            }

            return true;
        }
    }
}


