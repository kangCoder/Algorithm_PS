package 문자열;

import java.io.*;

public class boj_20944_팰린드롬척화비 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println("s");
        } else if (N == 2) {
            System.out.println("ss");
        } else {
            StringBuilder sb = new StringBuilder();
            if (N % 2 == 0) {
                sb.append("s".repeat(Math.max(0, N)));
            } else {
                sb.append("s".repeat(Math.max(0, N / 2)));
                sb.append("a");
                sb.append("s".repeat(Math.max(0, N - (N / 2 + 1))));
            }

            System.out.println(sb);
        }
    }
}
