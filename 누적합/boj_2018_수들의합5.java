package 누적합;

import java.io.*;

public class boj_2018_수들의합5 {

    static int N, L = 1, R = 1, sum = 0, ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        while (L <= R && R <= N) {
            if (sum < N) {
                sum += R++;
            } else {
                if (sum == N) {
                    ans++;
                }
                sum -= L++;
            }
        }

        System.out.println(ans);
    }
}
