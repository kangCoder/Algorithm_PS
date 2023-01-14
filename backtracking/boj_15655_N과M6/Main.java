package backtracking.boj_15655_N과M6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N, M;
    public static int[] input, output;
    public static boolean[] isUsed;

    public static void backTracking(int length) throws IOException {
        if (length == M) {
            if (isIncreased()) {
                for (int i : output) {
                    bw.write(i + " ");
                }
                bw.newLine();
            }
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!isUsed[i]) {
                output[length] = input[i];
                isUsed[i] = true;
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
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        output = new int[M];
        isUsed = new boolean[N];
        backTracking(0);

        bw.flush();
    }

}
