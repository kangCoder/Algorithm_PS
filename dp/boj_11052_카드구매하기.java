package dp;

import java.util.*;
import java.io.*;

public class boj_11052_카드구매하기 {

    static int N;
    static int[] P, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        P = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                //1번 카드 구매 확정 -> n-1개 사기
                //2번 카드 구매 확정 -> n-2개 사기
                //n-1번 카드 구매 확정 -> 1개 사기
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}