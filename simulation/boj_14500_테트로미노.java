package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14500_테트로미노 {

    public static int N, M, max;
    public static int[][] paper;
    public static boolean[][] visited;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};

    //dfs + 완전탐색
    public static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx]) {
                continue;
            }

            visited[ny][nx] = true;
            dfs(nx, ny, cnt + 1, sum + paper[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    public static void etcCheck(int x, int y) {
        //ㅗ
        if (y > 0 && x < M - 2) {
            max = Math.max(max, paper[y][x] + paper[y][x + 1] + paper[y][x + 2] + paper[y - 1][x + 1]);
        }
        //ㅜ
        if (y < N - 1 && x < M - 2) {
            max = Math.max(max, paper[y][x] + paper[y][x + 1] + paper[y][x + 2] + paper[y + 1][x + 1]);
        }
        //ㅏ
        if (y < N - 2 && x < M - 1) {
            max = Math.max(max, paper[y][x] + paper[y + 1][x] + paper[y + 2][x] + paper[y + 1][x + 1]);
        }
        //ㅓ
        if (y < N - 2 && x > 0) {
            max = Math.max(max, paper[y][x] + paper[y + 1][x] + paper[y + 2][x] + paper[y + 1][x - 1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(j, i, 1, paper[i][j]);
                visited[i][j] = false;
                etcCheck(j, i);
            }
        }

        System.out.println(max);
    }

}
