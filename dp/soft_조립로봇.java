package dp;

import java.io.*;
import java.util.*;

public class soft_조립로봇 {

    static int N;
    static int[][] A, B, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N][2];
        B = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == N - 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[i][0] = a;
                B[i][0] = b;
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int aToB = Integer.parseInt(st.nextToken());
                int bToA = Integer.parseInt(st.nextToken());

                A[i][0] = a;
                A[i][1] = aToB;
                B[i][0] = b;
                B[i][1] = bToA;
            }
        }

        if (N == 1) {
            System.out.println(Math.min(A[0][0], B[0][0]));
            System.exit(0);
        }

        dp = new int[N][2]; //dp[i][0]: A에서 끝나는 경우, dp[i][1]: B에서 끝나는 경우
        dp[0][0] = A[0][0];
        dp[0][1] = B[0][0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = A[i][0] + Math.min(dp[i - 1][0],
                B[i - 1][1] + dp[i - 1][1]); //이전 A라인에서 넘어온 것과, B라인에서 바꿔 넘어온 것 중 최소 값 선택
            dp[i][1] = B[i][0] + Math.min(dp[i - 1][1], A[i - 1][1] + dp[i - 1][0]);
        }

        System.out.println(Math.min(dp[N - 1][0], dp[N - 1][1]));
    }
}

