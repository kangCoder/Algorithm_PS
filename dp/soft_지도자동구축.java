package dp;

import java.util.*;
import java.io.*;

public class soft_지도자동구축 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1]; //한 변에 존재하는 점의 개수
        dp[0] = 2;

        for (int i = 1; i <= N; i++) {
            dp[i] = 2 * dp[i - 1] - 1;
        }

        System.out.println(dp[N] * dp[N]);
    }
}