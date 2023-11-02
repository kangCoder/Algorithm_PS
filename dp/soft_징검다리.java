package dp;

import java.io.*;
import java.util.*;

public class soft_징검다리 {

    static int N, ans = 0;
    static int[] A, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; //i번째 돌을 마지막으로 밟는다고 했을 때 밟을 수 있는 최대 개수. 처음엔 1로 초기화.
        }

        for (int i = 1; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    tmp = Math.max(tmp, dp[j]); //i번째로 오는 과정 중 최대 개수가 무엇인지 갱신
                }
            }

            dp[i] = tmp + 1;
        }

        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}