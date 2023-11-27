package simulation;

import java.io.*;

public class boj_21869_MaximumBishop {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        bw.write((N > 1 ? 2 * N - 2 : 1) + "\n");
        for (int i = 1; i <= N; i++) {
            bw.write(i + " " + 1 + "\n"); //각 행의 첫 번째 열에 비숍을 다 깔아주고
            if (1 < i && i < N) {
                bw.write(i + " " + N + "\n"); //1행과 마지막 행을 제외한 행, 마지막 열에도 깔아주면 끝
            }
        }

        bw.flush();
    }
}