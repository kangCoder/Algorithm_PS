package 삼성SW역량준비.tree.boj_9372_상근이의여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N, M; //국가 수, 비행기 수
    public static int[][] plane;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            plane = new int[N + 1][N + 1];
            for (int j = 0; j <= N; j++) {
                Arrays.fill(plane[j], -1);
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                plane[a][b] = 1;
                plane[b][a] = 1;
            }

            System.out.println(N - 1);
        }
    }

}
