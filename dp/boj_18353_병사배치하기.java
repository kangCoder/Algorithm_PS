package dp;

import java.util.*;
import java.io.*;

public class boj_18353_병사배치하기 {

    static int N, ans = 0;
    static int[] soldiers, lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        soldiers = new int[N];
        lis = new int[N];
        for (int i = 0; i < N; i++) {
            soldiers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            lis[i] = 1; //기본적으로 i번째까지의 가장 긴 감소하는 부분 수열의 길이는 1
            for (int j = 0; j < i; j++) {
                if (soldiers[j] > soldiers[i]) {
                    //j번째보다 i번째가 작다는 것은 감소한다는 뜻
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }

            ans = Math.max(ans, lis[i]); //LIS의 길이 갱신
        }

        System.out.println(N - ans);
    }
}
