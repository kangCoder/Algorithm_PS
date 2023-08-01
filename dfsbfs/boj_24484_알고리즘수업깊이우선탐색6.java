package dfsbfs;

import java.util.*;
import java.io.*;

public class boj_24484_알고리즘수업깊이우선탐색6 {

    static int N, M, R, visitNum = 1;
    static long ans = 0L;
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;

    static void dfs(int start, int depth) {
        visited[start] = true;
        ans += (long) depth * visitNum++;
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visited[graph.get(start).get(i)]) {
                dfs(graph.get(start).get(i), depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (ArrayList<Integer> list : graph) {
            list.sort(Collections.reverseOrder());
        }

        dfs(R, 0);
        System.out.println(ans);
    }

}
