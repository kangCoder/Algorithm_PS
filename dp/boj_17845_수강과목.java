package dp;

import java.util.*;
import java.io.*;

public class boj_17845_수강과목 {

    static int N, K;
    static int[][] subjects, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        subjects = new int[K + 1][2];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            subjects[i][0] = Integer.parseInt(st.nextToken()); //중요도
            subjects[i][1] = Integer.parseInt(st.nextToken()); //필요 시간
        }

        //최대 공부시간 N시간, 과목 수 K개일 때 얻을 수 있는 최고 중요도
        dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                //i번째 과목의 필요시간이 최대 공부시간 j보다 작을 때
                if (subjects[i][1] <= j) {
                    //i-1번째 과목을 버리고 i번째 과목을 넣는 것이 중요도에서 이득인지 확인
                    dp[i][j] = Math.max(dp[i - 1][j - subjects[i][1]] + subjects[i][0], dp[i - 1][j]);
                } else {
                    //필요시간 초과면 그냥 넘어가기
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
