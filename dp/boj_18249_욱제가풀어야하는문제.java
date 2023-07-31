package dp;

import java.io.*;

public class boj_18249_욱제가풀어야하는문제 {

    static final int MAX = 191_230;

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        dp = new int[MAX];

        dp[1] = 1;
        dp[2] = 2; // (1-1, 2-2), (1-2, 2-1)
        for (int i = 3; i < MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }

}
