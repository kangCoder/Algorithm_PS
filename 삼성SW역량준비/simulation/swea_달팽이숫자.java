package 삼성SW역량준비.simulation;

import java.io.*;

public class swea_달팽이숫자 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            int idx = 1, r = 0, c = 0;
            map[r][c] = idx++;
            while (idx <= N * N) {
                //-> 방향으로 진행
                while (c + 1 < N && map[r][c + 1] == 0) {
                    map[r][++c] = idx++;
                }

                //아래 방향으로 진행
                while (r + 1 < N && map[r + 1][c] == 0) {
                    map[++r][c] = idx++;
                }

                //<- 방향으로 진행
                while (c - 1 >= 0 && map[r][c - 1] == 0) {
                    map[r][--c] = idx++;
                }

                //위 방향으로 진행
                while (r - 1 >= 0 && map[r - 1][c] == 0) {
                    map[--r][c] = idx++;
                }
            }

            bw.write("#" + tc + "\n");
            for (int[] ma : map) {
                for (int m : ma) {
                    bw.write(m + " ");
                }
                bw.write("\n");
            }
        }

        bw.flush();
    }
}
