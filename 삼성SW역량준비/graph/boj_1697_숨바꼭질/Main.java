package 삼성SW역량준비.graph.boj_1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, K;
    public static int[] dist = new int[100002];

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (dist[K] == -1) {
            int cur = queue.poll();
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next > 100000 || next < 0) {
                    continue;
                }
                if (dist[next] != -1) {
                    continue;
                }
                dist[next] = dist[cur] + 1;
                queue.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1); //거리 초기화
        dist[N] = 0;

        bfs();
        System.out.println(dist[K]);
    }
}
