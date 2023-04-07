package 삼성SW역량준비.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502_연구소 {

    static int N, M, ans = Integer.MIN_VALUE;
    static int[][] map;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static int countSafeArea(int[][] tmp) {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = node.x + dx[dir];
                int ny = node.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        ans = Math.max(ans, countSafeArea(tmp));
    }

    static void buildWall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);

        System.out.println(ans);
    }

    static class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
