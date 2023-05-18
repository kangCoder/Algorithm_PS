package dp;

import java.io.*;

public class boj_12852_1로만들기2 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1]; //dp[i]: i를 1로 만들 수 있는 최소 횟수
        int[] before = new int[N + 1]; //before[i]: i를 1로 만드는 최소 경로에서, i 전의 값
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            //제일 횟수가 많은게 -1
            dp[i] = dp[i - 1] + 1;
            before[i] = i - 1;

            //그 다음이 /2
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }

            //그 다음이 /3
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
        }

        bw.write(dp[N] + "\n");
        while (N > 0) {
            bw.write(N + " ");
            N = before[N];
        }

        bw.flush();
        bw.close();
    }
}