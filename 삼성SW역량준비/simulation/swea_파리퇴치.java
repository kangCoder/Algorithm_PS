package 삼성SW역량준비.simulation;

import java.io.*;
import java.util.*;

public class swea_파리퇴치 {

    static int N, M, ans;
    static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            area = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int max = 0;
                    for (int r = i; r < i + M; r++) {
                        for (int c = j; c < j + M; c++) {
                            max += area[r][c];
                        }
                    }
                    ans = Math.max(ans, max);
                }
            }

            bw.write("#" + tc + " " + ans + "\n");
        }

        bw.flush();
    }
}