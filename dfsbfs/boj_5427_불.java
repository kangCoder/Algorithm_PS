package dfsbfs;

import java.util.*;
import java.io.*;

public class boj_5427_불 {

    static int w, h;
    static char[][] map;
    static Queue<Pos> q;
    static Queue<Fire> fires;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void extendFire() {
        int fireSize = fires.size();

        for (int i = 0; i < fireSize; i++) {
            Fire fire = fires.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = fire.x + dx[dir];
                int ny = fire.y + dy[dir];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '#') {
                    continue;
                }

                if (map[nx][ny] == '.' || map[nx][ny] == '@') {
                    map[nx][ny] = '*';
                    fires.offer(new Fire(nx, ny));
                }
            }
        }
    }

    static int bfs() {
        while (!q.isEmpty()) {
            extendFire();

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Pos cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        return cur.time + 1;
                    }

                    if (map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Pos(nx, ny, cur.time + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            q = new LinkedList<>();
            fires = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '@') {
                        q.offer(new Pos(i, j, 0));
                        visited[i][j] = true;
                    } else if (map[i][j] == '*') {
                        fires.offer(new Fire(i, j));
                    }
                }
            }

            int ans = bfs();
            if (ans == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans);
            }
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
    }

    static class Fire {

        int x, y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
