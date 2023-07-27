package dfsbfs;

import java.util.*;
import java.io.*;

public class boj_2210_숫자판점프 {

    static int[][] plate = new int[5][5];
    static Set<String> ans = new HashSet<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void dfs(int x, int y, int length, String digit) {
        if (length > 6) {
            ans.add(digit);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                continue;
            }

            dfs(nx, ny, length + 1, digit + plate[nx][ny]);
        }
    }

    static int solve() {
        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[i].length; j++) {
                dfs(i, j, 1, "");
            }
        }

        return ans.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

}