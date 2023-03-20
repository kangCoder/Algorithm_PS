package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9663_NQueen {

    public static int N, cnt;
    public static boolean[] isUsed1, isUsed2, isUsed3; //가로, 대각선1, 대각선2

    public static void backTracking(int cur) {
        if (cur == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isUsed1[i] || isUsed2[i + cur] || isUsed3[cur - i + N - 1]) {
                continue;
            }

            isUsed1[i] = true;
            isUsed2[i + cur] = true;
            isUsed3[cur - i + N - 1] = true;
            backTracking(cur + 1);
            isUsed1[i] = false;
            isUsed2[i + cur] = false;
            isUsed3[cur - i + N - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isUsed1 = new boolean[N * 2];
        isUsed2 = new boolean[N * 2];
        isUsed3 = new boolean[N * 2];

        cnt = 0;
        backTracking(0);

        System.out.println(cnt);
    }

}
