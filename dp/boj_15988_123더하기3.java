package dp;

import java.io.*;

public class boj_15988_123더하기3 {

    static final int MAX = 1_000_001;

    static int n;
    static long[][] dp = new long[MAX][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1][1] = 1;
        dp[2][1] = 1; //1+1
        dp[2][2] = 1; //2
        dp[3][1] = 2; //1+1+1, 2+1
        dp[3][2] = 1; //1+2
        dp[3][3] = 1; //3
        for (int i = 4; i < MAX; i++) {
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][2] + dp[i - 2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]) % 1_000_000_009;

        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1_000_000_009);
        }

    }

}
