package simulation;

import java.io.*;
import java.util.*;

public class boj_3010_페그 {

    static int ans = 0;
    static int[] dr = {1, -1, 0, 0}; //하, 상, 우, 좌
    static int[] dc = {0, 0, 1, -1};
    static char[][] peg = new char[7][7];
    static Queue<int[]> q = new LinkedList<>(); //.를 담는 큐

    static boolean isRange(int r, int c) {
        return r >= 0 && r < 7 && c >= 0 && c < 7;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 7; i++) {
            String s = br.readLine();
            for (int j = 0; j < 7; j++) {
                peg[i][j] = s.charAt(j);
                if (peg[i][j] == '.') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur[0] + dr[dir], nc = cur[1] + dc[dir];

                if (isRange(nr, nc) && peg[nr][nc] == 'o') {
                    nr += dr[dir];
                    nc += dc[dir];

                    if (isRange(nr, nc) && peg[nr][nc] == 'o') {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
