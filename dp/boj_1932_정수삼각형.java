package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1932_정수삼각형 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][N];
        for (int[] tri : triangle) {
            Arrays.fill(tri, -1);
        }
        for (int i = 0; i < triangle.length; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                triangle[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        if (N == 1) {
            System.out.println(triangle[0][0]);
            return;
        }

        int len = triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[0][0] + triangle[1][0];
        dp[1][1] = triangle[0][0] + triangle[1][1];

        for (int i = 2; i < len; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (triangle[i][j] == -1) {
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, dp[len - 1][i]);
        }

        System.out.println(ans);
    }
}