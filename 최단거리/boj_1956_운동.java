package 최단거리;

import java.util.*;
import java.io.*;

public class boj_1956_운동 {

    static final int INF = 1_000_000_000;

    static int V, E;
    static int[][] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        road = new int[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            road[a][b] = c;
        }

        //i -> j 경로가 없는 경우에 대한 설정
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (road[i][j] == 0) {
                    road[i][j] = INF;
                }
            }
        }

        //플로이드-와샬 알고리즘으로 각 노드까지의 최단 거리 구하기
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (road[i][j] > road[i][k] + road[k][j]) {
                        road[i][j] = road[i][k] + road[k][j];
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (road[i][j] != INF && road[j][i] != INF) {
                    ans = Math.min(ans, road[i][j] + road[j][i]);
                }
            }
        }

        if (ans == INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
