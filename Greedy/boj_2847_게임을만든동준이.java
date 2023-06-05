package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2847_게임을만든동준이 {

    static int N, ans = 0;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        level = new int[N];
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        //뒤부터 돌면서 깎는다.
        for (int i = N - 1; i >= 1; i--) {
            if (level[i] <= level[i - 1]) {
                int decrease = level[i - 1] - level[i] + 1;
                if (level[i] == level[i - 1]) {
                    decrease = 1;
                }

                level[i - 1] = level[i] - 1;
                //System.out.println(level[i] + ", " + level[i - 1] + ", decrease=" + decrease);
                ans += decrease;
            }
        }
        System.out.println(ans);
    }
}