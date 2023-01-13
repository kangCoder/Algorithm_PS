package backtracking.boj_15652_N과M4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N, M;
    public static int[] output;

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

        for (int i = 1; i <= N; i++) {
            output[length] = i;
            backTracking(length + 1);
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

        output = new int[M];
        backTracking(0);

        bw.flush();
    }

}
