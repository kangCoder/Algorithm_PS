package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569_토마토 {

    static int N, M, H;
    static int day;
    static int[][][] box;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dy = {0, 0, -0, 0, -1, 1};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    public static boolean checkAllRipened() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int dir = 0; dir < 6; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                int nz = cur[2] + dz[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                    continue;
                }

                if (box[nz][nx][ny] == 0) {
                    box[nz][nx][ny] = box[cur[2]][cur[0]][cur[1]] + 1;
                    queue.add(new int[]{nx, ny, nz});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{j, k, i});
                    }
                }
            }
        }

        day = 0;

        if (checkAllRipened()) {
            System.out.println(0);
        } else {
            bfs();

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (box[i][j][k] > day) {
                            day = box[i][j][k];
                        }
                    }
                }
            }

            //안익은 토마토가 있으면 불가능한 것.
            if (!checkAllRipened()) {
                System.out.println(-1);
            } else {
                System.out.println(day - 1);
            }
        }
    }

}
