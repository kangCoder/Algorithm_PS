package 삼성SW역량준비.graph.boj_1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int M, N, K;
    public static int[][] field;
    public static boolean[][] visited;
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nextR = row + dy[dir];
            int nextC = col + dx[dir];
            if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
                if (field[nextR][nextC] == 1 && !visited[nextR][nextC]) {
                    dfs(nextR, nextC);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            visited = new boolean[N][M];
            int earthWorm = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        earthWorm++;
                    }
                }
            }

            System.out.println(earthWorm);
        }
    }

}
