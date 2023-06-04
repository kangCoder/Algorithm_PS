package greedy;

import java.util.*;
import java.io.*;

public class boj_1026_보물 {

    static int N, S = 0;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Integer[] newB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(newB, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            S += A[i] * newB[i];
        }

        System.out.println(S);
    }
}