import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 제공자: Programmers
 * 제목: 길 찾기 게임
 * URL: https://programmers.co.kr/skill_checks/485511
 * 난이도: Level 3
 * 풀이완료시간: 70분
 * 설명: 80분에 Level 3 두 문제를 풀어야 하는데 1문제에 70분이 걸렸다...
 *      너무 어려운것...
 *      오랜만에 트리, 이진트리를 직접 구현(물론 완벽한 구현은 아니고 문제에 맞춘 특정 상황이었지만) 해서 재밌었다.
 *      이진 트리 구현해서 단순이 전위, 후위 순외 해주면된다!
 *      카카오 문제인듯!
 */
public class Week_15_1 {

    public static void main(String[] args){
        int[][] nodeinfo = {
                {5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}
        };

        int[][] answers = solution(nodeinfo);

        for(int[] answer : answers) {
            System.out.println(Arrays.toString(answer));
        }
    }

    static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        List<BiNode> nodeList = new ArrayList<>();

        for(int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new BiNode(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }

        nodeList.sort((o1, o2) -> o2.y - o1.y);

        nodeList.forEach(node -> System.out.println("(" + node.x + ", " + node.y + ") " + node.index));

        BiTree biTree = new BiTree(new BiNode(nodeList.get(0).x, nodeList.get(0).y, nodeList.get(0).index));

        for(int i = 1; i < nodeList.size(); i++) {
            BiNode node = nodeList.get(i);
            biTree.add(new BiNode(node.x, node.y, node.index));
        }

        biTree.preOrder(biTree.root);
        biTree.postOrder(biTree.root);

        answer[0] = biTree.preOrderList.stream().mapToInt(i -> i).toArray();
        answer[1] = biTree.postOrderList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    static class BiNode {
        int x;
        int y;
        int index;
        BiNode left;
        BiNode right;

        BiNode(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    static class BiTree {

        BiNode root;
        ArrayList<Integer> preOrderList;
        ArrayList<Integer> postOrderList;

        BiTree(BiNode root) {
            this.root = root;
            preOrderList = new ArrayList<>();
            postOrderList = new ArrayList<>();
        }

        void add(BiNode node) {
            BiNode current = root;

            while(true) {
                if(root.y < node.y) {
                    if(root.x < node.x) {
                        node.left = root;
                    } else {
                        node.right = root;
                    }
                    root = node;
                    break;
                }

                if(node.x < current.x) {
                    if(current.left == null) {
                        current.left = node;
                        break;
                    }
                    else {
                        current = current.left;
                    }
                }
                else {
                    if(current.right == null) {
                        current.right = node;
                        break;
                    }
                    else {
                        current = current.right;
                    }
                }
            }
        }

        void preOrder(BiNode node) {
            if(node == null) return;
            preOrderList.add(node.index);
//            System.out.print(node.index + ", " + "(" + node.x + ", " + node.y + ") | ");
            preOrder(node.left);
            preOrder(node.right);
        }

        void postOrder(BiNode node) {
            if(node == null) return;
            postOrder(node.left);
            postOrder(node.right);
//            System.out.print(node.index + ", " + "(" + node.x + ", " + node.y + ") | ");
            postOrderList.add(node.index);
        }
    }
}
