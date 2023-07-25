package dfsbfs;

import java.util.*;
import java.io.*;

public class boj_17836_공주님을구해라 {

    static int N, M, T, ans;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        if (map[0][0] == 2) {
            q.offer(new Pos(0, 0, 0, true));
            visited[0][0][0] = true;
        } else {
            q.offer(new Pos(0, 0, 0, false));
            visited[0][0][1] = true;
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.curTime > T) {
                continue;
            }
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.curTime;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (cur.isGetGram) {
                    if (!visited[nx][ny][1]) {
                        q.offer(new Pos(nx, ny, cur.curTime + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else {
                    if (!visited[nx][ny][0] && map[nx][ny] == 0) {
                        q.offer(new Pos(nx, ny, cur.curTime + 1, false));
                        visited[nx][ny][0] = true;
                    } else if (!visited[nx][ny][0] && map[nx][ny] == 2) {
                        q.offer(new Pos(nx, ny, cur.curTime + 1, true));
                        visited[nx][ny][0] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = bfs();
        if (ans == -1 || ans > T) {
            System.out.println("Fail");
        } else {
            System.out.println(ans);
        }

    }

    static class Pos {

        int x, y;
        int curTime;
        boolean isGetGram;

        public Pos(int x, int y, int curTime, boolean isGetGram) {
            this.x = x;
            this.y = y;
            this.curTime = curTime;
            this.isGetGram = isGetGram;
        }
    }

}
