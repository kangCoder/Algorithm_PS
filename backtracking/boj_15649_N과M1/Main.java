package backtracking.boj_15649_N과M1;

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
            for (int i = 0; i < M; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                output[length] = i;

                isUsed[i] = true;
                backTracking(length + 1);
                isUsed[i] = false; //해당 수를 썼으면 다시 반납
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        output = new int[M]; //만들어질 수열
        isUsed = new boolean[N + 1]; //해당 수를 수열에 사용했는지 확인하는 배열

        backTracking(0);
    }
}
