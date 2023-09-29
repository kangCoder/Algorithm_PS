package backtracking;

import java.util.*;
import java.io.*;

public class boj_1469_숌사이수열 {

    static int N;
    static boolean success = false;
    static int[] X, S, ans;
    static boolean[] used;

    static void backTracking(int length) {
        if (length == 2 * N) {
            for (int i : ans) {
                System.out.print(i + " ");
            }
            success = true;
            System.exit(0);
        }

        if (ans[length] != -1) {
            backTracking(length + 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i] && length + X[i] + 1 < N * 2 && ans[length] == -1 && ans[length + X[i] + 1] == -1) {
                used[i] = true;
                ans[length] = ans[length + X[i] + 1] = X[i];
                backTracking(length + 1);
                ans[length] = ans[length + X[i] + 1] = -1;
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        X = new int[N];
        used = new boolean[N];
        S = ans = new int[2 * N];
        Arrays.fill(ans, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < X.length; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(X);

        backTracking(0);

        if (!success) {
            System.out.println(-1);
        }
    }
}
