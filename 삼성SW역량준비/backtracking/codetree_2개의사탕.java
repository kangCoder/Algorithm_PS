package 삼성SW역량준비.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_2개의사탕 {

    static int N, M, ans;
    static char[][] map;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static boolean exist(char target) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canGo(int x, int y) {
        return map[x][y] == '.' || map[x][y] == 'O';
    }

    public static void move(int x, int y, int dir) {
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!canGo(nx, ny)) {
                break;
            }

            //이동할 곳이 출구라면 해당 사탕을 맵에서 지워주고 종료.
            if (map[nx][ny] == 'O') {
                map[x][y] = '.';
                break;
            }

            map[nx][ny] = map[x][y];
            map[x][y] = '.';
            x = nx;
            y = ny;
        }
    }

    //dir 0, 1, 2, 3 : 하, 상, 우, 좌
    public static void tilt(int dir) {
        //기울이는 방향이 위또는 왼쪽이라면, 방향을 좌상단에서 우하단으로 탐색하면 먼저 떨어질 사탕을 찾을 수 있다.
        if (dir == 1 || dir == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'R' || map[i][j] == 'B') {
                        move(i, j, dir);
                    }
                }
            }
        }

        //기울이는 방향이 아래또는 오른쪽이라면, 방향을 우하단에서 좌상단으로 탐색하면 먼저 떨어질 사탕을 찾을 수 있다.
        if (dir == 0 || dir == 2) {
            for (int i = N - 1; i >= 0; i--) {
                for (int j = M - 1; j >= 0; j--) {
                    if (map[i][j] == 'R' || map[i][j] == 'B') {
                        move(i, j, dir);
                    }
                }
            }
        }
    }

    public static void backTracking(int cnt) {
        if (!exist('B')) {
            return;
        }

        if (!exist('R')) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (cnt >= 10) {
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            char[][] tmp = new char[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tmp[i][j] = map[i][j];
                }
            }

            tilt(dir);
            backTracking(cnt + 1);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = tmp[i][j];
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 11;

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        backTracking(0);

        if (ans == 11) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

}
