package dfsbfs;

import java.util.*;
import java.io.*;

public class boj_1189_컴백홈 {

    static int R, C, K, ans = 0;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static char[][] map;
    static boolean[][] visited;

    static void dfs(int sR, int sC, int eR, int eC, int cnt) {
        if (sR == eR && sC == eC && cnt == K) {
            ans++;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = sR + dr[dir];
            int nc = sC + dc[dir];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
                if (map[nr][nc] != 'T') {
                    visited[nr][nc] = true;
                    dfs(nr, nc, eR, eC, cnt + 1);
                    visited[nr][nc] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        map = new char[R][C];
        for (int i = 0; i < map.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 0, C - 1, 1);

        System.out.println(ans);
    }
}
