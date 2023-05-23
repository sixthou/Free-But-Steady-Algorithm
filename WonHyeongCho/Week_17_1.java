/**
 * 제공자: Programmers
 * 제목: 문자열 나누기
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/76503
 * 난이도: Level 3
 * 풀이완료시간:
 * 설명: 레벨 3 문제는 너무나 어렵다..
 */
public class Week_17_1 {

    public static void main(String[] args) {

    }

//    public long solution(int[] a, int[][] edges) {
//        long answer = 0;
//
//        if(Arrays.stream(a).allMatch(w -> w == 0)) return 0;
//
//        if(Arrays.stream(a).sum() != 0) return -1;
//
//        Arrays.stream(a).map(w -> Math.abs(w)).sum();
//
//        List<Node> nodeList = new ArrayList<>();
//        int sum = 0;
//
//        for(int i = 0; i < a.length; i++) {
//            sum += a[i];
//            nodeList.add(new Node(i, a[i]));
//            if(sum != 0) return -1;
//        }
//
//        int[][] graph = new int[a.length][a.length];
//
//        for (int[] edge : edges) {
//            int first = edge[0];
//            int second = edge[1];
//
//            graph[first][second] = 1;
//            graph[second][first] = 1;
//        }
//
//        for(int i = 0; i < nodeList.size(); i++) {
//            Node node = nodeList.get(i);
//
//            if(node.weight == 0) continue;
//
//            for(int j = 0; j < graph[i].length; j++) {
//                if(graph[i][j] == 1) {
//
//                    node.weight = 0;
//                }
//            }
//
//
//                }
//            }
//
//        }
//
//    }
//
//    static class Node {
//
//        int index;
//        int weight;
//
//        Node(int index, int weight) {
//            this.index = index;
//            this.weight = weight;
//        }
//    }
}
