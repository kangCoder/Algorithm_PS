package 삼성SW역량준비.graph.boj_10026_적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static int normal = 0, redGreen = 0;
    public static char[][] grid;
    public static boolean[][] visited;

    public static void dfsByNormal(int r, int c, char color) {
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        if (r + 1 < N && c < N) {
            if (grid[r + 1][c] == color) {
                dfsByNormal(r + 1, c, color);
            }
        }
        if (r - 1 >= 0 && r - 1 < N && c < N) {
            if (grid[r - 1][c] == color) {
                dfsByNormal(r - 1, c, color);
            }
        }
        if (r < N && c + 1 < N) {
            if (grid[r][c + 1] == color) {
                dfsByNormal(r, c + 1, color);
            }
        }
        if (c - 1 >= 0 && r < N && c - 1 < N) {
            if (grid[r][c - 1] == color) {
                dfsByNormal(r, c - 1, color);
            }
        }
    }

    public static void dfsByRedGreed(int r, int c, int color) {
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        if (color == 'R' || color == 'G') {
            if (r + 1 < N && c < N) {
                if (grid[r + 1][c] == 'R' || grid[r + 1][c] == 'G') {
                    dfsByRedGreed(r + 1, c, color);
                }
            }
            if (r - 1 >= 0 && r - 1 < N && c < N) {
                if (grid[r - 1][c] == 'R' || grid[r - 1][c] == 'G') {
                    dfsByRedGreed(r - 1, c, color);
                }
            }
            if (r < N && c + 1 < N) {
                if (grid[r][c + 1] == 'R' || grid[r][c + 1] == 'G') {
                    dfsByRedGreed(r, c + 1, color);
                }
            }
            if (c - 1 >= 0 && r < N && c - 1 < N) {
                if (grid[r][c - 1] == 'R' || grid[r][c - 1] == 'G') {
                    dfsByRedGreed(r, c - 1, color);
                }
            }
        }
        if (color == 'B') {
            if (r + 1 < N && c < N) {
                if (grid[r + 1][c] == color) {
                    dfsByRedGreed(r + 1, c, color);
                }
            }
            if (r - 1 >= 0 && r - 1 < N && c < N) {
                if (grid[r - 1][c] == color) {
                    dfsByRedGreed(r - 1, c, color);
                }
            }
            if (r < N && c + 1 < N) {
                if (grid[r][c + 1] == color) {
                    dfsByRedGreed(r, c + 1, color);
                }
            }
            if (c - 1 >= 0 && r < N && c - 1 < N) {
                if (grid[r][c - 1] == color) {
                    dfsByRedGreed(r, c - 1, color);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                grid[i][j] = s[j].charAt(0);
            }
        }

        //일반 사람
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'R' && !visited[i][j]) {
                    dfsByNormal(i, j, grid[i][j]);
                    normal++;
                }
                if (grid[i][j] == 'G' && !visited[i][j]) {
                    dfsByNormal(i, j, grid[i][j]);
                    normal++;
                }
                if (grid[i][j] == 'B' && !visited[i][j]) {
                    dfsByNormal(i, j, grid[i][j]);
                    normal++;
                }
            }
        }

        //적록색약
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((grid[i][j] == 'R' || grid[i][j] == 'G') && !visited[i][j]) {
                    dfsByRedGreed(i, j, grid[i][j]);
                    redGreen++;
                }
                if (grid[i][j] == 'B' && !visited[i][j]) {
                    dfsByRedGreed(i, j, grid[i][j]);
                    redGreen++;
                }
            }
        }

        System.out.println(normal + " " + redGreen);
    }

}
