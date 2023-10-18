package math;

import java.util.*;
import java.io.*;

public class boj_1359_복권 {

    static int N, M, K;

    static long combination(int a, int b) {
        int n = a, r = b;
        long nn = 1L, rr = 1L;
        while (r > 0) {
            nn *= n--;
            rr *= r--;
        }

        return nn / rr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long n1 = 0L, n2 = combination(N, M);

        //2명이 1~N 중에서 M개를 고르는데
        //그 중 K개의 수가 동일할 확률
        for (int i = K; i <= M; i++) {
            if (N - M < M - i) {
                continue;
            }

            n1 += combination(M, i) * combination(N - M, M - i);
        }

        System.out.println((double) n1 / n2);
    }
}
