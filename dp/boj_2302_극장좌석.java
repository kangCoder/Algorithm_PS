package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2302_극장좌석 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //VIP좌석이 없다고 생각하면 dp는 피보나치 수열이랑 같다.
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //VIP좌석이 들어가게 되면 달라진다.
        //만약 N=7이고 M=4이라면
        //1~3좌석에 앉는 경우 * 5~7좌석에 앉는 경우이므로 이걸 계산하면 된다.
        int before = 0, ans = dp[1]; //before: 이전 좌석
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            ans *= dp[vip - before - 1];
            before = vip;
        }
        ans *= dp[N - before]; //마지막 vip좌석에서 끝까지 남은 좌석 수

        System.out.println(ans);
    }
}