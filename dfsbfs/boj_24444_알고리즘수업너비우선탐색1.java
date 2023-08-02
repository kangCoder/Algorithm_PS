package dfsbfs;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class boj_24444_알고리즘수업너비우선탐색1 {

    static int N, M, R, sequence = 1;
    static List<ArrayList<Integer>> map;
    static int[] vInfo;
    static boolean[] visited;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            if (!visited[cur]) {
                visited[cur] = true;
                vInfo[cur] = sequence++;

                for (int i = 0; i < map.get(cur).size(); i++) {
                    q.offer(map.get(cur).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        vInfo = new int[N + 1];
        visited = new boolean[N + 1];
        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map.get(u).add(v);
            map.get(v).add(u);
        }

        for (ArrayList<Integer> list : map) {
            Collections.sort(list);
        }

        bfs(R);

        IntStream.rangeClosed(1, N)
                .forEach(i -> System.out.println(vInfo[i]));
    }

}
