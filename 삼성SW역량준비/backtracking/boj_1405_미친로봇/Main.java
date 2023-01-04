package 삼성SW역량준비.backtracking.boj_1405_미친로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static double ans;
    public static double[] WASD; //0123이 순서대로 동서남북
    public static boolean[][] visited; //N의 최대 값이 15인데, 시작 지점을 (15, 15)라고 하면 움직일 수 있는 최대 좌표는 (30, 30)
    public static int[] dy = {0, 0, 1, -1};
    public static int[] dx = {1, -1, 0, 0};

    public static void backTracking(int depth, int x, int y, double probability) {
        if (depth == N) {
            ans += probability;
            return;
        }

        visited[y][x] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nextY = y + dy[dir];
            int nextX = x + dx[dir];

            if (nextX >= 0 && nextY >= 0 && nextX < 30 && nextY < 30) {
                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    backTracking(depth + 1, nextX, nextY, probability * WASD[dir]);
                    visited[nextY][nextX] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        WASD = new double[4];
        for (int i = 0; i < 4; i++) {
            WASD[i] = (double) Integer.parseInt(st.nextToken()) * 0.01;
        }

        visited = new boolean[30][30];
        ans = 0;
        backTracking(0, 15, 15, 1); //시작 확률은 1
        System.out.println(ans);
    }

}
