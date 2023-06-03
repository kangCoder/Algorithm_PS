package greedy;

import java.util.*;
import java.io.*;

public class boj_11501_주식 {

    static int T, N;
    static long ans;
    static int[] stocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            stocks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }
            ans = 0;

            //1. 뒤에서부터 읽으면서 최댓값을 갱신한다.
            int max = stocks[N - 1];
            Stack<Integer> s = new Stack<>();
            for (int i = N - 2; i >= 0; i--) {
                if (stocks[i] > max) {
                    max = stocks[i];
                    while (!s.isEmpty()) {
                        ans += s.pop();
                    }
                } else if (stocks[i] < max) {
                    s.push(max - stocks[i]);
                }
            }

            while (!s.isEmpty()) {
                ans += s.pop();
            }

            System.out.println(ans);
        }
    }
}