package backtracking.boj_15650_N과M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] output;
    public static boolean[] isUsed;

    public static void backTracking(int length) {
        if (length == M) {
            if (isIncreased()) {
                for (int i : output) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                output[length] = i;

                backTracking(length + 1);

                isUsed[i] = false;
            }
        }

    }

    public static boolean isIncreased() {
        for (int i = 0; i < output.length - 1; i++) {
            if (output[i] > output[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M];
        isUsed = new boolean[N + 1];

        backTracking(0);
    }

}
