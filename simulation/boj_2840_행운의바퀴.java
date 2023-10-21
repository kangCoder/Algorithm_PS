package simulation;

import java.util.*;
import java.io.*;

public class boj_2840_행운의바퀴 {

    static int N, K; //바퀴 칸의 수, 바퀴를 돌리는 횟수
    static char[][] S; //S[i][j]: i=글자가 바뀐 횟수, j=회전을 멈췄을 때 글자
    static char[] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new char[N][2];
        for (int i = 0; i < K; i++) {
            String s = br.readLine();
            S[i][0] = s.charAt(0);
            S[i][1] = s.charAt(1);
        }

        origin = new char[N];
        origin[0] = S[N - 1][2];

    }

}
