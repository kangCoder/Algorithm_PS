package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2156_포도주시식 {

    static int n;
    static int[] glass, dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        glass = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            glass[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(glass[1]);
            return;
        } else if (n == 2) {
            System.out.println(glass[1] + glass[2]);
            return;
        }

        dp = new int[n + 1];
        dp[1] = glass[1];
        dp[2] = glass[1] + glass[2];


        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + glass[i], dp[i - 3] + glass[i - 1] + glass[i]));
        }

        System.out.println(dp[n]);
    }
}