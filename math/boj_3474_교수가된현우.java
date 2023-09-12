package math;

import java.io.*;

public class boj_3474_교수가된현우 {

    static int N;

    static int solve(int n) {
        //끝자리 0의 개수를 구하는 것 -> 10이 몇개가 있냐와 같음.
        //10 = 2x5 이므로 2x5가 몇 개 있는지 세면 된다.
        //N이 2를 몇 개 가지는지, 5를 몇 개 가지는지 세고 더 적은 쪽이 10의 개수이다.
        int two = 0, five = 0;

        int tmp = 2;
        while (tmp <= n) {
            two += n / tmp;
            tmp *= 2;
        }

        tmp = 5;
        while (tmp <= n) {
            five += n / tmp;
            tmp *= 5;
        }

        return Math.min(two, five);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(solve(N));
        }
    }

}
