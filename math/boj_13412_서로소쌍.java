package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_13412_서로소쌍 {

    static int N, ans;

    static int gcd(int n, int m) {
        while (m != 0) {
            int tmp = m;
            m = n % m;
            n = tmp;
        }

        return n;
    }

    static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            N = Integer.parseInt(br.readLine());
            int half = Integer.MAX_VALUE;

            for (int i = 1; i <= N; i++) {
                //n*m=N을 만족하는 두 수를 완탐으로 찾는다.
                if (N % i == 0) {
                    int n = i;
                    int m = N / i;

                    //n이 절반이 넘어가면 더이상 찾을 필요 없다.
                    if (n >= half) {
                        break;
                    }

                    half = Math.min(half, m);
                    int gcd = gcd(n, m);
                    int lcm = lcm(n, m);

                    if (gcd == 1 && lcm == n * m) {
                        ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}