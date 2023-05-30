package simulation;

import java.util.*;
import java.io.*;

public class soft_비밀메뉴 {

    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] secret = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            secret[i] = Integer.parseInt(st.nextToken());
        }

        int[] buttons = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buttons[i] = Integer.parseInt(st.nextToken());
        }

        if (M > N) {
            System.out.println("normal");
            return;
        }

        String ans = "normal";
        int left = 0;
        while (left < N - M + 1) {
            boolean isSuccess = true;

            for (int i = 0; i < M; i++) {
                if (secret[i] != buttons[left + i]) {
                    isSuccess = false;
                    break;
                }
            }

            if (isSuccess) {
                ans = "secret";
                break;
            }

            left++;
        }

        System.out.println(ans);
    }
}