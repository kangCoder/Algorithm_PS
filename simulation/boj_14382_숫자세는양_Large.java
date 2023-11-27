package simulation;

import java.io.*;

public class boj_14382_숫자세는양_Large {

    static int N;
    static boolean[] check;

    static void solve(String N) {
        for (int i = 0; i < N.length(); i++) {
            int n = Character.getNumericValue(N.charAt(i));
            check[n] = true;
        }
    }

    static boolean canSleep() {
        for (int i = 0; i <= 9; i++) {
            if (!check[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            check = new boolean[10];

            if (N == 0) {
                bw.write("Case #" + tc + ": " + "INSOMNIA" + "\n");
                continue;
            }

            int idx = 1;
            while (true) {
                String n = String.valueOf(N * idx++);
                solve(n);
                if (canSleep()) {
                    bw.write("Case #" + tc + ": " + n + "\n");
                    break;
                }
            }
        }
        bw.flush();
    }
}