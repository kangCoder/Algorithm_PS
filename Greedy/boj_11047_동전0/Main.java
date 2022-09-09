package Greedy.boj_11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            count += K / A[i];
            K = K % A[i];
            if (K == 0) break;
        }

        System.out.println(count);
    }
}
