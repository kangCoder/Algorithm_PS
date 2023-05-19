package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1003_피보나치함수 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int[][] fibonacci = new int[41][2];
        fibonacci[0][0] = 1;
        fibonacci[0][1] = 0;

        fibonacci[1][0] = 0;
        fibonacci[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
            fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(fibonacci[N][0] + " " + fibonacci[N][1]);
        }
    }
}
