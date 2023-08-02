package dfsbfs;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class boj_24480_알고리즘수업깊이우선탐색2 {

    static int N, M, R, sequence = 1;
    static List<ArrayList<Integer>> map;
    static int[] vInfo;
    static boolean[] visited;

    static void dfs(int start) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;
        vInfo[start] = sequence++;

        for (int i = 0; i < map.get(start).size(); i++) {
            dfs(map.get(start).get(i));
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
            list.sort(Comparator.reverseOrder());
        }

        dfs(R);

        IntStream.rangeClosed(1, N)
                .forEach(i -> System.out.println(vInfo[i]));
    }

}
