package 분할정복;

import java.io.*;
import java.util.*;

public class soft_수퍼바이러스 {

    static int K, P;
    static long N, ans = 0L;

    static long solve(long n, long p) {
        if (n == 1) {
            return p;
        }

        long tmp = solve(n / 2, p);

        if (n % 2 == 0) {
            return (tmp * tmp) % 1_000_000_007;
        } else {
            tmp *= tmp;
            tmp %= 1_000_000_007;
            return (tmp * p) % 1_000_000_007;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());
        N *= 10; //0.1초 당 P배씩 증가하므로 미리 *10하기.

        //그냥 for문 돌리면 N=10^17이라 시초남. 분할정복으로 logn 으로 처리
        ans = K * solve(N, P);

        System.out.println(ans % 1_000_000_007);
    }
}

