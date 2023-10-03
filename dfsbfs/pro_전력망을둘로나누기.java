package dfsbfs;

import java.util.*;

public class pro_전력망을둘로나누기 {

    private List<Integer>[] graph; //송전탑 연결 그래프

    //v1에 연결된 노드들을 탐색하며 전력망 세기. v2를 만나면 탐색 제외
    private int bfs(int v1, int v2, boolean[] visited) {
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        visited[v1] = true;
        q.offer(v1);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : graph[cur]) {
                if (!visited[nxt] && nxt != v2) {
                    cnt++;
                    visited[nxt] = true;
                    q.offer(nxt);
                }
            }
        }

        return cnt;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int[] wire : wires) {
            int network1 = bfs(wire[0], wire[1], new boolean[n + 1]);
            int network2 = bfs(wire[1], wire[0], new boolean[n + 1]);
            answer = Math.min(answer, Math.abs(network1 - network2));
        }

        return answer;
    }

}
