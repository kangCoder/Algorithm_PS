package 삼성SW역량준비.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_2048게임 {

    static int n, ans;
    static int[][] grid, tmp;
    static int[] moves;

    //90도 회전
    public static void rotate() {
        int[][] nextGrid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextGrid[i][j] = grid[n - j - 1][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    public static void drop() {
        int[][] nextGrid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextGrid[i][j] = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            int keep = -1;
            int nxtRow = n - 1;

            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == 0) {
                    continue;
                }

                if (keep == -1) {
                    keep = grid[i][j];
                } else if (keep == grid[i][j]) {
                    nextGrid[nxtRow--][j] = keep * 2;
                    keep = -1;
                } else {
                    nextGrid[nxtRow--][j] = keep;
                    keep = grid[i][j];
                }
            }

            if (keep != -1) {
                nextGrid[nxtRow--][j] = keep;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }

    }

    public static void tilt(int moveDir) {
        for (int i = 0; i < moveDir; i++) {
            rotate();
        }

        drop();

        //원상복구
        for (int i = 0; i < 4 - moveDir; i++) {
            rotate();
        }
    }

    public static void simulate() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            tilt(moves[i]);
        }

        ans = Math.max(ans, getMax());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = tmp[i][j];
            }
        }
    }

    public static int getMax() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }

    public static void searchMax(int cnt) {
        if (cnt == 5) {
            simulate();
            return;
        }

        for (int i = 0; i < 4; i++) {
            moves[cnt] = i;
            searchMax(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ans = 0;
        grid = new int[n][n];
        tmp = new int[n][n];
        moves = new int[5];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        searchMax(0);

        System.out.println(ans);
    }

}
