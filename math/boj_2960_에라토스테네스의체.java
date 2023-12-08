package math;

import java.io.*;
import java.util.*;

public class boj_2960_에라토스테네스의체 {

    static int N, K;
    static boolean[] used;

    static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int solve() {
        int idx = 1;
        for (int i = 2; i <= N; i++) {
            if (!used[i] && isPrime(i)) {
                for (int j = i; j <= N; j += i) {
                    if (!used[j]) {
                        if (idx++ == K) {
                            return j;
                        }
                        used[j] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        used = new boolean[N + 1];

        System.out.println(solve());
    }

}
