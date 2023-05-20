package 자료구조.priorityqueue;

import java.util.*;

public class pro_실패율 {

    //실패율이 높은 스테이지를 내림차순으로 정렬해서 반환
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Map<Integer, Integer> curStageMap = new HashMap<>(); //현재 해당 스테이지에 도전하고 있는 사용자의 수
        for (int i = 1; i <= N + 1; i++) {
            curStageMap.put(i, 0);
        }

        for (int i = 0; i < stages.length; i++) {
            curStageMap.put(stages[i], curStageMap.get(stages[i]) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        //실패율 = 현재 스테이지에 도달했으나 클리어 못한 사람 수 / 스테이지에 도달한 사람 수
        int successCount = curStageMap.get(N + 1);
        for (int i = N; i >= 1; i--) {
            successCount += curStageMap.get(i);
            double failRate = (double) curStageMap.get(i) / successCount;
            pq.offer(new Node(i, failRate));
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            answer[idx++] = n.stage;
        }

        return answer;
    }

    class Node implements Comparable<Node> {

        int stage;
        double failRate;

        public Node(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }

        public int compareTo(Node n) {
            if (this.failRate < n.failRate) {
                return 1;
            } else if (this.failRate > n.failRate) {
                return -1;
            } else {
                if (this.stage > n.stage) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}