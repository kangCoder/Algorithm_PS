package dp;

import java.util.*;
import java.io.*;

public class boj_4095_최대정사각형 {

    static int N, M, ans;
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            square = new int[N][M];
            boolean canSquare = false;
            for (int i = 0; i < square.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < square[i].length; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                    if (square[i][j] == 1) {
                        canSquare = true;
                    }
                }
            }

            //현재 위치(i, j)가 1일 때
            //왼위대각선(i-1, j-1), 왼(i, j-1), 위(i-1, j) 값 중 최솟값에 + 1
            ans = canSquare ? 1 : 0;
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < M; j++) {
                    if (square[i][j] == 1) {
                        square[i][j] = Math.min(square[i - 1][j - 1], Math.min(square[i - 1][j], square[i][j - 1])) + 1;
                        ans = Math.max(ans, square[i][j]);
                    }
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
    }
}
