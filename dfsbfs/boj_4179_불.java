package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4179_불 {

    static int R, C, ans = -1;
    static char[][] map;
    static boolean[][] visited;

    static Queue<Pos> queue = new LinkedList<>();
    static Queue<Pos> fire = new LinkedList<>();

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void extendFire() {
        int size = fire.size();
        for (int i = 0; i < size; i++) {
            Pos curFire = fire.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = curFire.x + dx[dir];
                int ny = curFire.y + dy[dir];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#') {
                    continue;
                }

                if (map[nx][ny] == '.') {
                    map[nx][ny] = 'F';
                    fire.add(new Pos(nx, ny));
                }
            }
        }
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            extendFire();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos cur = queue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        return cur.time + 1;
                    }

                    if (map[nx][ny] == '.' && !visited[nx][ny]) {
                        queue.add(new Pos(nx, ny, cur.time + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'J') {
                    queue.add(new Pos(i, j, 0));
                    visited[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fire.add(new Pos(i, j));
                }
            }
        }

        ans = bfs();

        if (ans == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans);
        }
    }

    static class Pos {

        int x, y;
        int time;

        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}