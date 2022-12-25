package dp.boj_11057_오르막수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= 9; j++) {
                dp[i][j] += (dp[i][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        System.out.println(dp[N][9]);
    }
}
