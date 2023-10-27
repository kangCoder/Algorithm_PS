package simulation;

import java.io.*;

public class boj_1668_트로피진열 {

    static int N;
    static int[] trophy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        trophy = new int[N];
        for (int i = 0; i < trophy.length; i++) {
            trophy[i] = Integer.parseInt(br.readLine());
        }

        int lAns = 0, rAns = 0;
        int left = 0, right = 0;
        for (int i = 0; i < trophy.length; i++) {
            if (left < trophy[i]) {
                lAns++;
                left = trophy[i];
            }
        }
        for (int i = trophy.length - 1; i >= 0; i--) {
            if (right < trophy[i]) {
                rAns++;
                right = trophy[i];
            }
        }

        System.out.println(lAns);
        System.out.println(rAns);
    }
}
