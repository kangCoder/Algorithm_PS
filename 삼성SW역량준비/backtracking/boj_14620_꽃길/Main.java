package 삼성SW역량준비.backtracking.boj_14620_꽃길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, minCost = Integer.MAX_VALUE;
    public static int[][] G;
    public static boolean[][] visited;
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static boolean checkVisited(int r, int c) {
        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + dy[dir];
            int nextC = c + dx[dir];
            if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N) {
                if (visited[nextR][nextC]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void visit(int r, int c, boolean flag) {
        visited[r][c] = flag;

        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + dy[dir];
            int nextC = c + dx[dir];
            if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N) {
                visited[nextR][nextC] = flag;
            }
        }
    }

    public static int getSum(int r, int c) {
        int sum = G[r][c];
        for (int dir = 0; dir < 4; dir++) {
            int nextR = r + dy[dir];
            int nextC = c + dx[dir];
            sum += G[nextR][nextC];
        }
        return sum;
    }

    public static void backTracking(int cnt, int sum) {
        if (cnt == 3) {
            //씨앗 3개를 모두 심었으면 최소 판별
            minCost = Math.min(minCost, sum);
            return;
        }

        //주변 상하좌우가 밖으로 나가면 안되기 때문에 0과 N-1은 보지 않아도 됨
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (!checkVisited(i, j)) {
                    visit(i, j, true); //해당 5칸을 방문
                    backTracking(cnt + 1, sum + getSum(i, j));
                    visit(i, j, false); //방문을 끝냈으면 다시 돌려놓기
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        G = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        backTracking(0, 0);
        System.out.println(minCost);
    }

}
