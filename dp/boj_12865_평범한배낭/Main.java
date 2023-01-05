package dp.boj_12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int WEIGHT = 0, VALUE = 1;
    public static int N, K;
    public static int[][] item;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //물건의 개수
        K = Integer.parseInt(st.nextToken()); //버틸 수 있는 최대 무게

        item = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][WEIGHT] = Integer.parseInt(st.nextToken());
            item[i][VALUE] = Integer.parseInt(st.nextToken());
        }

        //dp[i][j]: i개의 물건과 j의 무게 한도일 때의 최적의 이익
        dp = new int[N + 1][K + 1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= K; w++) {
                //n번째 물건의 무게가 최대 한도보다 작다면
                if (item[n][WEIGHT] <= w) {
                    //n-1번째 물건을 빼고 n번째 물건을 넣는 것이 n-1번째 물건을 유지하는 것보다 value가 더 높은 경우
                    if ((item[n][VALUE] + dp[n - 1][w - item[n][WEIGHT]]) > dp[n - 1][w]) {
                        dp[n][w] = item[n][VALUE] + dp[n - 1][w - item[n][WEIGHT]];
                    } else {
                        //그렇지 않은 경우 n-1번째 물건을 유지
                        dp[n][w] = dp[n - 1][w];
                    }
                } else {
                    //n번째 물건의 무게가 최대 한도를 넘는 경우 n번째 물건은 건너뛴다
                    dp[n][w] = dp[n - 1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

}
