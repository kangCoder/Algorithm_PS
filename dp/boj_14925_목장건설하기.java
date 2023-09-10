package dp;

import java.util.*;
import java.io.*;

public class boj_14925_목장건설하기 {

    static int M, N, L = 0;
    static int[][] map = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int g = Integer.parseInt(st.nextToken());
                //해당 땅에 나무나 돌이 없다면 -> 그 땅은 일단 1x1이 가능하다.
                if (g == 0) {
                    map[i][j] = 1; //기본적으로 1x1이 가능.

                    //현재 땅(i,j)을 우하단으로 하는 목장의 최대 크기는
                    //(i,j)의 대각선 위(i-1,j-1), 위(i-1,j), 왼쪽(i,j-1)을 우하단으로 하는 목장들 중 최소값 + 1
                    map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
                    L = Math.max(L, map[i][j]);
                }
            }
        }

        System.out.println(L);
    }
}
