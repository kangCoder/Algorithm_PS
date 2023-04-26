package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6593_상범빌딩 {

    static int L, R, C;
    static char[][][] building;
    static boolean[][][] visited;
    static Queue<Pos> queue;

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static int bfs() {
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int dir = 0; dir < 6; dir++) {
                int nl = cur.l + dz[dir];
                int nr = cur.r + dx[dir];
                int nc = cur.c + dy[dir];

                if (nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                }

                if (building[nl][nr][nc] == 'E') {
                    return cur.time + 1;
                }

                if (building[nl][nr][nc] == '.' && !visited[nl][nr][nc]) {
                    queue.add(new Pos(nl, nr, nc, cur.time + 1));
                    visited[nl][nr][nc] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            queue = new LinkedList<>();

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = s.charAt(k);
                        if (building[i][j][k] == 'S') {
                            queue.add(new Pos(i, j, k, 0));
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            int ans = bfs();
            if (ans == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + ans + " minute(s).");
            }
        }
    }

    static class Pos {

        int l, r, c;
        int time;

        public Pos(int l, int r, int c, int time) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

}