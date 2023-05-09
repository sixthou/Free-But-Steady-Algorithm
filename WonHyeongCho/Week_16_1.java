import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/**
 * 제공자: Programmers
 * 제목: 주차 요금 계산
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * 난이도: Level 2
 * 풀이완료시간:
 * 설명: 힘들다...
 */
public class Week_16_1 {

    public static void main(String[] args) {
//        int[] fees = {1, 5000, 1439, 600};
//        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        String[] records = {"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"};
//        String[] records = {"05:00 5961 IN", "05:01 5961 OUT", "05:10 5961 IN", "23:00 5961 OUT"};

        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3948 IN", "16:00 3948 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }

    // 제일 깔끔한듯
    static int timeToInt(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }

    static  int[] solution(int[] fees, String[] records) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for(String record : records) {
            String[] temp = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0;
        int[] ans = new int[map.size()];
        for(int time : map.values()) {
            if(time < 1) time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if(time > 0)
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }

//    static Map<String, Integer> parseMap;
//
//    static int[] solution(int[] fees, String[] records) {
//        // 출입시간을 기록하기 위한 map
//        Map<String, String> map = new HashMap<>();
//
//        parseMap = new TreeMap<>();
//
//        for (int i = 0; i < records.length; i++) {
//            String[] tempRecords = records[i].split(" ");
//            // 입차라면
//            if (tempRecords[2].equals("IN")) {
//                map.put(tempRecords[1], tempRecords[0]);
//                // 출차라면 입차시간, 출차시간, 차량번호를 parse에 넘김
//            } else {
//                parse(map.get(tempRecords[1]), tempRecords[0], tempRecords[1]);
//                map.remove(tempRecords[1]);
//            }
//        }
//
//        // map에 남아있는 차량이 있다면
//        if (!map.isEmpty()) {
//            for (String s : map.keySet()) {
//                parse(map.get(s), "23:59", s);
//            }
//        }
//
//        // 계산 메서드 호출
//        cul(fees);
//
//        // map에 value를 담아오기 위한 list
//        List<Integer> list = new ArrayList<>();
//        for (String key : parseMap.keySet()) {
//            list.add(parseMap.get(key));
//        }
//
//        // list를 array로 변환
//        int[] answer = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            answer[i] = list.get(i);
//        }
//
//        return answer;
//    }
//
//    // 총 주차 시간을 계산하기 위한 메서드
//    static void parse(String in, String out, String carNum) {
//        // 출차 시간을 분 단위로 변환
//        String[] outTemp = out.split(":");
//        int outMin = Integer.parseInt(outTemp[0]) * 60 + Integer.parseInt(outTemp[1]);
//        // 입차 시간을 분 단위로 변환
//        String[] inTemp = in.split(":");
//        int inMin = Integer.parseInt(inTemp[0]) * 60 + Integer.parseInt(inTemp[1]);
//        // 총 주차시간
//        int dif = outMin - inMin;
//        // 주차 시간 업데이트
//        parseMap.put(carNum, parseMap.getOrDefault(carNum, 0) + dif);
//    }
//
//    // 주차 요금을 계산하기 위한 메서드
//    static void cul(int[] fees) {
//        for (String key : parseMap.keySet()) {
//            // 주차시간이 기본 시간보다 작다면
//            if (parseMap.get(key) < fees[0]) {
//                parseMap.put(key, fees[1]);
//            } else {
//                // 주차시간에서 기본시간 빼기
//                double addTime = parseMap.get(key) - fees[0];
//                // 단위 시간으로 나누고 올림처리
//                addTime = Math.ceil(addTime / fees[2]);
//                // 총 요금
//                int result = (int) (addTime * fees[3] + fees[1]);
//                // 요금 map에 업데이트
//                parseMap.put(key, result);
//            }
//        }
//    }

    // 아래 코드는 예외 처리가 안된다... 왜일까?
//    static int[] solution(int[] fees, String[] records) {
//        Map<String, ParkingInfo> parkingInfoMap = new HashMap<>();
//
//        Set<String> remain = new HashSet<>();
//
//        for(String record : records) {
//            String[] recordArr = record.split(" ");
//            String time = recordArr[0];
//            String carNum = recordArr[1];
//            String inout = recordArr[2];
//
//            ParkingInfo parkingInfo = parkingInfoMap.get(carNum);
//
//            if(parkingInfo == null) {
//                parkingInfo = new ParkingInfo(carNum);
//                parkingInfoMap.put(carNum, parkingInfo);
//            }
//
//            if(inout.equals("IN")) {
//                parkingInfo.inTime = time;
//                remain.add(parkingInfo.carNum);
//            } else {
//                parkingInfo.calcTime(time);
//                remain.remove(parkingInfo.carNum);
//            }
//        }
//
//        for(String carNum : remain) {
//            ParkingInfo parkingInfo = parkingInfoMap.get(carNum);
//            parkingInfo.calcTime("23:59");
//        }
//
//        return calcFees(parkingInfoMap, fees);
//    }
//
//    static int[] calcFees(Map<String, ParkingInfo> parkingInfoMap, int[] fees) {
//
//        int stdTime = fees[0];
//        int stdFee = fees[1];
//        int addTime = fees[2];
//        int addFee = fees[3];
//
//        PriorityQueue<ParkingInfo> priorityQueue = new PriorityQueue<>();
//
//        for(ParkingInfo parkingInfo : parkingInfoMap.values()) {
//
//            if(parkingInfo.accumTime <= stdTime) {
//                parkingInfo.fee = stdFee;
//            } else {
//                int time = parkingInfo.accumTime - stdTime;
//                int addFeeTime = (int) Math.ceil((double) time / (double) addTime);
//                parkingInfo.fee = stdFee + addFeeTime * addFee;
//            }
//
//            priorityQueue.add(parkingInfo);
//        }
//
//        return priorityQueue.stream().mapToInt(parkingInfo -> parkingInfo.fee).toArray();
//    }
//
//    static class ParkingInfo implements Comparable<ParkingInfo> {
//        String carNum;
//        String inTime;
//        int accumTime;
//        int fee;
//
//        ParkingInfo(String carNum) {
//            this.carNum = carNum;
//        }
//
//        void calcTime(String outTime) {
//            LocalTime in = LocalTime.parse(inTime);
//            LocalTime out = LocalTime.parse(outTime);
//
//            accumTime += Duration.between(in, out).toMinutes();
//        }
//
//        @Override
//        public int compareTo(ParkingInfo o) {
//            return this.carNum.compareTo(o.carNum);
//        }
//    }
}
