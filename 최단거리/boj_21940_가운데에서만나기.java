package 최단거리;

import java.util.*;
import java.io.*;

public class boj_21940_가운데에서만나기 {

    static final int INF = 987654321;
    static int N, M, K;
    static int[][] city;
    static int[] friends;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //정점 거리 초기화
        city = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(city[i], INF);
            city[i][i] = 0;
        }

        //A->B 거리 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            city[A][B] = T;
        }

        //플로이드-와샬로 각 정점에서 정점까지의 최단거리 미리 구해놓기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    city[j][k] = Math.min(city[j][k], city[j][i] + city[i][k]);
                }
            }
        }

        K = Integer.parseInt(br.readLine());
        friends = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        //각 정점에서 j번째 친구와의 왕복 최대 거리 구하기
        int[] maxDst = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int idx : friends) {
                maxDst[i] = Math.max(maxDst[i], city[i][idx] + city[idx][i]);
            }
        }

        //왕복거리가 최대인 정점 중 최소 구하기 (여러 개일 수 있음)
        int min = Integer.MAX_VALUE;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (min > maxDst[i]) {
                min = maxDst[i];
                ansList.clear();
                ansList.add(i);
            } else if (min == maxDst[i]) {
                ansList.add(i);
            }
        }

        for (Integer ans : ansList) {
            bw.write(ans + " ");
        }

        bw.flush();
    }
}
