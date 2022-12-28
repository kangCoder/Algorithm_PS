package 삼성SW역량준비.graph.boj_2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int N, number = 0;
    public static int[][] house;
    public static boolean[][] visited;
    public static int[] city = new int[625]; //만들어질 수 있는 최대 단지 수: 25*25 = 625
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void makeCityByDFS(int row, int col) {
        visited[row][col] = true;
        city[number]++;

        for (int dir = 0; dir < 4; dir++) {
            int nextRow = row + dy[dir];
            int nextCol = col + dx[dir];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N) {
                if (house[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    makeCityByDFS(nextRow, nextCol);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(s[j]);
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < house[i].length; j++) {
                if (house[i][j] == 1 && !visited[i][j]) {
                    makeCityByDFS(i, j);
                    number++;
                }
            }
        }

        System.out.println(number);
        Arrays.sort(city);
        for (int c : city) {
            if (c != 0) {
                System.out.println(c);
            }
        }
    }
}
