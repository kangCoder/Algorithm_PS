package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2240_자두나무 {

    static int T, W, max = Integer.MIN_VALUE;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        trees = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[T + 1][W + 1][3];

        //첫 번째 떨어지는 자두의 위치가 1번 나무이면 움직이지 않아도 1개를 받고,
        //첫 번째 떨어지는 자두의 위치가 2번 나무이면 움직여야 1개를 받을 수 있다.
        if (trees[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0; //1번 움직여도 받을 수 있는 최댓값은 0개
        } else if (trees[1] == 2) {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1; //1번 움직였을 때 받을 수 있는 최댓값 1개
        }

        for (int i = 2; i <= T; i++) {
            if (trees[i] == 1) {
                dp[i][0][1] = dp[i - 1][0][1] + 1; //안움직여도 1번 나무에 있으면 1개가 추가
                dp[i][0][2] = dp[i - 1][0][2];

                for (int j = 1; j <= W; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                }
            } else if (trees[i] == 2) {
                dp[i][0][1] = dp[i - 1][0][1];
                dp[i][0][2] = dp[i - 1][0][2] + 1; //안움직여도 2번 나무에 있으면 1개가 추가

                for (int j = 1; j <= W; j++) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + 1;
                }
            }
        }

        for (int w = 0; w <= W; w++) {
            max = Math.max(max, Math.max(dp[T][w][1], dp[T][w][2]));
        }
        System.out.println(max);
    }
}
