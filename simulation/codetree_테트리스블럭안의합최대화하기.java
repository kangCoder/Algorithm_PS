package simulation;

import java.util.*;
import java.io.*;

public class codetree_테트리스블럭안의합최대화하기 {

    static int n, m, ans = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    //현재 위치를 기준으로 4칸 움직여서 모양을 만들었을 때, 최대합
    static void getMaxSum(int cnt, int sum, int x, int y) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                getMaxSum(cnt + 1, sum + map[nx][ny], nx, ny);
                visited[nx][ny] = false;
            }
        }
    }

    //중간에 꺾이는 모양의 합을 구하기 위함.
    static void checkSum(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int sum = map[x][y];
            for (int dir = 0; dir < 4; dir++) {
                if (i == dir) {
                    continue;
                }

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    sum += map[nx][ny];
                }
            }

            ans = Math.max(ans, sum);
        }
    }

    static void visitedClear() {
        for (boolean[] visit : visited) {
            Arrays.fill(visit, false);
        }
    }

    static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checkSum(i, j);
                visited[i][j] = true;
                getMaxSum(1, map[i][j], i, j);
                visitedClear();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(ans);
    }

}
