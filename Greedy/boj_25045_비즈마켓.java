package greedy;

import java.util.*;
import java.io.*;

public class boj_25045_비즈마켓 {

    static int N, M;
    static long sum = 0L;
    static Long[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new Long[N];
        B = new Long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        int min = Math.min(N, M);
        for (int i = 0; i < min; i++) {
            if (A[i] - B[i] >= 0) {
                sum += A[i] - B[i];
            }
        }

        System.out.println(sum);
    }
}
