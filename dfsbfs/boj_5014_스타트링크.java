package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014_스타트링크 {

    public static int U, D;
    public static int F, S, G;
    public static boolean[] visited;
    public static List<Integer>[] graph;

    //node: 현재 층, edge: +U또는 -D 인 그래프로 생각.
    public static void makeGraph() {
        for (int i = 1; i <= F; i++) {
            graph[i] = new ArrayList<>();
            if (i + U <= F) {
                graph[i].add(i + U);
            }
            if (i - D >= 1) {
                graph[i].add(i - D);
            }
        }
    }

    public static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] nxt = q.poll();
            if (nxt[0] == G) {
                return nxt[1];
            }

            for (int i = 0; i < graph[nxt[0]].size(); i++) {
                if (!visited[graph[nxt[0]].get(i)]) {
                    visited[graph[nxt[0]].get(i)] = true;
                    q.add(new int[]{graph[nxt[0]].get(i), nxt[1] + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new List[F + 1];
        visited = new boolean[F + 1];

        makeGraph();

        int ans = bfs(S);
        if (ans == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }
    }

}
