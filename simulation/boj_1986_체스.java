package simulation;

import java.util.*;
import java.io.*;

public class boj_1986_체스 {

    static int n, m, ans = 0;

    static int[][] Q, K, P;
    static char[][] chess;

    static boolean isRanged(int r, int c) {
        return r <= n && r >= 1 && c <= m && c >= 1;
    }

    static void checkQueen(int r, int c) {
        int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};

        for (int dir = 0; dir < 8; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            while (isRanged(nr, nc)) {
                //장애물(Q, K, P)인 경우는 나아갈 수 없음
                if (chess[nr][nc] != 'Q' && chess[nr][nc] != 'K' && chess[nr][nc] != 'P') {
                    chess[nr][nc] = 'X';
                    nr += dr[dir];
                    nc += dc[dir];
                } else {
                    break;
                }
            }
        }
    }

    static void checkKnight(int r, int c) {
        int[] dr = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = {1, -1, 2, -2, 2, -2, 1, -1};

        for (int dir = 0; dir < 8; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (isRanged(nr, nc)) {
                if (chess[nr][nc] == 'O') {
                    chess[nr][nc] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chess = new char[n + 1][m + 1]; //1: 말들의 위치, 2: 움직일 수 있는 칸
        for (char[] c : chess) {
            Arrays.fill(c, 'O');
        }

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        Q = new int[size][2];
        if (size > 0) {
            for (int i = 0; i < Q.length; i++) {
                Q[i][0] = Integer.parseInt(st.nextToken());
                Q[i][1] = Integer.parseInt(st.nextToken());
                chess[Q[i][0]][Q[i][1]] = 'Q';
            }
        }

        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        K = new int[size][2];
        if (size > 0) {
            for (int i = 0; i < K.length; i++) {
                K[i][0] = Integer.parseInt(st.nextToken());
                K[i][1] = Integer.parseInt(st.nextToken());
                chess[K[i][0]][K[i][1]] = 'K';
            }
        }

        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        P = new int[size][2];
        if (size > 0) {
            for (int i = 0; i < P.length; i++) {
                P[i][0] = Integer.parseInt(st.nextToken());
                P[i][1] = Integer.parseInt(st.nextToken());
                chess[P[i][0]][P[i][1]] = 'P';
            }
        }

        for (int[] q : Q) {
            checkQueen(q[0], q[1]);
        }
        for (int[] k : K) {
            checkKnight(k[0], k[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (chess[i][j] == 'O') {
                    ans++;
                }
            }

        }
        System.out.println(ans);
    }
}
