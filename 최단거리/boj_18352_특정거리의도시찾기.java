package 최단거리;

import java.util.*;
import java.io.*;

public class boj_18352_특정거리의도시찾기 {

    static int N, M, K, X;
    static List<ArrayList<Integer>> city;
    static int[] dist;

    private static void findRoute() {
        dist[X] = 0; //출발하는 곳은 거리가 0

        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < city.get(cur).size(); i++) {
                int nxt = city.get(cur).get(i);
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    q.offer(nxt);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];

        city = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
            dist[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            city.get(A).add(B);
        }

        findRoute();

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1) {
                flag = true;
                System.out.println(i);
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }

}
