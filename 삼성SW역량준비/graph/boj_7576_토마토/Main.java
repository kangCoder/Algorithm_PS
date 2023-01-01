package 삼성SW역량준비.graph.boj_7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] farm;
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};
    public static Queue<Node> queue = new LinkedList<>();

    static boolean canRipened() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (farm[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextR = cur.r + dy[dir];
                int nextC = cur.c + dx[dir];
                if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
                    if (farm[nextR][nextC] == 0) {
                        farm[nextR][nextC] = farm[cur.r][cur.c] + 1; //다음 위치가 며칠 쨰에 익는지 업데이트
                        queue.add(new Node(nextR, nextC));
                    }
                }
            }
        }

        if (!canRipened()) {
            return -1;
        } else {
            int day = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (day < farm[i][j]) {
                        day = farm[i][j];
                    }
                }
            }
            return day - 1; //시작이 1로 시작하기 때문에 마지막에 -1을 해줘야 한다
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        farm = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
                if (farm[i][j] == 1) {
                    queue.add(new Node(i, j)); //익은 토마토의 위치를 큐에 넣어놓는다
                }
            }
        }

        System.out.println(bfs());
    }

    public static class Node {

        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
